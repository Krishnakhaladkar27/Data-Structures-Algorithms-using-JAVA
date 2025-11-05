import java.util.HashSet;

class Solution {
    // Method name as expected by GFG
    public boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }
}
