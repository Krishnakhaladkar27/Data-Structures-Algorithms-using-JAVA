import java.util.*;

public class DijkstraAlgorithm {

    public static int[] dijkstra(int V, int[][] edges, int src) {
        // Build adjacency matrix
        int[][] graph = new int[V][V];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u][v] = w;
            graph[v][u] = w; // undirected graph
        }

        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < V; i++) {
            int u = -1;
            int minDist = Integer.MAX_VALUE;

            // Pick the unvisited vertex with smallest distance
            for (int j = 0; j < V; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    u = j;
                }
            }

            if (u == -1) break; // All reachable vertices processed
            visited[u] = true;

            // Relax neighbors
            for (int v = 0; v < V; v++) {
                if (graph[u][v] > 0 && !visited[v]) {
                    if (dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] edges1 = { {0, 1, 1}, {1, 2, 3}, {0, 2, 6} };
        System.out.println(Arrays.toString(dijkstra(3, edges1, 2))); // Output: [4, 3, 0]

        int[][] edges2 = { {0, 1, 4}, {0, 2, 8}, {1, 4, 6}, {2, 3, 2}, {3, 4, 10} };
        System.out.println(Arrays.toString(dijkstra(5, edges2, 0))); // Output: [0, 4, 8, 10, 10]
    }
}
