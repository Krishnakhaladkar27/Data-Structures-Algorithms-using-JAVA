class Solution {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) {
                    // Case 1: arr[left] == arr[right]
                    if (arr[left] == arr[right]) {
                        int m = right - left + 1;
                        count += (m * (m - 1)) / 2;
                        break;
                    }

                    // Case 2: arr[left] != arr[right]
                    int leftVal = arr[left];
                    int rightVal = arr[right];
                    int cntLeft = 0, cntRight = 0;

                    // Count duplicates on left side
                    while (left < right && arr[left] == leftVal) {
                        cntLeft++;
                        left++;
                    }

                    // Count duplicates on right side
                    while (right >= left && arr[right] == rightVal) {
                        cntRight++;
                        right--;
                    }

                    // Add all combinations
                    count += cntLeft * cntRight;

                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}
