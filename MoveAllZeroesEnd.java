//You are given an array arr[] of non-negative integers. You have to move all the zeros in the array to the right end while maintaining the relative order of the non-zero elements. The operation must be performed in place, meaning you should not use extra space for another array.
class Solution {
    
    void pushZeroToEnd(int[] arr) {
        int n = arr.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                if (i != count){
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
            }
            count++;
        }
    }
}
}