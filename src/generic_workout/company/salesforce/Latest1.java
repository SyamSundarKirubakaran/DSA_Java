package generic_workout.company.salesforce;

import java.util.*;

public class Latest1 {

    // https://leetcode.com/problems/word-break/
    static class WordBreak {
        static class WordBreakBFS {
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

            public static void main(String[] args) {
                WordBreakBFS wordBreakBFS = new WordBreakBFS();
                System.out.println(wordBreakBFS.wordBreak("leetcode", Arrays.asList("leet", "code")));
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

        static class WordBreakDP {
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

            public static void main(String[] args) {
                WordBreakDP wordBreakDP = new WordBreakDP();
                System.out.println(wordBreakDP.wordBreak("leetcode", Arrays.asList("leet", "code")));
            }
        }
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

    // https://leetcode.com/problems/stream-of-characters/
    static class StreamCharacters {
        static class TrieNode {
            Map<Character, TrieNode> children = new HashMap<>();
            boolean word = false;
        }

        static class StreamChecker {
            TrieNode trie = new TrieNode();
            Deque<Character> stream = new ArrayDeque<>();

            public StreamChecker(String[] words) {
                for (String word : words) {
                    TrieNode node = trie;
                    String reversedWord = new StringBuilder(word).reverse().toString();
                    for (char ch : reversedWord.toCharArray()) {
                        if (!node.children.containsKey(ch)) {
                            node.children.put(ch, new TrieNode());
                        }
                        node = node.children.get(ch);
                    }
                    node.word = true;
                }
                System.out.println("breakpoint");
            }

            public boolean query(char letter) {
                stream.addFirst(letter);

                TrieNode node = trie;
                for (char ch : stream) {
                    if (node.word) {
                        return true;
                    }
                    if (!node.children.containsKey(ch)) {
                        return false;
                    }
                    node = node.children.get(ch);
                }
                return node.word;
            }

            public static void main(String[] args) {
                StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});
                System.out.println(streamChecker.query('a'));
                System.out.println(streamChecker.query('b'));
                System.out.println(streamChecker.query('c'));
                System.out.println(streamChecker.query('d'));
                System.out.println(streamChecker.query('e'));
                System.out.println(streamChecker.query('f'));
                System.out.println(streamChecker.query('g'));
                System.out.println(streamChecker.query('h'));
                System.out.println(streamChecker.query('i'));
                System.out.println(streamChecker.query('j'));
                System.out.println(streamChecker.query('k'));
                System.out.println(streamChecker.query('l'));
            }

        }
    }

    // https://leetcode.com/problems/split-array-largest-sum/
    class SplitArr {
        class DPTopDown {
            // Defined it as per the maximum size of array and split count
            // But can be defined with the input size as well
            Integer[][] memo = new Integer[1001][51];

            private int getMinimumLargestSplitSum(int[] prefixSum, int currIndex, int subarrayCount) {
                int n = prefixSum.length - 1;

                // We have already calculated the answer so no need to go into recursion
                if (memo[currIndex][subarrayCount] != null) {
                    return memo[currIndex][subarrayCount];
                }

                // Base Case: If there is only one subarray left, then all of the remaining numbers
                // must go in the current subarray. So return the sum of the remaining numbers.
                if (subarrayCount == 1) {
                    return memo[currIndex][subarrayCount] = prefixSum[n] - prefixSum[currIndex];
                }

                // Otherwise, use the recurrence relation to determine the minimum largest subarray
                // sum between currIndex and the end of the array with subarrayCount subarrays remaining.
                int minimumLargestSplitSum = Integer.MAX_VALUE;
                for (int i = currIndex; i <= n - subarrayCount; i++) {
                    // Store the sum of the first subarray.
                    int firstSplitSum = prefixSum[i + 1] - prefixSum[currIndex];

                    // Find the maximum subarray sum for the current first split.
                    int largestSplitSum = Math.max(firstSplitSum,
                            getMinimumLargestSplitSum(prefixSum, i + 1, subarrayCount - 1));

                    // Find the minimum among all possible combinations.
                    minimumLargestSplitSum = Math.min(minimumLargestSplitSum, largestSplitSum);

                    if (firstSplitSum >= minimumLargestSplitSum) {
                        break;
                    }
                }

                return memo[currIndex][subarrayCount] = minimumLargestSplitSum;
            }

            public int splitArray(int[] nums, int m) {
                // Store the prefix sum of nums array.
                int n = nums.length;
                int[] prefixSum = new int[n + 1];

                for (int i = 0; i < n; i++) {
                    prefixSum[i + 1] = prefixSum[i] + nums[i];
                }

                return getMinimumLargestSplitSum(prefixSum, 0, m);
            }
        }

