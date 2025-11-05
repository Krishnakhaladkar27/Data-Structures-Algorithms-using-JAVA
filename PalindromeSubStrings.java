class Solution {
    public static int countPS(String s) {
        int n = s.length();
        int count = 0;

        for (int center = 0; center < n; center++) {
            // Odd-length palindromes
            count += expandAroundCenter(s, center, center);
            // Even-length palindromes
            count += expandAroundCenter(s, center, center + 1);
        }
        return count;
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 >= 2) count++;
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPS("abaab"));   // Output: 3
        System.out.println(countPS("aaa"));     // Output: 3
        System.out.println(countPS("abbaeae")); // Output: 4
    }
}
