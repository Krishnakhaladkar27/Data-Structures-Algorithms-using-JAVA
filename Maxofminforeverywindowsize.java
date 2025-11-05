import java.util.*;

class Solution {
    // Function to find maximum of minimum for every window size
    public static int[] maxOfMin(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];   // Previous smaller element indices
        int[] right = new int[n];  // Next smaller element indices
        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        Deque<Integer> stack = new ArrayDeque<>();

        // Find previous smaller elements
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            if (!stack.isEmpty())
                left[i] = stack.peek();
            stack.push(i);
        }

        // Clear stack for next pass
        stack.clear();

        // Find next smaller elements
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            if (!stack.isEmpty())
                right[i] = stack.peek();
            stack.push(i);
        }

        // result[i] stores max of min for window size i+1
        int[] result = new int[n];
        Arrays.fill(result, Integer.MIN_VALUE);

        // Compute lengths and populate result
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;  // window size
            result[len - 1] = Math.max(result[len - 1], arr[i]);
        }

        // Fill the remaining entries (monotonic decrease)
        for (int i = n - 2; i >= 0; i--) {
            result[i] = Math.max(result[i], result[i + 1]);
        }

        return result;
    }
}
