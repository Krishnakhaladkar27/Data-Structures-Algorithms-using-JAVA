//You are given an integer array arr[]. You need to find the maximum sum of a subarray (containing at least one element) in the array arr[].
import java.util.*;

public class Solution {

    public static int kadane(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, -8, 7, -1, 2, 3};
        int[] arr2 = {-2, -4};
        int[] arr3 = {5, 4, 1, 7, 8};

        System.out.println(kadane(arr1)); // Output: 11
        System.out.println(kadane(arr2)); // Output: -2
        System.out.println(kadane(arr3)); // Output: 25
    }
}
