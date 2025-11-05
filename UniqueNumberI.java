public class UniqueNumber {
    public static int findUnique(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 1, 5, 5};
        System.out.println(findUnique(arr1)); // Output: 2

        int[] arr2 = {2, 30, 2, 15, 20, 30, 15};
        System.out.println(findUnique(arr2)); // Output: 20
    }
}
