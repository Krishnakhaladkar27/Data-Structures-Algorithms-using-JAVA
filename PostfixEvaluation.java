import java.util.*;

class Solution {
    public static int evaluatePostfix(String[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : arr) {
            // If it's a number, push to stack
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                // Pop two operands
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;

                // Apply operator
                switch (token) {
                    case "+" -> result = a + b;
                    case "-" -> result = a - b;
                    case "*" -> result = a * b;
                    case "/" -> result = a / b;  // Java handles floor division for negatives correctly
                    case "^" -> result = (int) Math.pow(a, b);
                    default -> throw new IllegalArgumentException("Invalid operator: " + token);
                }
                // Push result back
                stack.push(result);
            }
        }
        // Final result on top of stack
        return stack.pop();
    }

    // Helper function to check if token is a number
    private static boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;
        if (s.charAt(0) == '-' && s.length() > 1) return s.substring(1).chars().allMatch(Character::isDigit);
        return s.chars().allMatch(Character::isDigit);
    }

    // Driver code
    public static void main(String[] args) {
        String[] arr1 = {"2", "3", "1", "*", "+", "9", "-"};
        System.out.println(evaluatePostfix(arr1)); // Output: -4

        String[] arr2 = {"2", "3", "^", "1", "+"};
        System.out.println(evaluatePostfix(arr2)); // Output: 9
    }
}
