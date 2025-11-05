class Solution {
    public static int CountWays(String digits) {
        int n = digits.length();
        if (n == 0 || digits.charAt(0) == '0') return 0;
        
        int prev2 = 1, prev = 1;
        
        for (int i = 1; i < n; i++) {
            int curr = 0;
            
            // Check single digit
            if (digits.charAt(i) != '0')
                curr += prev;
            
            // Check two-digit validity
            int twoDigit = Integer.parseInt(digits.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26)
                curr += prev2;
            
            prev2 = prev;
            prev = curr;
        }
        
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(CountWays("123"));  // Output: 3
        System.out.println(CountWays("90"));   // Output: 0
        System.out.println(CountWays("05"));   // Output: 0
    }
}
