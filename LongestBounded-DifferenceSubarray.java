import java.util.*;

class Solution {
    public static List<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length;
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int left = 0, bestStart = 0, bestLen = 0;

        for (int right = 0; right < n; right++) {
            // Maintain maxDeque (decreasing order)
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] < arr[right])
                maxDeque.pollLast();
            maxDeque.offerLast(right);

            // Maintain minDeque (increasing order)
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] > arr[right])
                minDeque.pollLast();
            minDeque.offerLast(right);

            // Shrink window if condition fails
            while (arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > x) {
                if (maxDeque.peekFirst() == left) maxDeque.pollFirst();
                if (minDeque.peekFirst() == left) minDeque.pollFirst();
                left++;
            }

            // Update best window
            if (right - left + 1 > bestLen) {
                bestLen = right - left + 1;
                bestStart = left;
            }
        }

        // Build result subarray
        List<Integer> result = new ArrayList<>();
        for (int i = bestStart; i < bestStart + bestLen; i++)
            result.add(arr[i]);

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {8, 4, 5, 6, 7};
        int x1 = 3;
        System.out.println(longestSubarray(arr1, x1)); // [4, 5, 6, 7]

        int[] arr2 = {1, 10, 12, 13, 14};
        int x2 = 2;
        System.out.println(longestSubarray(arr2, x2)); // [12, 13, 14]
    }
}
