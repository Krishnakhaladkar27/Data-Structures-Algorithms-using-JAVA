import java.util.*;

class Solution {
    public int longestUniqueSubsttr(String s) {
        int n = s.length();
        int maxLen = 0;
        int start = 0;

        Map<Character, Integer> lastIndex = new HashMap<>();

        for (int end = 0; end < n; end++) {
            char ch = s.charAt(end);

            // If char seen before, move start just after its previous index
            if (lastIndex.containsKey(ch)) {
                start = Math.max(start, lastIndex.get(ch) + 1);
            }

            // Update last seen index of current char
            lastIndex.put(ch, end);

            // Calculate max window length
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}
