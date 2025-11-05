import java.util.HashMap;

class Solution {
    // Method name as expected by GFG
    public int getPairsCount(int[] arr, int target) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int complement = target - num;
            if (freq.containsKey(complement)) {
                count += freq.get(complement);
            }
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}
