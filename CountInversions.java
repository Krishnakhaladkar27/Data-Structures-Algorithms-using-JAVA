class Solution {
    public static long inversionCount(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n]; // temporary array
        return mergeSort(arr, temp, 0, n - 1);
    }

    private static long mergeSort(int[] arr, int[] temp, int left, int right) {
        long invCount = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;

            invCount += mergeSort(arr, temp, left, mid);
            invCount += mergeSort(arr, temp, mid + 1, right);
            invCount += merge(arr, temp, left, mid, right);
        }
        return invCount;
    }

    private static long merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;       // pointer for left subarray
        int j = mid + 1;    // pointer for right subarray
        int k = left;       // pointer for temp array
        long invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1); // all remaining elements in left subarray
            }
        }

        // Copy remaining elements of left subarray
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements of right subarray
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy back to original array
        for (int idx = left; idx <= right; idx++) {
            arr[idx] = temp[idx];
        }

        return invCount;
    }
}
