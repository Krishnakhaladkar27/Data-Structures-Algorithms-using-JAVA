import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

public class CloneGraph {

    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // If this node was already cloned, return the clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone for the given node
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        // Iterate through neighbors and clone them recursively
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }

    public static void main(String[] args) {
        // Example: graph with 4 nodes
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node0.neighbors.addAll(Arrays.asList(node1, node2));
        node1.neighbors.addAll(Arrays.asList(node0, node2));
        node2.neighbors.addAll(Arrays.asList(node0, node1, node3));
        node3.neighbors.add(node2);

        CloneGraph solution = new CloneGraph();
        Node clonedGraph = solution.cloneGraph(node0);

        System.out.println(clonedGraph != null && clonedGraph != node0); // true
    }
}
