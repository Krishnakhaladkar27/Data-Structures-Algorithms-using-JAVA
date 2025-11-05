class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    // Function to find height of binary tree (number of edges)
    public int height(Node root) {
        if (root == null) return -1; // height in edges, so empty tree is -1

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
