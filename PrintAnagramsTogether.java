import java.util.*;

class Solution {
    public ArrayList<ArrayList<String>> printAnagramsTogether(String[] arr) {
        // Use LinkedHashMap to preserve input order
        Map<String, ArrayList<String>> map = new LinkedHashMap<>();

        for (String str : arr) {
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            String key = new String(chArr);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        // Convert Collection<ArrayList<String>> to ArrayList<ArrayList<String>>
        return new ArrayList<>(map.values());
    }
}

class Main {
    public static void main(String[] args) {
        String[] arr = {"act", "god", "cat", "dog", "tac"};
        Solution ob = new Solution();

        ArrayList<ArrayList<String>> result = ob.printAnagramsTogether(arr);

        for (ArrayList<String> group : result) {
            System.out.println(group);
        }
    }
}
