//You are given an array citations[], where each element citations[i] represents the number of citations received by the ith paper of a researcher. You have to calculate the researcher’s H-index.
class Solution {
    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1]; // counting array

        // Count how many papers have exactly i citations
        for (int c : citations) {
            if (c >= n) {
                count[n]++; // all citations >= n
            } else {
                count[c]++;
            }
        }

        int total = 0;
        // Traverse from high to low to find H-index
        for (int i = n; i >= 0; i--) {
            total += count[i];
            if (total >= i) {
                return i;
            }
        }

        return 0; // no valid H-index
    }
}
