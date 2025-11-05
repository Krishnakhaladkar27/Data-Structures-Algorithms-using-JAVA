import java.util.*;

class Solution {
    static class Activity {
        int start, finish;
        Activity(int s, int f) {
            start = s;
            finish = f;
        }
    }

    public static int maxActivities(int[] start, int[] finish) {
        int n = start.length;

        // Create an array of activities
        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(start[i], finish[i]);
        }

        // Sort activities based on finish time
        Arrays.sort(activities, (a, b) -> a.finish - b.finish);

        int count = 1; // Always select the first activity
        int lastFinish = activities[0].finish;

        for (int i = 1; i < n; i++) {
            if (activities[i].start >= lastFinish) {
                count++;
                lastFinish = activities[i].finish;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] start1 = {1, 3, 0, 5, 8, 5};
        int[] finish1 = {2, 4, 6, 7, 9, 9};
        System.out.println(maxActivities(start1, finish1)); // 4

        int[] start2 = {10, 12, 20};
        int[] finish2 = {20, 25, 30};
        System.out.println(maxActivities(start2, finish2)); // 1

        int[] start3 = {1, 3, 2, 5};
        int[] finish3 = {2, 4, 3, 6};
        System.out.println(maxActivities(start3, finish3)); // 3
    }
}
