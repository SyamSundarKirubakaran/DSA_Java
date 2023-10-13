package problems.company.tesla.set1;

import java.util.*;

// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/editorial/

class A {
    public int maxLength(List<String> arr) {
        // Initialize results with an empty string
        // from which to build all future results
        List<String> results = new ArrayList<>();
        results.add("");
        int best = 0;
        for (String word : arr) {
            // We only want to iterate through results
            // that existed prior to this loop
            int resultsLen = results.size();
            for (int i = 0; i < resultsLen; i++) {
                // Form a new result combination and
                // use a set to check for duplicate characters
                String newRes = results.get(i) + word;
                Set<Character> newResSet = new HashSet<>();
                for (char c : newRes.toCharArray())
                    newResSet.add(c);
                if (newRes.length() != newResSet.size())
                    continue;

                // Add valid options to results and
                // keep track of the longest so far
                results.add(newRes);
                best = Math.max(best, newRes.length());
            }
        }
        return best;
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");

        System.out.println(new A().maxLength(arr));
    }
}

class BackTracking {
    public int maxLength(List<String> arr) {
        // Use depth first search recursion through arr
        // with backracking and a map for results
        return backtracking(arr, 0, new HashMap<Character, Integer>());
    }

    private int backtracking(List<String> arr, int pos, Map<Character, Integer> resMap) {
        // Check for duplicate characters
        for (Integer val : resMap.values())
            if (val > 1)
                return 0;

        // Recurse through each possible next option
        // and find the best answer
        int best = resMap.size();
        for (int i = pos; i < arr.size(); i++) {
            // Add the current word to the result map
            // and recurse to the next position
            char[] wordArr = arr.get(i).toCharArray();
            for (char c : wordArr)
                resMap.put(c, resMap.getOrDefault(c, 0) + 1);
            best = Math.max(best, backtracking(arr, i + 1, resMap));

            // Backtrack the result map before continuing
            for (char c : wordArr) {
                if (resMap.get(c) == 1) {
                    resMap.remove(c);
                } else {
                    resMap.put(c, resMap.get(c) - 1);
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");

        System.out.println(new A().maxLength(arr));
    }
}

class Recursion {
    public int maxLength(List<String> arr) {
        // Use depth first search recursion through arr
        // building from an initial empty string
        return dfs(arr, 0, "");
    }

    private int dfs(List<String> arr, int pos, String res) {
        // Use a set to check res for duplicate characters
        Set<Character> resSet = new HashSet<>();
        for (char c : res.toCharArray())
            resSet.add(c);
        if (res.length() != resSet.size())
            return 0;

        // Recurse through each possible next option
        // and find the best answer
        int best = res.length();
        for (int i = pos; i < arr.size(); i++)
            best = Math.max(best, dfs(arr, i + 1, res + arr.get(i)));
        return best;
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");

        System.out.println(new A().maxLength(arr));
    }
}
