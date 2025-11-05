
class Solution {
    ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if (!isLeaf(root))
            res.add(root.data);

        addLeftBoundary(root.left, res);
        addLeaves(root, res);
        addRightBoundary(root.right, res);
        
        return res;
    }
    private boolean isLeaf(Node node) {
        return (node != null && node.left == null && node.right == null);
    }
    private void addLeftBoundary(Node node, ArrayList<Integer> res) {
        Node curr = node;
        while (curr != null) {
            if (!isLeaf(curr))
                res.add(curr.data);
            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }
    private void addLeaves(Node node, ArrayList<Integer> res) {
        if (node == null) return;
        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }
        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }
    private void addRightBoundary(Node node, ArrayList<Integer> res) {
        ArrayList<Integer> tmp = new ArrayList<>();
        Node curr = node;
        while (curr != null) {
            if (!isLeaf(curr))
                tmp.add(curr.data);
            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        for (int i = tmp.size() - 1; i >= 0; i--)
            res.add(tmp.get(i));
    }
}
