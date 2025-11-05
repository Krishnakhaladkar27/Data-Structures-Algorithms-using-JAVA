import java.util.*;

class Solution {
    public static int longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        List<Integer> tails = new ArrayList<>();

        for (int num : arr) {
            int idx = Collections.binarySearch(tails, num);
            if (idx < 0) idx = -(idx + 1); // insertion point

            if (idx == tails.size())
                tails.add(num); // extend LIS
            else
                tails.set(idx, num); // replace to maintain smaller tail
        }

        return tails.size();
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 8, 3, 7, 9, 1};
        System.out.println(longestIncreasingSubsequence(arr1)); // Output: 3

        int[] arr2 = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(longestIncreasingSubsequence(arr2)); // Output: 6

        int[] arr3 = {3, 10, 2, 1, 20};
        System.out.println(longestIncreasingSubsequence(arr3)); // Output: 3
    }
}
