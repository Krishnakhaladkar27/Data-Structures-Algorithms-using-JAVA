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
    private int count = 0;
    private int result = -1;

   
    public int KthSmallestElement(Node root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(Node node, int k) {
        if (node == null || result != -1) return;

    
        inorder(node.left, k);

       
        count++;
        if (count == k) {
            result = node.data;
            return;
        }

        // Traverse right subtree
        inorder(node.right, k);
    }
}

