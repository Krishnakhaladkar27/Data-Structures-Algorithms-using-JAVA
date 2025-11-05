class Solution {
    public static int FindMaxSum(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];
        
        // Exclude last house
        int case1 = robLinear(arr, 0, n - 2);
        // Exclude first house
        int case2 = robLinear(arr, 1, n - 1);
        
        return Math.max(case1, case2);
    }
    
    private static int robLinear(int[] arr, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;
        
        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, arr[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 2};
        System.out.println(FindMaxSum(arr1)); // Output: 3
        
        int[] arr2 = {1, 2, 3, 1};
        System.out.println(FindMaxSum(arr2)); // Output: 4
        
        int[] arr3 = {2, 2, 3, 1, 2};
        System.out.println(FindMaxSum(arr3)); // Output: 5
    }
}
