import java.util.*;

class Solution {
    public static int longestStrChain(String[] words) {
        // Sort words by length
        Arrays.sort(words, Comparator.comparingInt(String::length));

        Map<String, Integer> dp = new HashMap<>();
        int maxChain = 1;

        for (String word : words) {
            int best = 1; // at least the word itself
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String prev = sb.toString();

                if (dp.containsKey(prev)) {
                    best = Math.max(best, dp.get(prev) + 1);
                }
            }
            dp.put(word, best);
            maxChain = Math.max(maxChain, best);
        }

        return maxChain;
    }

    public static void main(String[] args) {
        String[] words1 = {"ba", "b", "a", "bca", "bda", "bdca"};
        System.out.println(longestStrChain(words1)); // Output: 4

        String[] words2 = {"abc", "a", "ab"};
        System.out.println(longestStrChain(words2)); // Output: 3

        String[] words3 = {"abcd", "dbqca"};
        System.out.println(longestStrChain(words3)); // Output: 1
    }
}
