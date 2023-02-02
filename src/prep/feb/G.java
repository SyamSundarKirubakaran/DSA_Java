package prep.feb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/top-k-frequent-words/

class G {
    private int k;
    private List<String> res;

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        this.k = k;
        res = new ArrayList<>();
        int n = words.length;
        TrieNode[] bucket = new TrieNode[n + 1];
        Map<String, Integer> cnt = new HashMap<>();

        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        for (var entry : cnt.entrySet()) {
            if (bucket[entry.getValue()] == null)
                bucket[entry.getValue()] = new TrieNode();
            addWord(bucket[entry.getValue()], entry.getKey());
        }

        for (int i = n; i > 0; i--) {
            if (bucket[i] != null) {
                getWords(bucket[i], "");
            }
            if (this.k == 0) {
                break;
            }
        }
        return res;

    }

    private void addWord(TrieNode root, String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    private void getWords(TrieNode root, String prefix) {
        if (k == 0)
            return;
        if (root.isWord) {
            k--;
            res.add(prefix);
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                getWords(root.children[i], prefix + (char) (i + 'a'));
            }
        }
    }
}