        class DPBottomUp {
            // Defined it as per the maximum size of array and split count
            // But can be defined with the input size as well
            int[][] memo = new int[1001][51];

            public int splitArray(int[] nums, int m) {
                int n = nums.length;

                // Store the prefix sum of nums array
                int[] prefixSum = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    prefixSum[i + 1] = prefixSum[i] + nums[i];
                }

                for (int subarrayCount = 1; subarrayCount <= m; subarrayCount++) {
                    for (int currIndex = 0; currIndex < n; currIndex++) {
                        // Base Case: If there is only one subarray left, then all of the remaining numbers
                        // must go in the current subarray. So return the sum of the remaining numbers.
                        if (subarrayCount == 1) {
                            memo[currIndex][subarrayCount] = prefixSum[n] - prefixSum[currIndex];
                            continue;
                        }

                        // Otherwise, use the recurrence relation to determine the minimum largest subarray
                        // sum between currIndex and the end of the array with subarrayCount subarray remaining.
                        int minimumLargestSplitSum = Integer.MAX_VALUE;
                        for (int i = currIndex; i <= n - subarrayCount; i++) {
                            // Store the sum of the first subarray.
                            int firstSplitSum = prefixSum[i + 1] - prefixSum[currIndex];

                            // Find the maximum subarray sum for the current first split.
                            int largestSplitSum = Math.max(firstSplitSum, memo[i + 1][subarrayCount - 1]);

                            // Find the minimum among all possible combinations.
                            minimumLargestSplitSum = Math.min(minimumLargestSplitSum, largestSplitSum);

                            if (firstSplitSum >= minimumLargestSplitSum) {
                                break;
                            }
                        }

                        memo[currIndex][subarrayCount] = minimumLargestSplitSum;
                    }
                }

                return memo[0][m];
            }

        }

        class BinarySearch {
            private int minimumSubarraysRequired(int[] nums, int maxSumAllowed) {
                int currentSum = 0;
                int splitsRequired = 0;

                for (int element : nums) {
                    // Add element only if the sum doesn't exceed maxSumAllowed
                    if (currentSum + element <= maxSumAllowed) {
                        currentSum += element;
                    } else {
                        // If the element addition makes sum more than maxSumAllowed
                        // Increment the splits required and reset sum
                        currentSum = element;
                        splitsRequired++;
                    }
                }

                // Return the number of subarrays, which is the number of splits + 1
                return splitsRequired + 1;
            }

            public int splitArray(int[] nums, int m) {
                // Find the sum of all elements and the maximum element
                int sum = 0;
                int maxElement = Integer.MIN_VALUE;
                for (int element : nums) {
                    sum += element;
                    maxElement = Math.max(maxElement, element);
                }

                // Define the left and right boundary of binary search
                int left = maxElement;
                int right = sum;
                int minimumLargestSplitSum = 0;
                while (left <= right) {
                    // Find the mid value
                    int maxSumAllowed = left + (right - left) / 2;

                    // Find the minimum splits. If splitsRequired is less than
                    // or equal to m move towards left i.e., smaller values
                    if (minimumSubarraysRequired(nums, maxSumAllowed) <= m) {
                        right = maxSumAllowed - 1;
                        minimumLargestSplitSum = maxSumAllowed;
                    } else {
                        // Move towards right if splitsRequired is more than m
                        left = maxSumAllowed + 1;
                    }
                }

                return minimumLargestSplitSum;
            }

        }
    }

    // https://leetcode.com/problems/reconstruct-original-digits-from-english/
    static class ReconstructOriginalDigits {

        /**
         * zero = 0
         * one  = 1
         * two  = 2
         * three= 3
         * four = 4
         * five = 5
         * six  = 6
         * seven= 7
         * eight= 8
         * nine = 9
         * We can observe that some characters are only present in some words only like :
         * z(zero) -> 0
         * x(six)  -> 6
         * u(four) -> 4
         * w(two)  -> 2
         * g(eight)-> 8
         * f(five + four) -> 5 && 4
         * O(one + two + four + zero) -> 1 && 2 && 4 && 0
         * t(three + eight + two) -> 3 && 8 && 2
         * s(seven + six) -> 7 && 6
         * i(nine + five + six + eight) -> 9 && 5 && 6 && 8
         */

