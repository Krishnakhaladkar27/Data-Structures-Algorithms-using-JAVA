class Solution {
    public int peakElement(int[] arr, int n) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean leftOk = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean rightOk = (mid == n - 1) || (arr[mid] > arr[mid + 1]);

            if (leftOk && rightOk) {
                // mid is a peak
                return mid;
            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                // peak is in left half
                high = mid - 1;
            } else {
                // peak is in right half
                low = mid + 1;
            }
        }

        // Should never reach here if array has at least 1 element
        return -1;
    }
}
