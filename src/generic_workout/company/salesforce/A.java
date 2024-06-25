package generic_workout.company.salesforce;

import javafx.util.Pair;

import java.util.*;

class A {

    // https://leetcode.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/solutions/1032052/count-map-o-n-with-explanation-from-a-to-y-change-a-and-b/
    class MinCharChange {
        public int minCharacters(String a, String b) {
            int[] aCount = new int[26];
            int aMax = 0;
            for (int i = 0; i < a.length(); i++) {
                aCount[a.charAt(i) - 'a']++;
                aMax = Math.max(aMax, aCount[a.charAt(i) - 'a']);
            }

            int[] bCount = new int[26];
            int bMax = 0;
            for (int i = 0; i < b.length(); i++) {
                bCount[b.charAt(i) - 'a']++;
                bMax = Math.max(bMax, bCount[b.charAt(i) - 'a']);
            }
            int condition3 = a.length() - aMax + b.length() - bMax;

            int globalMin = condition3;

            int aTillCurrent = 0;
            int bTillCurrent = 0;
            for (int i = 0; i < 25; i++) {
                aTillCurrent += aCount[i];
                bTillCurrent += bCount[i];
                globalMin = Math.min(globalMin, bTillCurrent + a.length() - aTillCurrent);
                globalMin = Math.min(globalMin, aTillCurrent + b.length() - bTillCurrent);
            }

            return globalMin;
        }
    }

    // https://leetcode.com/problems/lru-cache/editorial/

    class LRU {

        /**
         * Your LRUCache object will be instantiated and called as such:
         * LRUCache obj = new LRUCache(capacity);
         * int param_1 = obj.get(key);
         * obj.put(key,value);
         */
        class ListNode {
            int key;
            int val;
            ListNode next;
            ListNode prev;

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        class LRUCache {
            int capacity;
            Map<Integer, ListNode> dic;
            ListNode head;
            ListNode tail;

            public LRUCache(int capacity) {
                this.capacity = capacity;
                dic = new HashMap<>();
                head = new ListNode(-1, -1);
                tail = new ListNode(-1, -1);
                head.next = tail;
                tail.prev = head;
            }

            public int get(int key) {
                if (!dic.containsKey(key)) {
                    return -1;
                }

                ListNode node = dic.get(key);
                remove(node);
                add(node);
                return node.val;
            }

            public void put(int key, int value) {
                if (dic.containsKey(key)) {
                    ListNode oldNode = dic.get(key);
                    remove(oldNode);
                }

                ListNode node = new ListNode(key, value);
                dic.put(key, node);
                add(node);

                if (dic.size() > capacity) {
                    ListNode nodeToDelete = head.next;
                    remove(nodeToDelete);
                    dic.remove(nodeToDelete.key);
                }
            }

            public void add(ListNode node) {
                ListNode previousEnd = tail.prev;
                previousEnd.next = node;
                node.prev = previousEnd;
                node.next = tail;
                tail.prev = node;
            }

            public void remove(ListNode node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }

        class LRUCacheInbuilt {
            int capacity;
            LinkedHashMap<Integer, Integer> dic;

            public LRUCacheInbuilt(int capacity) {
                this.capacity = capacity;
                dic = new LinkedHashMap<Integer, Integer>(5, 0.75f, true) {
                    @Override
                    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                        return size() > capacity;
                    }
                };
            }

            public int get(int key) {
                return dic.getOrDefault(key, -1);
            }

            public void put(int key, int value) {
                dic.put(key, value);
            }

        }

        /**
         * Your LRUCache object will be instantiated and called as such:
         * LRUCache obj = new LRUCache(capacity);
         * int param_1 = obj.get(key);
         * obj.put(key,value);
         */
    }

    // https://leetcode.com/problems/merge-intervals/
    class MergeInter {
        class MergeIntervals {
            private Map<int[], List<int[]>> graph;
            private Map<Integer, List<int[]>> nodesInComp;
            private Set<int[]> visited;

