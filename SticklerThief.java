class Solution {
    // Function to find the maximum amount of money the thief can loot
    public static int FindMaxSum(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        
        int prev2 = arr[0];
        int prev1 = Math.max(arr[0], arr[1]);
        
        for (int i = 2; i < n; i++) {
            int curr = Math.max(prev1, arr[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr1 = {6, 7, 1, 3, 8, 2, 4};
        System.out.println(FindMaxSum(arr1)); // Output: 19

        int[] arr2 = {5, 3, 4, 11, 2};
        System.out.println(FindMaxSum(arr2)); // Output: 16
    }
}
