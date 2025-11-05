import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        // Max-heap: store [distance², x, y]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0]) // largest distance first
        );

        for (int[] p : points) {
            int distSq = p[0] * p[0] + p[1] * p[1];
            pq.offer(new int[]{distSq, p[0], p[1]});

            // Maintain heap size at most k
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Convert to ArrayList<ArrayList<Integer>>
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            ArrayList<Integer> point = new ArrayList<>();
            point.add(curr[1]); // x-coordinate
            point.add(curr[2]); // y-coordinate
            result.add(point);
        }

        return result;
    }
}