            // return whether two intervals overlap (inclusive)
            private boolean overlap(int[] a, int[] b) {
                return a[0] <= b[1] && b[0] <= a[1];
            }

            // build a graph where an undirected edge between intervals u and v exists
            // iff u and v overlap.
            private void buildGraph(int[][] intervals) {
                graph = new HashMap<>();
                for (int[] interval : intervals) {
                    graph.put(interval, new LinkedList<>());
                }

                for (int[] interval1 : intervals) {
                    for (int[] interval2 : intervals) {
                        if (overlap(interval1, interval2)) {
                            graph.get(interval1).add(interval2);
                            graph.get(interval2).add(interval1);
                        }
                    }
                }
            }

            // merges all of the nodes in this connected component into one interval.
            private int[] mergeNodes(List<int[]> nodes) {
                int minStart = nodes.get(0)[0];
                for (int[] node : nodes) {
                    minStart = Math.min(minStart, node[0]);
                }

                int maxEnd = nodes.get(0)[1];
                for (int[] node : nodes) {
                    maxEnd = Math.max(maxEnd, node[1]);
                }

                return new int[]{minStart, maxEnd};
            }

            // use depth-first search to mark all nodes in the same connected component
            // with the same integer.
            private void markComponentDFS(int[] start, int compNumber) {
                Stack<int[]> stack = new Stack<>();
                stack.add(start);

                while (!stack.isEmpty()) {
                    int[] node = stack.pop();
                    if (!visited.contains(node)) {
                        visited.add(node);

                        if (nodesInComp.get(compNumber) == null) {
                            nodesInComp.put(compNumber, new LinkedList<>());
                        }
                        nodesInComp.get(compNumber).add(node);

                        for (int[] child : graph.get(node)) {
                            stack.add(child);
                        }
                    }
                }
            }

            // gets the connected components of the interval overlap graph.
            private void buildComponents(int[][] intervals) {
                nodesInComp = new HashMap<>();
                visited = new HashSet<>();
                int compNumber = 0;

                for (int[] interval : intervals) {
                    if (!visited.contains(interval)) {
                        markComponentDFS(interval, compNumber);
                        compNumber++;
                    }
                }
            }

            public int[][] merge(int[][] intervals) {
                buildGraph(intervals);
                buildComponents(intervals);

                // for each component, merge all intervals into one interval.
                List<int[]> merged = new LinkedList<>();
                for (int comp = 0; comp < nodesInComp.size(); comp++) {
                    merged.add(mergeNodes(nodesInComp.get(comp)));
                }

                return merged.toArray(new int[merged.size()][]);
            }
        }

        class MergeIntervalsSort {
            public int[][] merge(int[][] intervals) {
                Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
                LinkedList<int[]> merged = new LinkedList<>();
                for (int[] interval : intervals) {
                    // if the list of merged intervals is empty or if the current
                    // interval does not overlap with the previous, simply append it.
                    if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                        merged.add(interval);
                    }
                    // otherwise, there is overlap, so we merge the current and previous
                    // intervals.
                    else {
                        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
                    }
                }
                return merged.toArray(new int[merged.size()][]);
            }
        }
    }

    // https://leetcode.com/problems/design-in-memory-file-system/
    class FileSys {
        class FileSystemSeparateDir {
            class Dir {
                HashMap<String, Dir> dirs = new HashMap<>();
                HashMap<String, String> files = new HashMap<>();
            }

            Dir root;

            public FileSystemSeparateDir() {
                root = new Dir();
            }

            public List<String> ls(String path) {
                Dir t = root;
                List<String> files = new ArrayList<>();
                if (!path.equals("/")) {
                    String[] d = path.split("/");
                    for (int i = 1; i < d.length - 1; i++) {
                        t = t.dirs.get(d[i]);
                    }
                    if (t.files.containsKey(d[d.length - 1])) {
                        files.add(d[d.length - 1]);
                        return files;
                    } else {
                        t = t.dirs.get(d[d.length - 1]);
                    }
                }
                files.addAll(new ArrayList<>(t.dirs.keySet()));
                files.addAll(new ArrayList<>(t.files.keySet()));
                Collections.sort(files);
                return files;
            }

