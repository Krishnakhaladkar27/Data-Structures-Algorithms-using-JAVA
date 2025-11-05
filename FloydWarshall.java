import java.util.Arrays;

public class FloydWarshall {

    public void floydWarshall(int[][] dist) {
        int V = dist.length;

        // Iterate over all intermediate nodes
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != 100000000 && dist[k][j] != 100000000) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();

        int INF = 100000000;

        int[][] dist1 = {
            {0, 4, INF, 5, INF},
            {INF, 0, 1, INF, 6},
            {2, INF, 0, 3, INF},
            {INF, INF, 1, 0, 2},
            {1, INF, INF, 4, 0}
        };

        fw.floydWarshall(dist1);
        for (int[] row : dist1) {
            System.out.println(Arrays.toString(row));
        }
        // Output: [[0, 4, 5, 5, 7], [3, 0, 1, 4, 6], [2, 6, 0, 3, 5], [3, 7, 1, 0, 2], [1, 5, 5, 4, 0]]

        int[][] dist2 = {
            {0, -1, 2},
            {1, 0, INF},
            {3, 1, 0}
        };

        fw.floydWarshall(dist2);
        for (int[] row : dist2) {
            System.out.println(Arrays.toString(row));
        }
        // Output: [[0, -1, 2], [1, 0, 3], [2, 1, 0]]
    }
}
