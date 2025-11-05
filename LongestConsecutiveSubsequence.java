import java.util.*;

class Solution {
    public int findLongestConseqSubseq(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;
        for (int num : arr) {
            set.add(num);
        }
        for (int num : arr) {
            
            if (!set.contains(num - 1)) {
                int curr = num;
                int length = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    length++;
                }

                maxLen = Math.max(maxLen, length);
            }
        }

        return maxLen;
    }
}