            public void mkdir(String path) {
                Dir t = root;
                String[] d = path.split("/");
                for (int i = 1; i < d.length; i++) {
                    if (!t.dirs.containsKey(d[i]))
                        t.dirs.put(d[i], new Dir());
                    t = t.dirs.get(d[i]);
                }
            }

            public void addContentToFile(String filePath, String content) {
                Dir t = root;
                String[] d = filePath.split("/");
                for (int i = 1; i < d.length - 1; i++) {
                    t = t.dirs.get(d[i]);
                }
                t.files.put(d[d.length - 1], t.files.getOrDefault(d[d.length - 1], "") + content);
            }

            public String readContentFromFile(String filePath) {
                Dir t = root;
                String[] d = filePath.split("/");
                for (int i = 1; i < d.length - 1; i++) {
                    t = t.dirs.get(d[i]);
                }
                return t.files.get(d[d.length - 1]);
            }
        }

        /**
         * Your FileSystem object will be instantiated and called as such:
         * FileSystem obj = new FileSystem();
         * List<String> param_1 = obj.ls(path);
         * obj.mkdir(path);
         * obj.addContentToFile(filePath,content);
         * String param_4 = obj.readContentFromFile(filePath);
         */

        class FileSystemUnified {
            class File {
                boolean isfile = false;
                HashMap<String, File> files = new HashMap<>();
                String content = "";
            }

            File root;

            public FileSystemUnified() {
                root = new File();
            }

            public List<String> ls(String path) {
                File t = root;
                List<String> files = new ArrayList<>();
                if (!path.equals("/")) {
                    String[] d = path.split("/");
                    for (int i = 1; i < d.length; i++) {
                        t = t.files.get(d[i]);
                    }
                    if (t.isfile) {
                        files.add(d[d.length - 1]);
                        return files;
                    }
                }
                List<String> res_files = new ArrayList<>(t.files.keySet());
                Collections.sort(res_files);
                return res_files;
            }

            public void mkdir(String path) {
                File t = root;
                String[] d = path.split("/");
                for (int i = 1; i < d.length; i++) {
                    if (!t.files.containsKey(d[i]))
                        t.files.put(d[i], new File());
                    t = t.files.get(d[i]);
                }
            }

            public void addContentToFile(String filePath, String content) {
                File t = root;
                String[] d = filePath.split("/");
                for (int i = 1; i < d.length - 1; i++) {
                    t = t.files.get(d[i]);
                }
                if (!t.files.containsKey(d[d.length - 1]))
                    t.files.put(d[d.length - 1], new File());
                t = t.files.get(d[d.length - 1]);
                t.isfile = true;
                t.content = t.content + content;
            }

            public String readContentFromFile(String filePath) {
                File t = root;
                String[] d = filePath.split("/");
                for (int i = 1; i < d.length - 1; i++) {
                    t = t.files.get(d[i]);
                }
                return t.files.get(d[d.length - 1]).content;
            }
        }

        /**
         * Your FileSystem object will be instantiated and called as such:
         * FileSystem obj = new FileSystem();
         * List<String> param_1 = obj.ls(path);
         * obj.mkdir(path);
         * obj.addContentToFile(filePath,content);
         * String param_4 = obj.readContentFromFile(filePath);
         */
    }

    // https://leetcode.com/problems/lfu-cache/
    class LFUCache {
        // key: original key, value: frequency and original value.
        private Map<Integer, Pair<Integer, Integer>> cache;
        // key: frequency, value: All keys that have the same frequency.
        private Map<Integer, LinkedHashSet<Integer>> frequencies;
        private int minf;
        private int capacity;

        private void insert(int key, int frequency, int value) {
            cache.put(key, new Pair<>(frequency, value));
            frequencies.putIfAbsent(frequency, new LinkedHashSet<>());
            frequencies.get(frequency).add(key);
        }

