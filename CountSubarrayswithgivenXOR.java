import java.util.*;

class Solution {
    public int countSubarraysXOR(int[] arr, int k) {
        Map<Integer, Integer> prefixXORCount = new HashMap<>();
        int xor = 0;
        int count = 0;

        for (int num : arr) {
            xor ^= num; // current prefix XOR

            // if prefix XOR itself is equal to k
            if (xor == k) {
                count++;
            }

            // if there exists a prefix XOR which when XORed with current gives k
            int requiredXOR = xor ^ k;
            count += prefixXORCount.getOrDefault(requiredXOR, 0);

            // update prefix XOR count
            prefixXORCount.put(xor, prefixXORCount.getOrDefault(xor, 0) + 1);
        }

        return count;
    }
}
