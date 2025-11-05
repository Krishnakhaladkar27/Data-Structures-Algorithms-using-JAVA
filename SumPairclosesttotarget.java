import java.util.*;

class Solution {
    public ArrayList<Integer> sumClosest(int[] arr, int target) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        // If no pair possible
        if (n < 2) return result;

        Arrays.sort(arr);

        int left = 0, right = n - 1;
        int closestDiff = Integer.MAX_VALUE;
        int maxAbsDiff = -1;
        int a = -1, b = -1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int diff = Math.abs(sum - target);

            if (diff < closestDiff ||
               (diff == closestDiff && (arr[right] - arr[left]) > maxAbsDiff)) {
                closestDiff = diff;
                maxAbsDiff = arr[right] - arr[left];
                a = arr[left];
                b = arr[right];
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        // If no valid pair found
        if (a == -1 && b == -1) return result;

        result.add(a);
        result.add(b);
        return result;
    }
}