        public LFUCache(int capacity) {
            cache = new HashMap<>();
            frequencies = new HashMap<>();
            minf = 0;
            this.capacity = capacity;
        }

        public int get(int key) {
            Pair<Integer, Integer> frequencyAndValue = cache.get(key);
            if (frequencyAndValue == null) {
                return -1;
            }
            final int frequency = frequencyAndValue.getKey();
            final Set<Integer> keys = frequencies.get(frequency);
            keys.remove(key);
            if (keys.isEmpty()) {
                frequencies.remove(frequency);

                if (minf == frequency) {
                    ++minf;
                }
            }
            final int value = frequencyAndValue.getValue();
            insert(key, frequency + 1, value);
            return value;
        }

        public void put(int key, int value) {
            if (capacity <= 0) {
                return;
            }
            Pair<Integer, Integer> frequencyAndValue = cache.get(key);
            if (frequencyAndValue != null) {
                cache.put(key, new Pair<>(frequencyAndValue.getKey(), value));
                get(key);
                return;
            }
            if (capacity == cache.size()) {
                final Set<Integer> keys = frequencies.get(minf);
                final int keyToDelete = keys.iterator().next();
                cache.remove(keyToDelete);
                keys.remove(keyToDelete);
                if (keys.isEmpty()) {
                    frequencies.remove(minf);
                }
            }
            minf = 1;
            insert(key, 1, value);
        }
    }

