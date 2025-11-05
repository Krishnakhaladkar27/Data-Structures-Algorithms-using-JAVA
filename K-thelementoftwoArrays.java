class Solution {
    public int kthElement(int[] a, int[] b, int k) {
        int n = a.length;
        int m = b.length;

        // Always binary search on smaller array
        if (n > m) return kthElement(b, a, k);

        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {
            int cutA = low + (high - low) / 2;
            int cutB = k - cutA;

            // Prevent invalid cut positions
            if (cutB < 0) {
                high = cutA - 1;
                continue;
            }
            if (cutB > m) {
                low = cutA + 1;
                continue;
            }

            // Compute border elements safely
            int leftA = (cutA <= 0) ? Integer.MIN_VALUE : a[cutA - 1];
            int leftB = (cutB <= 0) ? Integer.MIN_VALUE : b[cutB - 1];
            int rightA = (cutA >= n) ? Integer.MAX_VALUE : a[cutA];
            int rightB = (cutB >= m) ? Integer.MAX_VALUE : b[cutB];

            // Valid partition found
            if (leftA <= rightB && leftB <= rightA) {
                return Math.max(leftA, leftB);
            }
            // Move search boundaries
            else if (leftA > rightB) {
                high = cutA - 1;
            } else {
                low = cutA + 1;
            }
        }

        // Should never reach here with valid input
        return -1;
    }
}

