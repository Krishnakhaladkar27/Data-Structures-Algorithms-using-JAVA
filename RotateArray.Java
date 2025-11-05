//Given an array arr[]. Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer. Do the mentioned change in the array in place.
import java.util.*;

public class RotateArray {
    public static void rotateLeft(int[] arr, int d) {
        int n = arr.length;
        d = d % n; 

        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        rotateLeft(arr1, 2);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        rotateLeft(arr2, 3);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {7, 3, 9, 1};
        rotateLeft(arr3, 9);
        System.out.println(Arrays.toString(arr3));
    }
}
