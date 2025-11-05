class Solution {
    public static int minJumps(int[] arr) {
        int n = arr.length;

        // Edge cases
        if (n <= 1) return 0;
        if (arr[0] == 0) return -1;

        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;

        for (int i = 1; i < n; i++) {
            // If we’ve reached the end
            if (i == n - 1) return jumps;

            // Update the maximum reach
            maxReach = Math.max(maxReach, i + arr[i]);

            // Use a step
            steps--;

            // If no steps left, we must jump
            if (steps == 0) {
                jumps++;

                // Check if this position is unreachable
                if (i >= maxReach) return -1;

                // Reinitialize steps for the next jump
                steps = maxReach - i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(arr1)); // Output: 3

        int[] arr2 = {1, 4, 3, 2, 6, 7};
        System.out.println(minJumps(arr2)); // Output: 2

        int[] arr3 = {0, 10, 20};
        System.out.println(minJumps(arr3)); // Output: -1
    }
}
