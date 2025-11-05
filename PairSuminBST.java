// Definition for a binary tree node.
class Node {
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left = right = null;
    }
}

import java.util.*;

public class Solution {
    public boolean findPair(Node root, int target) {
        List<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);

        int i = 0, j = inorderList.size() - 1;
        while (i < j) {
            int sum = inorderList.get(i) + inorderList.get(j);
            if (sum == target) return true;
            else if (sum < target) i++;
            else j--;
        }

        return false;
    }

    private void inorderTraversal(Node node, List<Integer> list) {
        if (node == null) return;
        inorderTraversal(node.left, list);
        list.add(node.data);
        inorderTraversal(node.right, list);
    }
}
