//You are given a circular array arr[] of integers, find the maximum possible sum of a non-empty subarray. In a circular array, the subarray can start at the end and wrap around to the beginning. Return the maximum non-empty subarray sum, considering both non-wrapping and wrapping cases.
import java.util.*;

public class Solution {

    // Standard Kadane's algorithm for max subarray sum
    public static int kadaneMax(int[] arr) {
        int maxEndingHere = arr[0], maxSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    // Kadane's for minimum subarray sum
    public static int kadaneMin(int[] arr) {
        int minEndingHere = arr[0], minSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            minEndingHere = Math.min(arr[i], minEndingHere + arr[i]);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }
        return minSoFar;
    }

    public static int maxCircularSubarraySum(int[] arr) {
        int maxNormal = kadaneMax(arr);
        int totalSum = Arrays.stream(arr).sum();
        int minSubarraySum = kadaneMin(arr);

        int maxCircular = totalSum - minSubarraySum;

        // Edge case: all numbers are negative
        if (maxCircular == 0) return maxNormal;

        return Math.max(maxNormal, maxCircular);
    }

    public static void main(String[] args) {
        int[] arr1 = {8, -8, 9, -9, 10, -11, 12};
        int[] arr2 = {10, -3, -4, 7, 6, 5, -4, -1};
        int[] arr3 = {5, -2, 3, 4};

        System.out.println(maxCircularSubarraySum(arr1)); // 22
        System.out.println(maxCircularSubarraySum(arr2)); // 23
        System.out.println(maxCircularSubarraySum(arr3)); // 12
    }
}
