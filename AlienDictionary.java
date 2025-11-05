import java.util.*;

public class AlienDictionary {

    public String alienOrder(String[] words) {
        // Step 1: Build the graph and compute in-degrees
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // Initialize the graph nodes
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // Build edges based on adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            boolean foundDiff = false;

            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    foundDiff = true;
                    break;
                }
            }
            // Check invalid case: prefix issue
            if (!foundDiff && w1.length() > w2.length()) {
                return ""; // Invalid ordering
            }
        }

        // Step 2: Topological Sort (Kahn's algorithm)
        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) queue.add(c);
        }

        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            order.append(curr);

            for (char neighbor : graph.get(curr)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If all characters are included in the order, return it
        if (order.length() != inDegree.size()) return ""; // Cycle detected
        return order.toString();
    }

    public static void main(String[] args) {
        AlienDictionary solution = new AlienDictionary();

        String[] words1 = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(solution.alienOrder(words1)); // Possible output: bdac

        String[] words2 = {"caa", "aaa", "aab"};
        System.out.println(solution.alienOrder(words2)); // Possible output: cab

        String[] words
