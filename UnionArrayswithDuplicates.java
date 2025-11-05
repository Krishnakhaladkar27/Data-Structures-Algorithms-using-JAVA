import java.util.*;

class Solution {
    public ArrayList<Integer> union(int[] a, int[] b) {
        // Use a HashSet to store all distinct elements
        Set<Integer> set = new HashSet<>();
        
        for (int num : a) {
            set.add(num);
        }
        for (int num : b) {
            set.add(num);
        }

        // Convert the set to an ArrayList and return
        return new ArrayList<>(set);
    }
}
