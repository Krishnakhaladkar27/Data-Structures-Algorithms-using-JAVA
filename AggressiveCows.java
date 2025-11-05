import java.util.Arrays;

class Solution {

    // Helper: checks if we can place k cows with at least 'dist' distance apart
    private boolean canPlaceCows(int[] stalls, int k, int dist) {
        int count = 1;             // place first cow
        int lastPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= dist) {
                count++;
                lastPos = stalls[i];
                if (count == k) return true;  // all cows placed
            }
        }
        return false;
    }

    // Main GFG function
    public int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // ✅ Call matches helper's signature
            if (canPlaceCows(stalls, k, mid)) {
                ans = mid;        // possible → try for a bigger minimum distance
                low = mid + 1;
            } else {
                high = mid - 1;   // not possible → reduce distance
            }
        }
        return ans;
    }
}
