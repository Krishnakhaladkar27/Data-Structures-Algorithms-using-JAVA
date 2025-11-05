class Solution {
    public static boolean areRotations(String s1, String s2) {
        // Step 1: Check if lengths are equal
        if (s1.length() != s2.length()) return false;

        // Step 2: Concatenate s1 with itself
        String temp = s1 + s1;

        // Step 3: Check if s2 is a substring of temp
        return temp.contains(s2);
    }
}
