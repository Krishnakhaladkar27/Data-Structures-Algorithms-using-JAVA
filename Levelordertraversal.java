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
    // Function to return the level order traversal of a binary tree.
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                level.add(current.data);

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

               result.add(new ArrayList<>(level));
        }

        return result;
    }
}
