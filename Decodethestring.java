import java.util.*;

class Solution {
    public static String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build the full number (may be multi-digit)
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push current state and reset
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Decode substring
                StringBuilder decoded = stringStack.pop();
                int repeatCount = countStack.pop();
                decoded.append(current.toString().repeat(repeatCount));
                current = decoded;
            } else {
                // Regular character
                current.append(ch);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {
        String s1 = "3[b2[ca]]";
        System.out.println(decodeString(s1)); 

        String s2 = "3[ab]";
        System.out.println(decodeString(s2)); 
    }
}
