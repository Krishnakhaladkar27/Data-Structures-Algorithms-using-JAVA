import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}

class Solution {
    // Function to return the inorder traversal of a Binary Tree using O(1) space
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Node current = root;

        while (current != null) {
            if (current.left == null) {
                result.add(current.data);
                current = current.right;
            } else {
                Node pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = current; // Make temporary link
                    current = current.left;
                } else {
                    pre.right = null; // Remove temporary link
                    result.add(current.data);
                    current = current.right;
                }
            }
        }
        return result;
    }
}
