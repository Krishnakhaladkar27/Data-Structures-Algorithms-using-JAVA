import java.util.*;

class Solution {
    public int countPairs(int[] arr, int target) {
        Arrays.sort(arr); // sort array first
        int n = arr.length;
        int left = 0, right = n - 1;
        int count = 0;

        while (left < right) {
            if (arr[left] + arr[right] < target) {
                // all elements from left+1 to right form valid pairs with arr[left]
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
