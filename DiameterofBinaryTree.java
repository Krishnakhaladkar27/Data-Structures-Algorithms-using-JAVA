class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    // Diameter wrapper
    public int diameter(Node root) {
        int[] maxDiameter = new int[1]; // store max diameter
        height(root, maxDiameter);
        return maxDiameter[0];
    }

    // Helper function to compute height and update diameter
    private int height(Node node, int[] maxDiameter) {
        if (node == null) return -1; // height in edges

        int leftHeight = height(node.left, maxDiameter);
        int rightHeight = height(node.right, maxDiameter);

        // update diameter at this node
        int diameterAtNode = leftHeight + rightHeight + 2; // edges
        maxDiameter[0] = Math.max(maxDiameter[0], diameterAtNode);

        // return height of this node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
