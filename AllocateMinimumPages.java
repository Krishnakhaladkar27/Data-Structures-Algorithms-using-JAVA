class Solution {

    // Helper function to check if it is possible to allocate books
    static boolean isPossible(int[] arr, int n, int k, int maxPages) {
        int students = 1;
        int pagesSum = 0;

        for (int pages : arr) {
            if (pages > maxPages)
                return false;

            if (pagesSum + pages > maxPages) {
                students++;
                pagesSum = pages;
                if (students > k)
                    return false;
            } else {
                pagesSum += pages;
            }
        }
        return true;
    }

    // Function to find the minimum number of pages
    static int findPages(int[] arr, int n, int k) {
        if (k > n)
            return -1;

        int low = 0, high = 0;
        for (int pages : arr) {
            high += pages;
            low = Math.max(low, pages);
        }

        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, n, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}
