import java.util.*;

class Solution {
    static class Job {
        int deadline, profit;
        Job(int d, int p) {
            deadline = d;
            profit = p;
        }
    }

    public static int[] jobScheduling(int[] deadline, int[] profit) {
        int n = deadline.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
        }

        // Sort jobs by profit descending
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find maximum deadline to size the slots array
        int maxDeadline = 0;
        for (int d : deadline) maxDeadline = Math.max(maxDeadline, d);

        boolean[] slot = new boolean[maxDeadline + 1]; // slots[1..maxDeadline]
        int totalProfit = 0, countJobs = 0;

        for (Job job : jobs) {
            // Find a free slot for this job (latest possible)
            for (int j = job.deadline; j > 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    totalProfit += job.profit;
                    countJobs++;
                    break;
                }
            }
        }

        return new int[]{countJobs, totalProfit};
    }

    public static void main(String[] args) {
        int[] deadline1 = {4, 1, 1, 1};
        int[] profit1 = {20, 10, 40, 30};
        System.out.println(Arrays.toString(jobScheduling(deadline1, profit1))); // [2, 60]

        int[] deadline2 = {2, 1, 2, 1, 1};
        int[] profit2 = {100, 19, 27, 25, 15};
        System.out.println(Arrays.toString(jobScheduling(deadline2, profit2))); // [2, 127]

        int[] deadline3 = {3, 1, 2, 2};
        int[] profit3 = {50, 10, 20, 30};
        System.out.println(Arrays.toString(jobScheduling(deadline3, profit3))); // [3, 100]
    }
}
Job Sequencing Problem