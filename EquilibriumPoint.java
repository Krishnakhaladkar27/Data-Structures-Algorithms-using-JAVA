class Solution {
    public int equilibriumPoint(int[] arr) {
        int n = arr.length;
        if (n == 0) return -1;

        // compute total sum first (use long to avoid overflow)
        long totalSum = 0L;
        for (int v : arr) totalSum += v;

        long leftSum = 0L;

        for (int i = 0; i < n; i++) {
            long rightSum = totalSum - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i; // 0-based index as requested
            }
            leftSum += arr[i];
        }

        return -1;
    }
}
