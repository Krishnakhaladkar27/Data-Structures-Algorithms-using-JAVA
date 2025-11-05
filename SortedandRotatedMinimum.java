class Solution {
    // Method name must match GFG driver
    public int findMin(int[] arr, int n) {
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is greater than the last element,
            // the minimum is in the right half
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                // Minimum is in the left half including mid
                high = mid;
            }
        }

        // When loop ends, low == high pointing to the minimum
        return arr[low];
    }
}
