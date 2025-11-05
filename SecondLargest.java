//Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.
class Solution {
   int getSecondLargest(int arr[]) {
        int n = arr.length;
        int largest = -1;
        int secondLargest = -1;
        
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            }else if (num < largest && num > secondLargest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }
}