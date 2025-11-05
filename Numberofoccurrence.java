class Solution {
    // Method name must match GFG driver
    public int countFreq(int[] arr, int x) {
        int n = arr.length; // define n
        int first = firstOccurrence(arr, n, x);
        if (first == -1) return 0; // target not present
        int last = lastOccurrence(arr, n, x);
        return last - first + 1;
    }

    private int firstOccurrence(int[] arr, int n, int x) {
        int low = 0, high = n - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result = mid;
                high = mid - 1; // search left
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private int lastOccurrence(int[] arr, int n, int x) {
        int low = 0, high = n - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result = mid;
                low = mid + 1; // search right
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
