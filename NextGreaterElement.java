import java.util.*;

class Solution {
    // Function to find the next greater element for each element of the array
    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Deque<Integer> stack = new ArrayDeque<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];

            // Pop all smaller or equal elements
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // If stack not empty, top is next greater
            if (!stack.isEmpty()) {
                result.set(i, stack.peek());
            }

            // Push current element
            stack.push(current);
        }

        return result;
    }
}
