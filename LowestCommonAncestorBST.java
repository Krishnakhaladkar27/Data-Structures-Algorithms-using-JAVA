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

    // Function to find the Lowest Common Ancestor (LCA) in a BST.
    Node LCA(Node root, Node n1, Node n2) {
        if (root == null) return null;

        // Extract the data values for clarity
        int val1 = n1.data;
        int val2 = n2.data;

        // If both values are smaller than root, LCA lies in left subtree
        if (val1 < root.data && val2 < root.data)
            return LCA(root.left, n1, n2);

        // If both values are greater than root, LCA lies in right subtree
        if (val1 > root.data && val2 > root.data)
            return LCA(root.right, n1, n2);

        // Otherwise, root is the LCA
        return root;
    }

}
