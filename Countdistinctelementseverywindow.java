import java.util.*;

class Solution {
    public ArrayList<Integer> countDistinct(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || k == 0) return result;

        Map<Integer, Integer> freqMap = new HashMap<>();
        int n = arr.length;

        // Process first window
        for (int i = 0; i < k; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        result.add(freqMap.size());

        // Slide the window
        for (int i = k; i < n; i++) {
            // Remove the first element of previous window
            int outElem = arr[i - k];
            freqMap.put(outElem, freqMap.get(outElem) - 1);
            if (freqMap.get(outElem) == 0) {
                freqMap.remove(outElem);
            }

            // Add the new element
            int inElem = arr[i];
            freqMap.put(inElem, freqMap.getOrDefault(inElem, 0) + 1);

            result.add(freqMap.size());
        }

        return result;
    }
}
