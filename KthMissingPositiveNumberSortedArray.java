class Solution {

    // Main function to find the kth missing positive number
    static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n - 1;

        // Binary search to find the position
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Count of missing numbers until arr[mid]
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // The kth missing number is just after index 'high'
        return high + 1 + k;
    }
}
