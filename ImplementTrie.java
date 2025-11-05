import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // 26 lowercase English letters
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }

    // Search for a word in the trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return node.isEndOfWord;
    }

    // Check if a word is a prefix of any word in the trie
    public boolean isPrefix(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return true;
    }
}

public class TrieDemo {
    public static List<Boolean> processQueries(int[][] query, String[] words) {
        Trie trie = new Trie();
        List<Boolean> results = new ArrayList<>();

        for (int i = 0; i < query.length; i++) {
            int type = query[i][0];
            String word = words[i];

            if (type == 1) {
                trie.insert(word);
            } else if (type == 2) {
                results.add(trie.search(word));
            } else if (type == 3) {
                results.add(trie.isPrefix(word));
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[][] query1 = {{1}, {1}, {1}, {2}, {3}, {2}};
        String[] words1 = {"abcd", "abc", "bcd", "bc", "bc", "abc"};

        System.out.println(processQueries(query1, words1)); // Output: [false, true, true]

        int[][] query2 = {{1}, {1}, {3}, {3}, {2}};
        String[] words2 = {"gfg", "geeks", "fg", "geek", "for"};

        System.out.println(processQueries(query2, words2)); // Output: [false, true, false]
    }
}
