import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();

        // Iterate over all pairs (i, j) and look for complement
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int complement = - (arr[i] + arr[j]);
                for (int k = j + 1; k < n; k++) {
                    if (arr[k] == complement) {
                        result.add(Arrays.asList(i, j, k));
                    }
                }
            }
        }

        return result;
    }
}
