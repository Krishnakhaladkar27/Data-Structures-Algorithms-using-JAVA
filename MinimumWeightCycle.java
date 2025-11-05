import java.util.Arrays;

public class MinimumWeightCycle {

    public int findMinCycle(int V, int[][] edges) {
        int INF = 100000000;
        int[][] dist = new int[V][V];
        int[][] adj = new int[V][V];

        // Initialize distances and adjacency matrix
        for (int i = 0; i < V; i++) {
            Arrays.fill(dist[i], INF);
            Arrays.fill(adj[i], INF);
            dist[i][i] = 0;
            adj[i][i] = 0;
        }

        // Fill adjacency matrix with edge weights
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            // For undirected graph
            dist[u][v] = w;
            dist[v][u] = w;
            adj[u][v] = w;
            adj[v][u] = w;
        }

        int minCycle = INF;

        // Modified Floyd-Warshall
        for (int k = 0; k < V; k++) {
            // Check for cycles including vertex k
            for (int i = 0; i < k; i++) {
                for (int j = i + 1; j < k; j++) {
                    if (dist[i][j] != INF && adj[i][k] != INF && adj[k][j] != INF) {
                        minCycle = Math.min(minCycle, dist[i][j] + adj[i][k] + adj[k][j]);
                    }
                }
            }

            // Standard Floyd-Warshall update
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        return minCycle == INF ? -1 : minCycle;
    }

    public static void main(String[] args) {
        MinimumWeightCycle mwc = new MinimumWeightCycle();

        int[][] edges1 = {
            {0, 1, 2}, {1, 2, 2}, {1, 3, 1}, {1, 4, 1}, {0, 4, 3}, {2, 3, 4}
        };
        System.out.println(mwc.findMinCycle(5, edges1)); // Output: 6

        int[][] edges2 = {
            {0, 1, 3}, {1, 2, 2}, {0, 4, 1}, {1, 4, 2}, {1, 3, 1}, {3, 4, 2}, {2, 3, 3}
        };
        System.out.println(mwc.findMinCycle(5, edges2)); // Output: 5
    }
}
