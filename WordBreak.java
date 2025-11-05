import java.util.*;

class Solution {
    public static boolean wordBreak(String s, List<String> dictionary) {
        Set<String> dict = new HashSet<>(dictionary);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // base case: empty string is always valid

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        List<String> dict1 = Arrays.asList("i", "like", "gfg");
        System.out.println(wordBreak("ilike", dict1)); // true

        List<String> dict2 = Arrays.asList("i", "like", "man", "india", "gfg");
        System.out.println(wordBreak("ilikegfg", dict2)); // true

        List<String> dict3 = Arrays.asList("i", "like", "man", "india", "gfg");
        System.out.println(wordBreak("ilikemangoes", dict3)); // false
    }
}
