import java.util.Arrays;

public class UniqueNumbersTwo {
    public static int[] findTwoUnique(int[] arr) {
        int xor_all = 0;
        for (int num : arr) {
            xor_all ^= num;
        }

        // Get rightmost set bit
        int set_bit = xor_all & (-xor_all);

        int num1 = 0, num2 = 0;
        for (int num : arr) {
            if ((num & set_bit) != 0)
                num1 ^= num;
            else
                num2 ^= num;
        }

        // Return in increasing order
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 1, 4};
        System.out.println(Arrays.toString(findTwoUnique(arr1))); // Output: [3, 4]

        int[] arr2 = {2, 1, 3, 2};
        System.out.println(Arrays.toString(findTwoUnique(arr2))); // Output: [1, 3]
    }
}
