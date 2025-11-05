import java.util.*;

class Solution {
    // Function to check if brackets are balanced
    public static boolean ispar(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } 
            // Handle closing brackets
            else {
                // No matching opening bracket
                if (st.isEmpty()) return false;

                char top = st.pop();

                // Check for matching pair
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Expression is balanced if stack is empty
        return st.isEmpty();
    }
}
