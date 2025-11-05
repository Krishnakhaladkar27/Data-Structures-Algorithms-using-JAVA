// Node class as defined by GFG
class Node {
    int data;
    Node left, right;
    
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {

    // Function to serialize a tree and return a list containing node data.
    public ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr == null) {
                list.add(-1);  // marker for null
                continue;
            }

            list.add(curr.data);
            q.offer(curr.left);
            q.offer(curr.right);
        }

        return list;
    }

    // Function to deserialize a list and reconstruct the binary tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        if (arr == null || arr.isEmpty()) return null;

        int i = 0;
        Node root = new Node(arr.get(i++));
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty() && i < arr.size()) {
            Node curr = q.poll();

            // Left child
            int leftVal = arr.get(i++);
            if (leftVal != -1) {
                curr.left = new Node(leftVal);
                q.offer(curr.left);
            }

            // Right child
            if (i < arr.size()) {
                int rightVal = arr.get(i++);
                if (rightVal != -1) {
                    curr.right = new Node(rightVal);
                    q.offer(curr.right);
                }
            }
        }

        return root;
    }
}
