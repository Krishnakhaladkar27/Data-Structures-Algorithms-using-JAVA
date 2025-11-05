//Given an array arr[] denoting heights of n towers and a positive integer k.
import java.util.*;

public class Solution {

    public static int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) return 0;

        Arrays.sort(arr); // Step 1: Sort

        int ans = arr[n - 1] - arr[0]; // Initial difference

        for (int i = 1; i < n; i++) {
            int max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            int min = Math.min(arr[0] + k, arr[i] - k);

            if (min < 0) continue; // Skip negative heights

            ans = Math.min(ans, max - min);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 8, 10};
        int k1 = 2;

        int[] arr2 = {3, 9, 12, 16, 20};
        int k2 = 3;

        System.out.println(getMinDiff(arr1, k1)); // Output: 5
        System.out.println(getMinDiff(arr2, k2)); // Output: 11
    }
}
