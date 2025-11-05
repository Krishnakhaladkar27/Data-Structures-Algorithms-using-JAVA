class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    // Function to convert a binary tree to its mirror (in-place)
    public void mirror(Node root) {
        if (root == null) return;

        // Recursively mirror left and right subtrees
        mirror(root.left);
        mirror(root.right);

        // Swap left and right children
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
