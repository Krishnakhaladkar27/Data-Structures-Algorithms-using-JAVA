import java.util.*;

class Solution {
    // Function to find largest rectangular area in a histogram
    public static int getMaxArea(long[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        long maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                long height = arr[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                long area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            long height = arr[stack.pop()];
            int width = stack.isEmpty() ? n : (n - stack.peek() - 1);
            long area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return (int) maxArea; // cast to int since GfG expects int return type
    }
}
