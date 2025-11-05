class Solution {
    public int maxArea(int[] arr) {
        int left = 0, right = arr.length - 1;
        int maxWater = 0;

        while (left < right) {
            // Calculate area between two lines
            int height = Math.min(arr[left], arr[right]);
            int width = right - left;
            int area = height * width;
            maxWater = Math.max(maxWater, area);

            // Move the smaller line inward to find a potentially larger area
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
