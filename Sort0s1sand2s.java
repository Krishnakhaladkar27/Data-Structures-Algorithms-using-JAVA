//Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
class Solution {
    public static void sort012(int[] arr) {
        int low = 0;           // pointer for 0s
        int mid = 0;           // current element pointer
        int high = arr.length - 1;  // pointer for 2s

        // Traverse the array
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // swap arr[low] and arr[mid]
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    // swap arr[mid] and arr[high]
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                    break;
            }
        }
    }
}
