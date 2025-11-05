class Solution {
    public static char nonRepeatingChar(String s) {
        int[] freq = new int[26]; // for lowercase English letters

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Find the first character with frequency = 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }

        // If no non-repeating character found
        return '$';
    }
}
