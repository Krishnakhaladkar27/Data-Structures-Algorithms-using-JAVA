public class MissingInArray {
    public static int missingNumber(int[] arr) {
        int n = arr.length + 1; // since one element is missing
        int sum_n = n * (n + 1) / 2;
        int sum_arr = 0;
        for (int num : arr) {
            sum_arr += num;
        }
        return sum_n - sum_arr;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5};
        System.out.println(missingNumber(arr1)); // Output: 4

        int[] arr2 = {8, 2, 4, 5, 3, 7, 1};
        System.out.println(missingNumber(arr2)); // Output: 6

        int[] arr3 = {1};
        System.out.println(missingNumber(arr3)); // Output: 2
    }
}
