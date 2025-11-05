import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    private static int preIndex; // current index in preorder array

    public static Node buildTree(int[] inorder, int[] preorder) {
        preIndex = 0; // reset for each test case
        int n = inorder.length;

        // Map value to index in inorder for O(1) lookups
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, n - 1, inMap);
    }

    private static Node buildTreeHelper(int[] preorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (inStart > inEnd) return null;

        // Pick current node from preorder and increment preIndex
        int rootVal = preorder[preIndex++];
        Node root = new Node(rootVal);

        // If this node has no children
        if (inStart == inEnd) return root;

        // Find index of root in inorder array
        int inIndex = inMap.get(rootVal);

        // Recursively build left and right subtrees
        root.left = buildTreeHelper(preorder, inStart, inIndex - 1, inMap);
        root.right = buildTreeHelper(preorder, inIndex + 1, inEnd, inMap);

        return root;
    }
}
