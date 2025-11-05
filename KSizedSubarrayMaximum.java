import java.util.*;

class Solution {
    public static List<Integer> maxOfSubarrays(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < arr.length; i++) {
            // Remove elements out of this window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            // Remove all smaller elements (they are useless)
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i])
                dq.pollLast();

            // Add current element's index
            dq.offerLast(i);

            // The front of deque is the max of current window
            if (i >= k - 1)
                result.add(arr[dq.peekFirst()]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k1 = 3;
        System.out.println(maxOfSubarrays(arr1, k1)); // [3, 3, 4, 5, 5, 5, 6]

        int[] arr2 = {5, 1, 3, 4, 2};
        int k2 = 1;
        System.out.println(maxOfSubarrays(arr2, k2)); // [5, 1, 3, 4, 2]
    }
}
