
class Solution {
    private Node first = null, middle = null, last = null, prev = null;

    public void correctBST(Node root) {
        // Step 1: Perform in-order traversal to find the two nodes
        inorder(root);

        // Step 2: Swap the data of the two nodes
        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && middle != null) {
            // adjacent swapped nodes
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    private void inorder(Node root) {
        if (root == null) return;

        // Traverse left subtree
        inorder(root.left);

        // Process current node
        if (prev != null && root.data < prev.data) {
            // If this is first violation, mark first and middle
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                // If this is second violation, mark last
                last = root;
            }
        }
        prev = root;

        // Traverse right subtree
        inorder(root.right);
    }
}
