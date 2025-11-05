import java.util.*;

class Solution {
    public static List<String> findPermutations(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;

        char[] chars = s.toCharArray();
        Arrays.sort(chars); // sort to handle duplicates
        boolean[] used = new boolean[chars.length];
        StringBuilder path = new StringBuilder();

        backtrack(chars, used, path, result);
        return result;
    }

    private static void backtrack(char[] chars, boolean[] used, StringBuilder path, List<String> result) {
        if (path.length() == chars.length) {
            result.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;

            // Skip duplicates
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            path.append(chars[i]);
            backtrack(chars, used, path, result);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }
}
