public class FindRepetitive {
    public static int findRepetitive(int[] arr) {
        int n = arr.length;
        int sum_n_1 = (n - 1) * n / 2;
        int sum_arr = 0;
        for (int num : arr) {
            sum_arr += num;
        }
        return sum_arr - sum_n_1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 2, 3, 4};
        System.out.println(findRepetitive(arr1)); // Output: 3

        int[] arr2 = {1, 5, 1, 2, 3, 4};
        System.out.println(findRepetitive(arr2)); // Output: 1

        int[] arr3 = {1, 1};
        System.out.println(findRepetitive(arr3)); // Output: 1
    }
}
