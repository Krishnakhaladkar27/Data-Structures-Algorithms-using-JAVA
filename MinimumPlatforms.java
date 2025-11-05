import java.util.*;

class Solution {
    public static int findMinPlatforms(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;
        int i = 1, j = 0; // start from second arrival
        int platform_needed = 1, max_platforms = 1;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                // New train arrives before the earliest departs
                platform_needed++;
                i++;
            } else {
                // Train departs freeing a platform
                platform_needed--;
                j++;
            }
            max_platforms = Math.max(max_platforms, platform_needed);
        }

        return max_platforms;
    }

    public static void main(String[] args) {
        int[] arr1 = {900, 940, 950, 1100, 1500, 1800};
        int[] dep1 = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findMinPlatforms(arr1, dep1)); // 3

        int[] arr2 = {900, 1235, 1100};
        int[] dep2 = {1000, 1240, 1200};
        System.out.println(findMinPlatforms(arr2, dep2)); // 1

        int[] arr3 = {1000, 935, 1100};
        int[] dep3 = {1200, 1240, 1130};
        System.out.println(findMinPlatforms(arr3, dep3)); // 3
    }
}
