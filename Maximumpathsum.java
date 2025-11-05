class Node {
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    // Variable to store the result (maximum path sum)
    int maxSum;
    
    // Function to find the maximum path sum in the binary tree
    int findMaxSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        maxPathSumUtil(root);
        return maxSum;
    }
    
    // Helper function that returns the maximum path sum for a subtree rooted at 'node'
    private int maxPathSumUtil(Node node) {
        if (node == null)
            return 0;
        
        // Compute the maximum path sum for left and right subtrees
        int left = Math.max(0, maxPathSumUtil(node.left));   // Ignore negative paths
        int right = Math.max(0, maxPathSumUtil(node.right));
        
        // Update the global maximum path sum if the current path is greater
        int currentPathSum = node.data + left + right;
        maxSum = Math.max(maxSum, currentPathSum);
        
        // Return the max path sum including this node and one of its subtrees
        return node.data + Math.max(left, right);
    }
}
