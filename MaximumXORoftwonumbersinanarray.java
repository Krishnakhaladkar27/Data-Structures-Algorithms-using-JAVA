class TrieNode {
    TrieNode[] children = new TrieNode[2]; // 0 and 1
}

public class MaximumXOR {
    private TrieNode root;

    public MaximumXOR() {
        root = new TrieNode();
    }

    // Insert binary representation of number into Trie
    public void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    // Find maximum XOR of num with numbers already in Trie
    public int findMaxXOR(int num) {
        TrieNode node = root;
        int maxXOR = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int toggledBit = bit ^ 1; // try to pick opposite bit for max XOR
            if (node.children[toggledBit] != null) {
                maxXOR |= (1 << i);
                node = node.children[toggledBit];
            } else {
                node = node.children[bit];
            }
        }
        return maxXOR;
    }

    public int findMaximumXOR(int[] arr) {
        int maxXOR = 0;
        for (int num : arr) {
            insert(num); // insert num into Trie
        }
        for (int num : arr) {
            maxXOR = Math.max(maxXOR, findMaxXOR(num));
        }
        return maxXOR;
    }

    public static void main(String[] args) {
        MaximumXOR solver = new MaximumXOR();
        int[] arr1 = {25, 10, 2, 8, 5, 3};
        System.out.println(solver.findMaximumXOR(arr1)); // Output: 28

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(solver.findMaximumXOR(arr2)); // Output: 7
    }
}
