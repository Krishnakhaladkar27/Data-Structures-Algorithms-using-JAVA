class Solution {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0, tank = 0, start = 0;

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }

        return total >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas1 = {4, 5, 7, 4};
        int[] cost1 = {6, 6, 3, 5};
        System.out.println(canCompleteCircuit(gas1, cost1)); // Output: 2

        int[] gas2 = {3, 9};
        int[] cost2 = {7, 6};
        System.out.println(canCompleteCircuit(gas2, cost2)); // Output: -1
    }
}
