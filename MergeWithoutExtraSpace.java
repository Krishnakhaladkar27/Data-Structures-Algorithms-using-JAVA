class Solution {
    public void mergeArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int gap = nextGap(n + m);

        while (gap > 0) {
            int i = 0;
            int j = gap;

            while (j < n + m) {
                int val1 = (i < n) ? a[i] : b[i - n];
                int val2 = (j < n) ? a[j] : b[j - n];

                if (val1 > val2) {
                    if (i < n && j < n) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    } else if (i < n && j >= n) {
                        int temp = a[i];
                        a[i] = b[j - n];
                        b[j - n] = temp;
                    } else {
                        int temp = b[i - n];
                        b[i - n] = b[j - n];
                        b[j - n] = temp;
                    }
                }

                i++;
                j++;
            }

            gap = nextGap(gap);
        }
    }

    private int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }
}
