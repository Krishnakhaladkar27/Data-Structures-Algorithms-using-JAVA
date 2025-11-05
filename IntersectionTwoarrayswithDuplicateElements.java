import java.util.*;

class Solution {
    public ArrayList<Integer> intersection(int[] a, int[] b) {
        // Use HashSet to store unique elements from the first array
        Set<Integer> setA = new HashSet<>();
        for (int num : a) {
            setA.add(num);
        }

        // Use another HashSet to store the intersection (unique)
        Set<Integer> intersectionSet = new HashSet<>();
        for (int num : b) {
            if (setA.contains(num)) {
                intersectionSet.add(num);
            }
        }

        // Convert the set to ArrayList
        return new ArrayList<>(intersectionSet);
    }
}
