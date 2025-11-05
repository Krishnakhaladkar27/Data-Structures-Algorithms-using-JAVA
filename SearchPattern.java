//Given two strings, one is a text string txt and the other is a pattern string pat. The task is to print the indexes of all the occurrences of the pattern string in the text string. Use 0-based indexing while returning the indices.
import java.util.*;

class Solution {
    public static ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();

        int n = txt.length();
        int m = pat.length();
        int[] lps = new int[m];
        computeLPSArray(pat, m, lps);

        int i = 0; 
        int j = 0; 

        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                result.add(i - j);
                j = lps[j - 1]; 
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }
    private static void computeLPSArray(String pat, int m, int[] lps) {
        int len = 0; 
        int i = 1;
        lps[0] = 0; 

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
