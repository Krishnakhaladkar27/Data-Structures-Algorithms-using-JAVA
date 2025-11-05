class Solution {
    public int countPairs(int[] arr, int target) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                // Case 1: same value on both sides
                if (arr[left] == arr[right]) {
                    int m = right - left + 1;
                    count += (m * (m - 1)) / 2; // nC2 pairs
                    break; // all pairs counted
                }

                // Case 2: different values
                int leftVal = arr[left], rightVal = arr[right];
                int cntLeft = 0, cntRight = 0;

                while (left < right && arr[left] == leftVal) {
                    cntLeft++;
                    left++;
                }
                while (right >= left && arr[right] == rightVal) {
                    cntRight++;
                    right--;
                }

                count += cntLeft * cntRight;
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }

        return count;
    }
}