    // https://leetcode.com/problems/reconstruct-original-digits-from-english/editorial/
    class ReconstructOriginalDigits {
        public String originalDigits(String s) {
            // building hashmap letter -> its frequency
            char[] count = new char[26 + (int) 'a'];
            for (char letter : s.toCharArray()) {
                count[letter]++;
            }

            // building hashmap digit -> its frequency
            int[] out = new int[10];
            // letter "z" is present only in "zero"
            out[0] = count['z'];
            // letter "w" is present only in "two"
            out[2] = count['w'];
            // letter "u" is present only in "four"
            out[4] = count['u'];
            // letter "x" is present only in "six"
            out[6] = count['x'];
            // letter "g" is present only in "eight"
            out[8] = count['g'];
            // letter "h" is present only in "three" and "eight"
            out[3] = count['h'] - out[8];
            // letter "f" is present only in "five" and "four"
            out[5] = count['f'] - out[4];
            // letter "s" is present only in "seven" and "six"
            out[7] = count['s'] - out[6];
            // letter "i" is present in "nine", "five", "six", and "eight"
            out[9] = count['i'] - out[5] - out[6] - out[8];
            // letter "n" is present in "one", "nine", and "seven"
            out[1] = count['n'] - out[7] - 2 * out[9];

            // building output string
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < 10; i++)
                for (int j = 0; j < out[i]; j++)
                    output.append(i);
            return output.toString();
        }
    }

    // https://leetcode.com/problems/maximize-grid-happiness/
    /*
    explanation: maximize grid happiness using java and bitmasking, the algorithm uses 2 bits to encode type of people (ie introvert, extrovert and none) to combinations of people to be used, also as we observe, we only need one column (ie left and upper) element to get and find the maximum cost

    testcase: 2, 3, introverts=1, extroverts=2 -> Works

    Time & Space Complexity: O(m*n^2*2^n): The maximum states possible is mn_square 2^n, therefore the time complexity is this one, also space complexity is same due to maintaining dp space array.
    */
    class MaxGridHappy {
        int NONE = 0;
        int INTROVERT = 1;
        int EXTROVERT = 2;

        public int adjust(int board, int this_is, int col, int index) {
            int shift_by = 2 * (col - 1);

            // Get left member first
            int left = board & 0x03;
            if (index % col == 0)
                left = NONE;

            int up = (board >> shift_by) & 0x03;
            // System.out.println("left:"+left+" up:"+Integer.toBinaryString(up));

            int[] combination = new int[]{left, up};

            int adjustment = 0;
            for (int bit : combination) {
                if (bit == NONE) {
                    // for none bit, skip
                    continue;
                }
                if (bit == INTROVERT && this_is == INTROVERT) {
                    // Neighbour is introvert, and I am also introvert, ie lose 30 and 30
                    adjustment += -60;
                } else if (bit == INTROVERT && this_is == EXTROVERT) {
                    adjustment += -10;
                } else if (bit == EXTROVERT && this_is == INTROVERT) {
                    adjustment += -10;
                } else if (bit == EXTROVERT && this_is == EXTROVERT) {
                    adjustment += 40;
                }
            }

            return adjustment;
        }

        public int maxHappiness(int index, int m, int n, int introverts, int extroverts, int board, int[][][][] dp, int tmask) {
            if (index >= m * n)
                return 0;

            int ans = -1;
            int intro_score = -1;
            int extro_score = -1;

            if (dp[index][introverts][extroverts][board] != 0) return dp[index][introverts][extroverts][board];
            // System.out.println("Called on "+index+" "+"intro:"+introverts+", extro:"+extroverts+", board: " + String.format("%4s", Integer.toBinaryString(board)).replace(' ', '0'));

            // If there are introverts and extroverts left, then try setting into this cell both of them and find best answer!
            if (introverts > 0) {
                // Place introverts here, and calculate other things..!
                int new_board = ((board << 2) | INTROVERT) & tmask;
                intro_score = 120 + adjust(board, INTROVERT, n, index) + maxHappiness(index + 1, m, n, introverts - 1, extroverts, new_board, dp, tmask);
            }

            if (extroverts > 0) {
                // Place extroverts here, and calculate other things..!
                int new_board = ((board << 2) | EXTROVERT) & tmask;
                extro_score = 40 + adjust(board, EXTROVERT, n, index) + maxHappiness(index + 1, m, n, introverts, extroverts - 1, new_board, dp, tmask);
            }

            int new_board = ((board << 2) | NONE) & tmask;
            // Or just skip!
            int skip = maxHappiness(index + 1, m, n, introverts, extroverts, new_board, dp, tmask);

            // System.out.println("Return Called on "+index+" "+"intro:"+introverts+", extro:"+extroverts+", board: " + String.format("%4s", Integer.toBinaryString(board)).replace(' ', '0') + ", in_score: "+intro_score+" ex_score: "+extro_score+" skip: "+skip);

            return dp[index][introverts][extroverts][board] = Math.max(skip, Math.max(intro_score, extro_score));
        }

        public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
            int[][][][] dp = new int[m * n][introvertsCount + 1][extrovertsCount + 1][(int) Math.pow(2, 5 * 2)];

            return maxHappiness(0, m, n, introvertsCount, extrovertsCount, 0, dp, (int) Math.pow(2, 2 * n) - 1);
        }
    }

    // https://leetcode.com/problems/largest-number/
    class LargestNumber {
        private class LargerNumberComparator implements Comparator<String> {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        }

        public String largestNumber(int[] nums) {
            // Get input integers as strings.
            String[] asStrs = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                asStrs[i] = String.valueOf(nums[i]);
            }

            // Sort strings according to custom comparator.
            Arrays.sort(asStrs, new LargerNumberComparator());

            // If, after being sorted, the largest number is `0`, the entire number
            // is zero.
            if (asStrs[0].equals("0")) {
                return "0";
            }

            // Build largest number from sorted array.
            String largestNumberStr = new String();
            for (String numAsStr : asStrs) {
                largestNumberStr += numAsStr;
            }

            return largestNumberStr;
        }
    }

    // https://leetcode.com/problems/word-break/
    class WordBreak {
        class WordBreakBFS {
            public boolean wordBreak(String s, List<String> wordDict) {
                Set<String> words = new HashSet<>(wordDict);
                Queue<Integer> queue = new LinkedList<>();
                boolean[] seen = new boolean[s.length() + 1];
                queue.add(0);

                while (!queue.isEmpty()) {
                    int start = queue.remove();
                    if (start == s.length()) {
                        return true;
                    }

                    for (int end = start + 1; end <= s.length(); end++) {
                        if (seen[end]) {
                            continue;
                        }

                        if (words.contains(s.substring(start, end))) {
                            queue.add(end);
                            seen[end] = true;
                        }
                    }
                }

                return false;
            }
        }

        class WorkBreakTD {
            private String s;
            private List<String> wordDict;
            private int[] memo;

            private boolean dp(int i) {
                if (i < 0) return true;

                if (memo[i] != -1) {
                    return memo[i] == 1;
                }

                for (String word : wordDict) {
                    // Handle out of bounds case
                    if (i - word.length() + 1 < 0) {
                        continue;
                    }

                    if (s.substring(i - word.length() + 1, i + 1).equals(word) && dp(i - word.length())) {
                        memo[i] = 1;
                        return true;
                    }
                }

                memo[i] = 0;
                return false;
            }

            public boolean wordBreak(String s, List<String> wordDict) {
                this.s = s;
                this.wordDict = wordDict;
                this.memo = new int[s.length()];
                Arrays.fill(this.memo, -1);
                return dp(s.length() - 1);
            }
        }

        class WordBreakBU {
            public boolean wordBreak(String s, List<String> wordDict) {
                boolean[] dp = new boolean[s.length()];
                for (int i = 0; i < s.length(); i++) {
                    for (String word : wordDict) {
                        // Handle out of bounds case
                        if (i < word.length() - 1) {
                            continue;
                        }

                        if (i == word.length() - 1 || dp[i - word.length()]) {
                            if (s.substring(i - word.length() + 1, i + 1).equals(word)) {
                                dp[i] = true;
                                break;
                            }
                        }
                    }
                }

                return dp[s.length() - 1];
            }
        }

        class WordBreakDP {
            public boolean wordBreak(String s, List<String> wordDict) {
                int n = s.length();
                Set<String> words = new HashSet<>(wordDict);
                boolean[] dp = new boolean[n + 1];
                dp[0] = true;

                for (int i = 1; i <= n; i++) {
                    for (int j = 0; j < i; j++) {
                        if (dp[j] && words.contains(s.substring(j, i))) {
                            dp[i] = true;
                            break;
                        }
                    }
                }

                return dp[n];
            }
        }
    }

    // https://leetcode.com/problems/stickers-to-spell-word/solutions/962702/java-4-ms-100-bfs-explanation-and-complexity-analysis/
    class StickersSpell {
        private boolean empty(int[] freq) {
            for (int f : freq) if (f > 0) return false;
            return true;
        }

        private String toString(int[] freq) {
            StringBuilder sb = new StringBuilder();
            char c = 'a';
            for (int f : freq) {
                while (f-- > 0) sb.append(c);
                c++;
            }
            return sb.toString();
        }

        public int minStickers(String[] stickers, String target) {
            // Optimization 1: Maintain frequency only for characters present in target
            int[] targetNaiveCount = new int[26];
            for (char c : target.toCharArray()) targetNaiveCount[c - 'a']++;
            int[] index = new int[26];
            int N = 0;  // no of distinct characters in target
            for (int i = 0; i < 26; i++) index[i] = targetNaiveCount[i] > 0 ? N++ : -1;
            int[] targetCount = new int[N];
            int t = 0;
            for (int c : targetNaiveCount)
                if (c > 0) {
                    targetCount[t++] = c;
                }
            int[][] stickersCount = new int[stickers.length][N];
            for (int i = 0; i < stickers.length; i++) {
                for (char c : stickers[i].toCharArray()) {
                    int j = index[c - 'a'];
                    if (j >= 0) stickersCount[i][j]++;
                }
            }
            // Optimization 2: Remove stickers dominated by some other sticker
            int start = 0;
            for (int i = 0; i < stickers.length; i++) {
                for (int j = start; j < stickers.length; j++)
                    if (j != i) {
                        int k = 0;
                        while (k < N && stickersCount[i][k] <= stickersCount[j][k]) k++;
                        if (k == N) {
                            int[] tmp = stickersCount[i];
                            stickersCount[i] = stickersCount[start];
                            stickersCount[start++] = tmp;
                            break;
                        }
                    }
            }
            // Perform BFS with target as source and an empty string as destination
            Queue<int[]> Q = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            Q.add(targetCount);
            int steps = 0;
            while (!Q.isEmpty()) {
                steps++;
                int size = Q.size();
                while (size-- > 0) {
                    int[] freq = Q.poll();
                    String cur = toString(freq);
                    if (visited.add(cur)) {
                        // Optimization 3: Only use stickers that are capable of removing first character from current string
                        int first = cur.charAt(0) - 'a';
                        for (int i = start; i < stickers.length; i++)
                            if (stickersCount[i][first] != 0) {
                                int[] next = freq.clone();
                                for (int j = 0; j < N; j++) next[j] = Math.max(next[j] - stickersCount[i][j], 0);
                                if (empty(next)) return steps;
                                Q.add(next);
                            }
                    }
                }
            }
            return -1;
        }
    }

    // https://leetcode.com/problems/design-hashmap/
    class HMDesign {
        class Pair<U, V> {
            public U first;
            public V second;

            public Pair(U first, V second) {
                this.first = first;
                this.second = second;
            }
        }


        class Bucket {
            private List<Pair<Integer, Integer>> bucket;

            public Bucket() {
                this.bucket = new LinkedList<Pair<Integer, Integer>>();
            }

            public Integer get(Integer key) {
                for (Pair<Integer, Integer> pair : this.bucket) {
                    if (pair.first.equals(key))
                        return pair.second;
                }
                return -1;
            }

            public void update(Integer key, Integer value) {
                boolean found = false;
                for (Pair<Integer, Integer> pair : this.bucket) {
                    if (pair.first.equals(key)) {
                        pair.second = value;
                        found = true;
                    }
                }
                if (!found)
                    this.bucket.add(new Pair<Integer, Integer>(key, value));
            }

            public void remove(Integer key) {
                for (Pair<Integer, Integer> pair : this.bucket) {
                    if (pair.first.equals(key)) {
                        this.bucket.remove(pair);
                        break;
                    }
                }
            }
        }

        class MyHashMap {
            private int key_space;
            private List<Bucket> hash_table;

            /**
             * Initialize your data structure here.
             */
            public MyHashMap() {
                this.key_space = 2069;
                this.hash_table = new ArrayList<Bucket>();
                for (int i = 0; i < this.key_space; ++i) {
                    this.hash_table.add(new Bucket());
                }
            }

            /**
             * value will always be non-negative.
             */
            public void put(int key, int value) {
                int hash_key = key % this.key_space;
                this.hash_table.get(hash_key).update(key, value);
            }

            /**
             * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
             * for the key
             */
            public int get(int key) {
                int hash_key = key % this.key_space;
                return this.hash_table.get(hash_key).get(key);
            }

            /**
             * Removes the mapping of the specified value key if this map contains a mapping for the key
             */
            public void remove(int key) {
                int hash_key = key % this.key_space;
                this.hash_table.get(hash_key).remove(key);
            }
        }

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
 * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
 */
    }

    // https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
    class WaterGarden {
        class TapsToWaterGarden {
            public int minTaps(int n, int[] ranges) {
                // Define an infinite value
                final int INF = (int) 1e9;

                // Create an array to store the minimum number of taps needed for each position
                int[] dp = new int[n + 1];
                Arrays.fill(dp, INF);

                // Initialize the starting position of the garden
                dp[0] = 0;

                for (int i = 0; i <= n; i++) {
                    // Calculate the leftmost position reachable by the current tap
                    int tapStart = Math.max(0, i - ranges[i]);
                    // Calculate the rightmost position reachable by the current tap
                    int tapEnd = Math.min(n, i + ranges[i]);

                    for (int j = tapStart; j <= tapEnd; j++) {
                        // Update with the minimum number of taps
                        dp[tapEnd] = Math.min(dp[tapEnd], dp[j] + 1);
                    }
                }

                // Check if the garden can be watered completely
                if (dp[n] == INF) {
                    // Garden cannot be watered
                    return -1;
                }

                // Return the minimum number of taps needed to water the entire garden
                return dp[n];
            }
        }

        class TapsToWaterGardenGreedy {
            public int minTaps(int n, int[] ranges) {
                // Create an array to track the maximum reach for each position
                int[] maxReach = new int[n + 1];

                // Calculate the maximum reach for each tap
                for (int i = 0; i < ranges.length; i++) {
                    // Calculate the leftmost position the tap can reach
                    int start = Math.max(0, i - ranges[i]);
                    // Calculate the rightmost position the tap can reach
                    int end = Math.min(n, i + ranges[i]);

                    // Update the maximum reach for the leftmost position
                    maxReach[start] = Math.max(maxReach[start], end);
                }

                // Number of taps used
                int taps = 0;
                // Current rightmost position reached
                int currEnd = 0;
                // Next rightmost position that can be reached
                int nextEnd = 0;

                // Iterate through the garden
                for (int i = 0; i <= n; i++) {
                    // Current position cannot be reached
                    if (i > nextEnd) {
                        return -1;
                    }

                    // Increment taps when moving to a new tap
                    if (i > currEnd) {
                        taps++;
                        // Move to the rightmost position that can be reached
                        currEnd = nextEnd;
                    }

                    // Update the next rightmost position that can be reached
                    nextEnd = Math.max(nextEnd, maxReach[i]);
                }

                // Return the minimum number of taps used
                return taps;
            }
        }
    }

    // https://leetcode.com/problems/different-ways-to-add-parentheses/
    class WaysToAddParentheses {
        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> ret = new LinkedList<Integer>();
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '-' ||
                        input.charAt(i) == '*' ||
                        input.charAt(i) == '+') {
                    String part1 = input.substring(0, i);
                    String part2 = input.substring(i + 1);
                    List<Integer> part1Ret = diffWaysToCompute(part1);
                    List<Integer> part2Ret = diffWaysToCompute(part2);
                    for (Integer p1 : part1Ret) {
                        for (Integer p2 : part2Ret) {
                            int c = 0;
                            switch (input.charAt(i)) {
                                case '+':
                                    c = p1 + p2;
                                    break;
                                case '-':
                                    c = p1 - p2;
                                    break;
                                case '*':
                                    c = p1 * p2;
                                    break;
                            }
                            ret.add(c);
                        }
                    }
                }
            }
            if (ret.size() == 0) {
                ret.add(Integer.valueOf(input));
            }
            return ret;
        }
    }

    // https://leetcode.com/problems/maximum-frequency-stack/editorial/
    class FreqStack {
        Map<Integer, Integer> freq;
        Map<Integer, Stack<Integer>> group;
        int maxfreq;

        public FreqStack() {
            freq = new HashMap();
            group = new HashMap();
            maxfreq = 0;
        }

        public void push(int x) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            if (f > maxfreq)
                maxfreq = f;

            group.computeIfAbsent(f, z -> new Stack()).push(x);
        }

        public int pop() {
            int x = group.get(maxfreq).pop();
            freq.put(x, freq.get(x) - 1);
            if (group.get(maxfreq).size() == 0)
                maxfreq--;
            return x;
        }
    }

    // https://leetcode.com/problems/shortest-word-distance/
    class ShortestWordDistance {
        public int shortestDistance(String[] words, String word1, String word2) {
            int i1 = -1, i2 = -1;
            int minDistance = words.length;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    i1 = i;
                } else if (words[i].equals(word2)) {
                    i2 = i;
                }

                if (i1 != -1 && i2 != -1) {
                    minDistance = Math.min(minDistance, Math.abs(i1 - i2));
                }
            }
            return minDistance;
        }
    }
}