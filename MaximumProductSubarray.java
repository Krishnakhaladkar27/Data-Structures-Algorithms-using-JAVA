//Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr[].
import java.util.*;

public class Solution {

    public static int maxProductSubarray(int[] arr) {
        int n = arr.length;
        int maxEndingHere = arr[0];
        int minEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < n; i++) {
            int num = arr[i];

            if (num < 0) {
                // Swap max and min when negative
                int temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }

            maxEndingHere = Math.max(num, num * maxEndingHere);
            minEndingHere = Math.min(num, num * minEndingHere);

            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr1 = {-2, 6, -3, -10, 0, 2};
        int[] arr2 = {-1, -3, -10, 0, 6};
        int[] arr3 = {2, 3, 4};

        System.out.println(maxProductSubarray(arr1)); // Output: 180
        System.out.println(maxProductSubarray(arr2)); // Output: 30
        System.out.println(maxProductSubarray(arr3)); // Output: 24
    }
}
