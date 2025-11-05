class Solution {
    public int search(int[] arr, int key) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

           
            if (arr[mid] == key) return mid;
            if (arr[low] <= arr[mid]) {
                
                if (key >= arr[low] && key < arr[mid]) {
                    high = mid - 1; // search in left half
                } else {
                    low = mid + 1; // search in right half
                }
            } else {
                // Right half is sorted
                if (key > arr[mid] && key <= arr[high]) {
                    low = mid + 1; // search in right half
                } else {
                    high = mid - 1; // search in left half
                }
            }
        }

        // Key not found
        return -1;
    }
}
