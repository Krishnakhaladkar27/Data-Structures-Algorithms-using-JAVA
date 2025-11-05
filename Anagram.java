//Given two non-empty strings s1 and s2, consisting only of lowercase English letters, determine whether they are anagrams of each other or not.
class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        // If lengths differ, they cannot be anagrams
        if (s1.length() != s2.length())
            return false;

        // Array to count character frequencies (26 lowercase letters)
        int[] count = new int[26];

        // Increment for s1, decrement for s2
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        // If any count != 0, not an anagram
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                return false;
        }

        return true;
    }
}
