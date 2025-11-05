import java.util.*;

class Solution {
    // Function to calculate stock span values for each day
    public static ArrayList<Integer> calculateSpan(int[] arr, int n) {
        ArrayList<Integer> span = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // Pop elements while current price >= price at stack top
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            // If stack is empty, span is i + 1
            int currSpan = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            span.add(currSpan);

            // Push current index
            stack.push(i);
        }

        return span;
    }
}
