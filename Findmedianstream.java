import java.util.*;

class Solution {
    public static ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> medians = new ArrayList<>();

        PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> upper = new PriorityQueue<>();

        for (int num : arr) {
            if (lower.isEmpty() || num <= lower.peek()) {
                lower.offer(num);
            } else {
                upper.offer(num);
            }
            if (lower.size() > upper.size() + 1) {
                upper.offer(lower.poll());
            } else if (upper.size() > lower.size()) {
                lower.offer(upper.poll());
            }
            double median;
            if (lower.size() == upper.size()) {
                median = (lower.peek() + upper.peek()) / 2.0;
            } else {
                median = lower.peek();
            }

            medians.add(median);
        }

        return medians;
    }
}
