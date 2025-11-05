import java.util.Arrays;

public class BellmanFord {

    public int[] bellmanFord(int V, int[][] edges, int src) {
        // Initialize distances array with "infinity" (here 10^8)
        int[] dist = new int[V];
        Arrays.fill(dist, 100000000);
        dist[src] = 0;

        // Step 1: Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist[u] != 100000000 && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Step 2: Check for negative weight cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (dist[u] != 100000000 && dist[u] + w < dist[v]) {
                // Negative cycle detected
                return new int[]{-1};
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        BellmanFord bf = new BellmanFord();

        int V1 = 5;
        int[][] edges1 = {
            {1, 3, 2},
            {4, 3, -1},
            {2, 4, 1},
            {1, 2, 1},
            {0, 1, 5}
        };
        int src1 = 0;
        System.out.println(Arrays.toString(bf.bellmanFord(V1, edges1, src1))); 
        // Output: [0, 5, 6, 6, 7]

        int V2 = 4;
        int[][] edges2 = {
            {0, 1, 4},
            {1, 2, -6},
            {2, 3, 5},
            {3, 1, -2}
        };
        int src2 = 0;
        System.out.println(Arrays.toString(bf.bellmanFord(V2, edges2, src2))); 
        // Output: [-1] (negative cycle)
    }
}
