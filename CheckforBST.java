// Definition for a binary tree node.
class Node {
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Solution {
    // Function to check whether a Binary Tree is a BST or not.
    boolean isBST(Node root) {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBSTUtil(Node node, long min, long max) {
        // Base case: empty tree is a BST
        if (node == null) return true;

        // Check current node value against range
        if (node.data <= min || node.data >= max) return false;

        // Recursively check left and right subtrees
        return isBSTUtil(node.left, min, node.data) &&
               isBSTUtil(node.right, node.data, max);
    }

    // Optional: Driver code for quick testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: [2, 1, 3, N, N, N, 5]
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(3);
        root1.right.right = new Node(5);
        System.out.println(sol.isBST(root1)); // true

        // Example 2: [2, N, 7, N, 6, N, 9]
        Node root2 = new Node(2);
        root2.right = new Node(7);
        root2.right.left = new Node(6);
        root2.right.right = new Node(9);
        System.out.println(sol.isBST(root2)); // false

        // Example 3: [10, 5, 20, N, N, 9, 25]
        Node root3 = new Node(10);
        root3.left = new Node(5);
        root3.right = new Node(20);
        root3.right.left = new Node(9);
        root3.right.right = new Node(25);
        System.out.println(sol.isBST(root3)); // false
    }
}
