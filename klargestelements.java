import java.util.*;

class Solution {
    public static ArrayList<Integer> kLargest(int[] arr, int k) {
        // Min-heap to store the k largest elements
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        for (int num : arr) {
            // Add the current element
            pq.offer(num);
            
            // Keep only k largest elements in the heap
            if (pq.size() > k) {
                pq.poll(); // remove the smallest
            }
        }

        // Extract elements from heap (smallest to largest)
        ArrayList<Integer> result = new ArrayList<>(pq);
        
        // Sort in decreasing order as required
        result.sort(Collections.reverseOrder());
        
        return result;
    }
}
