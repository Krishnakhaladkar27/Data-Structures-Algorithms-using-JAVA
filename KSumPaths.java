import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    long count; // to store the number of valid paths

    public int sumK(Node root, int k) {
        count = 0;
        Map<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, 1); // base case (empty path)
        dfs(root, 0L, k, prefixSum);
        return (int) count;
    }

    private void dfs(Node node, long currSum, int k, Map<Long, Integer> prefixSum) {
        if (node == null) return;

        // Update the current path sum
        currSum += node.data;

        // Check if there exists a prefix sum that gives sum = k
        if (prefixSum.containsKey(currSum - k)) {
            count += prefixSum.get(currSum - k);
        }

        // Add current sum to prefixSum map
        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);

        // Recurse for left and right subtrees
        dfs(node.left, currSum, k, prefixSum);
        dfs(node.right, currSum, k, prefixSum);

        // Remove the current sum when backtracking
        prefixSum.put(currSum, prefixSum.get(currSum) - 1);
    }
}