        public String originalDigits(String s) {
            int[] map = new int[26]; //frequency of characters
            for (char ch : s.toCharArray()) map[ch - 'a']++;

            int[] digit = new int[10]; //frequency of numbers

            digit[0] = map['z' - 'a'];
            digit[6] = map['x' - 'a'];
            digit[4] = map['u' - 'a'];
            digit[2] = map['w' - 'a'];
            digit[8] = map['g' - 'a'];
            digit[5] = map['f' - 'a'] - digit[4];
            digit[7] = map['s' - 'a'] - digit[6];
            digit[3] = map['t' - 'a'] - digit[8] - digit[2];
            digit[1] = map['o' - 'a'] - digit[2] - digit[4] - digit[0];
            digit[9] = map['i' - 'a'] - digit[5] - digit[6] - digit[8];

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 10; i++) {
                int freq = digit[i];
                while (freq-- > 0) {
                    sb.append(i);
                }
            }
            return sb.toString();
        }

        public static void main(String[] args) {
            ReconstructOriginalDigits reconstructOriginalDigits = new ReconstructOriginalDigits();
            System.out.println(reconstructOriginalDigits.originalDigits("owoztneoer"));
        }

    }

    // https://leetcode.com/problems/search-suggestions-system/
    class SearchSuggestion {
        // Custom class Trie with function to get 3 words starting with given prefix
        class Trie {

            // Node definition of a trie
            class Node {
                boolean isWord = false;
                List<Node> children = Arrays.asList(new Node[26]);
            }

            Node Root, curr;
            List<String> resultBuffer;

            // Runs a DFS on trie starting with given prefix and adds all the words in the resultBuffer, limiting result size to 3
            void dfsWithPrefix(Node curr, String word) {
                if (resultBuffer.size() == 3)
                    return;
                if (curr.isWord)
                    resultBuffer.add(word);

                // Run DFS on all possible paths.
                for (char c = 'a'; c <= 'z'; c++)
                    if (curr.children.get(c - 'a') != null)
                        dfsWithPrefix(curr.children.get(c - 'a'), word + c);
            }

            Trie() {
                Root = new Node();
            }

            // Inserts the string in trie.
            void insert(String s) {

                // Points curr to the root of trie.
                curr = Root;
                for (char c : s.toCharArray()) {
                    if (curr.children.get(c - 'a') == null)
                        curr.children.set(c - 'a', new Node());
                    curr = curr.children.get(c - 'a');
                }

                // Mark this node as a completed word.
                curr.isWord = true;
            }

            List<String> getWordsStartingWith(String prefix) {
                curr = Root;
                resultBuffer = new ArrayList<String>();
                // Move curr to the end of prefix in its trie representation.
                for (char c : prefix.toCharArray()) {
                    if (curr.children.get(c - 'a') == null)
                        return resultBuffer;
                    curr = curr.children.get(c - 'a');
                }
                dfsWithPrefix(curr, prefix);
                return resultBuffer;
            }
        }

        List<List<String>> suggestedProducts(String[] products,
                                             String searchWord) {
            Trie trie = new Trie();
            List<List<String>> result = new ArrayList<>();
            // Add all words to trie.
            for (String w : products)
                trie.insert(w);
            String prefix = new String();
            for (char c : searchWord.toCharArray()) {
                prefix += c;
                result.add(trie.getWordsStartingWith(prefix));
            }
            return result;
        }

    }

    // https://leetcode.com/problems/beautiful-arrangement/
    class BeautifulArrangement {
        int count = 0;

        public int countArrangement(int N) {
            boolean[] visited = new boolean[N + 1];
            calculate(N, 1, visited);
            return count;
        }

        public void calculate(int N, int pos, boolean[] visited) {
            if (pos > N)
                count++;
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                    visited[i] = true;
                    calculate(N, pos + 1, visited);
                    visited[i] = false;
                }
            }
        }
    }

    // https://leetcode.com/problems/degree-of-an-array/
    class DegreeArr {
        public int findShortestSubArray(int[] nums) {
            Map<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(), count = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];
                if (left.get(x) == null) left.put(x, i);
                right.put(x, i);
                count.put(x, count.getOrDefault(x, 0) + 1);
            }

            int ans = nums.length;
            int degree = Collections.max(count.values());
            for (int x : count.keySet()) {
                if (count.get(x) == degree) {
                    ans = Math.min(ans, right.get(x) - left.get(x) + 1);
                }
            }
            return ans;
        }
    }

    // https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
    class CapacityToShip {
        // Check whether the packages can be shipped in less than "days" days with
        // "c" capacity.
        Boolean feasible(int[] weights, int c, int days) {
            int daysNeeded = 1, currentLoad = 0;
            for (int weight : weights) {
                currentLoad += weight;
                if (currentLoad > c) {
                    daysNeeded++;
                    currentLoad = weight;
                }
            }

            return daysNeeded <= days;
        }

        public int shipWithinDays(int[] weights, int days) {
            int totalLoad = 0, maxLoad = 0;
            for (int weight : weights) {
                totalLoad += weight;
                maxLoad = Math.max(maxLoad, weight);
            }

            int l = maxLoad, r = totalLoad;

            while (l < r) {
                int mid = (l + r) / 2;
                if (feasible(weights, mid, days)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
    }

    // https://leetcode.com/problems/different-ways-to-add-parentheses/
    class DiffParentheses {
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

    // https://leetcode.com/problems/maximum-difference-between-increasing-elements/
    class MaxDiff {
        public int maximumDifference(int[] nums) {
            int diff = -1;
            for (int i = 1, min = nums[0]; i < nums.length; ++i) {
                if (min < nums[i]) {
                    diff = Math.max(diff, nums[i] - min);
                }
                min = Math.min(min, nums[i]);
            }
            return diff;
        }
    }

    // https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/description/
    class PartitionArr {
        public int minimumDifference(int[] nums) {
            int n = nums.length;
            if (n == 2) return Math.abs(nums[1] - nums[0]);
            int[][] lists1 = generate(Arrays.copyOfRange(nums, 0, n / 2));
            int[][] lists2 = generate(Arrays.copyOfRange(nums, n / 2, n));
            int ans = Integer.MAX_VALUE;
            for (int d = 0; d <= n / 2; d++) {
                int[] arr1 = lists1[d], arr2 = lists2[d];
                int k = arr1.length;
                int i1 = 0, i2 = 0; // we use two pointers to find two elements in arr1, arr2 with minimum absolute difference
                while (i1 < k && i2 < k) {
                    int diff = arr1[i1] - arr2[i2];
                    ans = Math.min(ans, Math.abs(diff));
                    if (diff <= 0) i1++;
                    if (diff >= 0) i2++;
                }
            }
            return ans;
        }

        private int[][] generate(int[] nums) {
            int n = nums.length;
            int total = 0;
            for (int num : nums) total += num;
            int[][] ans = new int[n + 1][];
            int[] pos = new int[n + 1];
            for (int i = 0, binomial = 1; i <= n; i++) {
                ans[i] = new int[binomial]; // number of ways to choose i from n = binomial(i,n)
                binomial = binomial * (n - i) / (i + 1);
            }
            int maxValue = 1 << n;
            for (int key = 0; key < maxValue; key++) {
                int sum1 = 0;
                for (int i = 0; i < n; i++) {
                    if ((key >> i & 1) == 1) sum1 += nums[i];
                }
                int sum2 = total - sum1;
                int bits = Integer.bitCount(key);
                ans[bits][pos[bits]++] = sum1 - sum2;
            }
            for (int[] arr : ans) Arrays.sort(arr);
            return ans;
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

    // https://leetcode.com/problems/ipo/
    class IPO {
        class Project implements Comparable<Project> {
            int capital, profit;

            public Project(int capital, int profit) {
                this.capital = capital;
                this.profit = profit;
            }

            public int compareTo(Project project) {
                return capital - project.capital;
            }
        }

        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            int n = profits.length;
            Project[] projects = new Project[n];
            for (int i = 0; i < n; i++) {
                projects[i] = new Project(capital[i], profits[i]);
            }
            Arrays.sort(projects);
            // PriorityQueue is a min heap, but we need a max heap, so we use
            // Collections.reverseOrder()
            PriorityQueue<Integer> q = new PriorityQueue<Integer>(n, Collections.reverseOrder());
            int ptr = 0;
            for (int i = 0; i < k; i++) {
                while (ptr < n && projects[ptr].capital <= w) {
                    q.add(projects[ptr++].profit);
                }
                if (q.isEmpty()) {
                    break;
                }
                w += q.poll();
            }
            return w;
        }
    }

    // https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
    class PairOfSongs60 {
        public int numPairsDivisibleBy60(int[] time) {
            int remainders[] = new int[60];
            int count = 0;
            for (int t : time) {
                if (t % 60 == 0) { // check if a%60==0 && b%60==0
                    count += remainders[0];
                } else { // check if a%60+b%60==60
                    count += remainders[60 - t % 60];
                }
                remainders[t % 60]++; // remember to update the remainders
            }
            return count;
        }
    }


}
