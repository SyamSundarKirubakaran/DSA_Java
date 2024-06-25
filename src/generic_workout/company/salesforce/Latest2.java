package generic_workout.company.salesforce;

import java.util.*;

public class Latest2 {

    // https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/editorial/
    class KthSmallestSortMatrix {
        class MyHeapNode {

            int row;
            int column;
            int value;

            public MyHeapNode(int v, int r, int c) {
                this.value = v;
                this.row = r;
                this.column = c;
            }

            public int getValue() {
                return this.value;
            }

            public int getRow() {
                return this.row;
            }

            public int getColumn() {
                return this.column;
            }
        }

        class MyHeapComparator implements Comparator<MyHeapNode> {
            public int compare(MyHeapNode x, MyHeapNode y) {
                return x.value - y.value;
            }
        }

        class Solution {

            public int kthSmallest(int[][] matrix, int k) {

                int N = matrix.length;

                PriorityQueue<MyHeapNode> minHeap =
                        new PriorityQueue<MyHeapNode>(Math.min(N, k), new MyHeapComparator());

                // Preparing our min-heap
                for (int r = 0; r < Math.min(N, k); r++) {

                    // We add triplets of information for each cell
                    minHeap.offer(new MyHeapNode(matrix[r][0], r, 0));
                }

                MyHeapNode element = minHeap.peek();
                while (k-- > 0) {

                    // Extract-Min
                    element = minHeap.poll();
                    int r = element.getRow(), c = element.getColumn();

                    // If we have any new elements in the current row, add them
                    if (c < N - 1) {

                        minHeap.offer(new MyHeapNode(matrix[r][c + 1], r, c + 1));
                    }
                }

                return element.getValue();
            }
        }
    }

    // https://leetcode.com/problems/predict-the-winner/
    class PredictWinner {
        class Recursion {
            private int maxDiff(int[] nums, int left, int right, int n) {
                if (left == right) {
                    return nums[left];
                }

                int scoreByLeft = nums[left] - maxDiff(nums, left + 1, right, n);
                int scoreByRight = nums[right] - maxDiff(nums, left, right - 1, n);

                return Math.max(scoreByLeft, scoreByRight);
            }

            public boolean predictTheWinner(int[] nums) {
                int n = nums.length;

                return maxDiff(nums, 0, n - 1, n) >= 0;
            }
        }

        class DPTopDown {
            int[][] memo;

            private int maxDiff(int[] nums, int left, int right, int n) {
                if (memo[left][right] != -1) {
                    return memo[left][right];
                }
                if (left == right) {
                    return nums[left];
                }

                int scoreByLeft = nums[left] - maxDiff(nums, left + 1, right, n);
                int scoreByRight = nums[right] - maxDiff(nums, left, right - 1, n);
                memo[left][right] = Math.max(scoreByLeft, scoreByRight);

                return memo[left][right];
            }

            public boolean predictTheWinner(int[] nums) {
                int n = nums.length;
                memo = new int[n][n];
                for (int i = 0; i < n; ++i) {
                    Arrays.fill(memo[i], -1);
                }

                return maxDiff(nums, 0, n - 1, n) >= 0;
            }
        }

        class DPBottomUp {
            public boolean predictTheWinner(int[] nums) {
                int n = nums.length;
                int[][] dp = new int[n][n];
                for (int i = 0; i < n; ++i) {
                    dp[i][i] = nums[i];
                }

                for (int diff = 1; diff < n; ++diff) {
                    for (int left = 0; left < n - diff; ++left) {
                        int right = left + diff;
                        dp[left][right] = Math.max(nums[left] - dp[left + 1][right],
                                nums[right] - dp[left][right - 1]);
                    }
                }

                return dp[0][n - 1] >= 0;
            }
        }
    }

    // https://leetcode.com/problems/distinct-subsequences/
    class distinctSubSequence {

        public int numDistinct(String s, String t) {

            int M = s.length();
            int N = t.length();

            int[][] dp = new int[M + 1][N + 1];

            // Base case initialization
            for (int j = 0; j <= N; j++) {
                dp[M][j] = 0;
            }

            // Base case initialization
            for (int i = 0; i <= M; i++) {
                dp[i][N] = 1;
            }

            // Iterate over the strings in reverse so as to
            // satisfy the way we've modeled our recursive solution
            for (int i = M - 1; i >= 0; i--) {
                for (int j = N - 1; j >= 0; j--) {

                    // Remember, we always need this result
                    dp[i][j] = dp[i + 1][j];

                    // If the characters match, we add the
                    // result of the next recursion call (in this
                    // case, the value of a cell in the dp table
                    if (s.charAt(i) == t.charAt(j)) {
                        dp[i][j] += dp[i + 1][j + 1];
                    }
                }
            }

            return dp[0][0];
        }
    }

    // https://leetcode.com/problems/asteroid-collision/
    class AstroidCollision {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> st = new Stack<Integer>();

            for (int asteroid : asteroids) {
                boolean flag = true;
                while (!st.isEmpty() && (st.peek() > 0 && asteroid < 0)) {
                    // If the top asteroid in the stack is smaller, then it will explode.
                    // Hence pop it from the stack, also continue with the next asteroid in the stack.
                    if (Math.abs(st.peek()) < Math.abs(asteroid)) {
                        st.pop();
                        continue;
                    }
                    // If both asteroids have the same size, then both asteroids will explode.
                    // Pop the asteroid from the stack; also, we won't push the current asteroid to the stack.
                    else if (Math.abs(st.peek()) == Math.abs(asteroid)) {
                        st.pop();
                    }

                    // If we reach here, the current asteroid will be destroyed
                    // Hence, we should not add it to the stack
                    flag = false;
                    break;
                }

                if (flag) {
                    st.push(asteroid);
                }
            }

            // Add the asteroids from the stack to the vector in the reverse order.
            int[] remainingAsteroids = new int[st.size()];
            for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
                remainingAsteroids[i] = st.peek();
                st.pop();
            }

            return remainingAsteroids;
        }
    }

    // https://leetcode.com/problems/meeting-rooms-ii/
    class MeetingRoom2 {
        public int minMeetingRooms(int[][] intervals) {

            // Check for the base case. If there are no intervals, return 0
            if (intervals.length == 0) {
                return 0;
            }

            // Min heap
            PriorityQueue<Integer> allocator =
                    new PriorityQueue<Integer>(
                            intervals.length,
                            new Comparator<Integer>() {
                                public int compare(Integer a, Integer b) {
                                    return a - b;
                                }
                            });

            // Sort the intervals by start time
            Arrays.sort(
                    intervals,
                    new Comparator<int[]>() {
                        public int compare(final int[] a, final int[] b) {
                            return a[0] - b[0];
                        }
                    });

            // Add the first meeting
            allocator.add(intervals[0][1]);

            // Iterate over remaining intervals
            for (int i = 1; i < intervals.length; i++) {

                // If the room due to free up the earliest is free, assign that room to this meeting.
                if (intervals[i][0] >= allocator.peek()) {
                    allocator.poll();
                }

                // If a new room is to be assigned, then also we add to the heap,
                // If an old room is allocated, then also we have to add to the heap with updated end time.
                allocator.add(intervals[i][1]);
            }

            // The size of the heap tells us the minimum rooms required for all the meetings.
            return allocator.size();
        }
    }

    // https://leetcode.com/problems/valid-parentheses/
    class ValidParentheses {

        // Hash table that takes care of the mappings.
        private HashMap<Character, Character> mappings;

        // Initialize hash map with mappings. This simply makes the code easier to read.
        public ValidParentheses() {
            this.mappings = new HashMap<Character, Character>();
            this.mappings.put(')', '(');
            this.mappings.put('}', '{');
            this.mappings.put(']', '[');
        }

        public boolean isValid(String s) {

            // Initialize a stack to be used in the algorithm.
            Stack<Character> stack = new Stack<Character>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // If the current character is a closing bracket.
                if (this.mappings.containsKey(c)) {

                    // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                    char topElement = stack.empty() ? '#' : stack.pop();

                    // If the mapping for this bracket doesn't match the stack's top element, return false.
                    if (topElement != this.mappings.get(c)) {
                        return false;
                    }
                } else {
                    // If it was an opening bracket, push to the stack.
                    stack.push(c);
                }
            }

            // If the stack still contains elements, then it is an invalid expression.
            return stack.isEmpty();
        }
    }

    // https://leetcode.com/problems/triangle/
    class Triangle {
        class DPBottomUpInplace {
            // DP Bottom Up
            public int minimumTotal(List<List<Integer>> triangle) {
                for (int row = 1; row < triangle.size(); row++) {
                    for (int col = 0; col <= row; col++) {
                        int smallestAbove = Integer.MAX_VALUE;
                        if (col > 0) {
                            smallestAbove = triangle.get(row - 1).get(col - 1);
                        }
                        if (col < row) {
                            smallestAbove = Math.min(smallestAbove, triangle.get(row - 1).get(col));
                        }
                        int path = smallestAbove + triangle.get(row).get(col);
                        triangle.get(row).set(col, path);
                    }
                }
                return Collections.min(triangle.get(triangle.size() - 1));
            }
        }

        class DPTopDown {

            private Map<String, Integer> memoTable;
            private List<List<Integer>> triangle;

            private int minPath(int row, int col) {
                String params = row + ":" + col;
                if (memoTable.containsKey(params)) {
                    return memoTable.get(params);
                }
                int path = triangle.get(row).get(col);
                if (row < triangle.size() - 1) {
                    path += Math.min(minPath(row + 1, col), minPath(row + 1, col + 1));
                }
                memoTable.put(params, path);
                return path;
            }

            public int minimumTotal(List<List<Integer>> triangle) {
                this.triangle = triangle;
                memoTable = new HashMap<>();
                return minPath(0, 0);
            }
        }
    }

    // https://leetcode.com/problems/reverse-words-in-a-string-iii/
    class ReverseWord3 {

        public String reverseWords(String s) {
            int lastSpaceIndex = -1;
            char[] chArray = s.toCharArray();
            int len = s.length();
            for (int strIndex = 0; strIndex <= len; strIndex++) {
                if (strIndex == len || chArray[strIndex] == ' ') {
                    int startIndex = lastSpaceIndex + 1;
                    int endIndex = strIndex - 1;
                    while (startIndex < endIndex) {
                        char temp = chArray[startIndex];
                        chArray[startIndex] = chArray[endIndex];
                        chArray[endIndex] = temp;
                        startIndex++;
                        endIndex--;
                    }
                    lastSpaceIndex = strIndex;
                }
            }
            return new String(chArray);
        }

    }

    // https://leetcode.com/problems/decode-ways/
    class DecodeWays {
        class RecursiveMemorization {

            Map<Integer, Integer> memo = new HashMap<>();

            public int numDecodings(String s) {
                return recursiveWithMemo(0, s);
            }

            private int recursiveWithMemo(int index, String str) {
                // Have we already seen this substring?
                if (memo.containsKey(index)) {
                    return memo.get(index);
                }

                // If you reach the end of the string
                // Return 1 for success.
                if (index == str.length()) {
                    return 1;
                }

                // If the string starts with a zero, it can't be decoded
                if (str.charAt(index) == '0') {
                    return 0;
                }

                if (index == str.length() - 1) {
                    return 1;
                }


                int ans = recursiveWithMemo(index + 1, str);
                if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
                    ans += recursiveWithMemo(index + 2, str);
                }

                // Save for memoization
                memo.put(index, ans);

                return ans;
            }
        }

        class Iterative {

            public int numDecodings(String s) {
                // DP array to store the subproblem results
                int[] dp = new int[s.length() + 1];
                dp[0] = 1;

                // Ways to decode a string of size 1 is 1. Unless the string is '0'.
                // '0' doesn't have a single digit decode.
                dp[1] = s.charAt(0) == '0' ? 0 : 1;

                for (int i = 2; i < dp.length; i++) {
                    // Check if successful single digit decode is possible.
                    if (s.charAt(i - 1) != '0') {
                        dp[i] = dp[i - 1];
                    }

                    // Check if successful two digit decode is possible.
                    int twoDigit = Integer.valueOf(s.substring(i - 2, i));
                    if (twoDigit >= 10 && twoDigit <= 26) {
                        dp[i] += dp[i - 2];
                    }
                }

                return dp[s.length()];
            }
        }
    }

    // https://leetcode.com/problems/majority-element-ii/
    class MajorityElement2 {

        // Boyer-Moore Voting Algorithm

        public List<Integer> majorityElement(int[] nums) {

            // 1st pass
            int count1 = 0;
            int count2 = 0;

            Integer candidate1 = null;
            Integer candidate2 = null;

            for (int n : nums) {
                if (candidate1 != null && candidate1 == n) {
                    count1++;
                } else if (candidate2 != null && candidate2 == n) {
                    count2++;
                } else if (count1 == 0) {
                    candidate1 = n;
                    count1++;
                } else if (count2 == 0) {
                    candidate2 = n;
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }

            // 2nd pass
            List result = new ArrayList<>();

            count1 = 0;
            count2 = 0;

            for (int n : nums) {
                if (candidate1 != null && n == candidate1) count1++;
                if (candidate2 != null && n == candidate2) count2++;
            }

            int n = nums.length;
            if (count1 > n / 3) result.add(candidate1);
            if (count2 > n / 3) result.add(candidate2);

            return result;
        }
    }

    // https://leetcode.com/problems/kth-largest-element-in-an-array/
    class KthLargestElement {
        class Heap {
            public int findKthLargest(int[] nums, int k) {
                PriorityQueue<Integer> heap = new PriorityQueue<>();
                for (int num : nums) {
                    heap.add(num);
                    if (heap.size() > k) {
                        heap.remove();
                    }
                }

                return heap.peek();
            }
        }

        class QuickSelect {
            public int findKthLargest(int[] nums, int k) {
                List<Integer> list = new ArrayList<>();
                for (int num : nums) {
                    list.add(num);
                }

                return quickSelect(list, k);
            }

            public int quickSelect(List<Integer> nums, int k) {
                int pivotIndex = new Random().nextInt(nums.size());
                int pivot = nums.get(pivotIndex);

                List<Integer> left = new ArrayList<>();
                List<Integer> mid = new ArrayList<>();
                List<Integer> right = new ArrayList<>();

                for (int num : nums) {
                    if (num > pivot) {
                        left.add(num);
                    } else if (num < pivot) {
                        right.add(num);
                    } else {
                        mid.add(num);
                    }
                }

                if (k <= left.size()) {
                    return quickSelect(left, k);
                }

                if (left.size() + mid.size() < k) {
                    return quickSelect(right, k - left.size() - mid.size());
                }

                return pivot;
            }
        }

        class CountingSort {
            public int findKthLargest(int[] nums, int k) {
                int minValue = Integer.MAX_VALUE;
                int maxValue = Integer.MIN_VALUE;

                for (int num : nums) {
                    minValue = Math.min(minValue, num);
                    maxValue = Math.max(maxValue, num);
                }

                int[] count = new int[maxValue - minValue + 1];
                for (int num : nums) {
                    count[num - minValue]++;
                }

                int remain = k;
                for (int num = count.length - 1; num >= 0; num--) {
                    remain -= count[num];
                    if (remain <= 0) {
                        return num + minValue;
                    }
                }

                return -1;
            }
        }
    }

    // https://leetcode.com/problems/is-subsequence/
    class IsSubSequence {
        class Greedy {
            String source, target;
            Integer leftBound, rightBound;

            private boolean rec_isSubsequence(int leftIndex, int rightIndex) {
                // base cases
                if (leftIndex == leftBound)
                    return true;
                if (rightIndex == rightBound)
                    return false;

                // consume both strings or just the target string
                if (source.charAt(leftIndex) == target.charAt(rightIndex))
                    ++leftIndex;
                ++rightIndex;

                return rec_isSubsequence(leftIndex, rightIndex);
            }

            public boolean isSubsequence(String s, String t) {
                this.source = s;
                this.target = t;
                this.leftBound = s.length();
                this.rightBound = t.length();

                return rec_isSubsequence(0, 0);
            }
        }

        class DP {

            public boolean isSubsequence(String s, String t) {

                Integer sourceLen = s.length(), targetLen = t.length();
                // the source string is empty
                if (sourceLen == 0)
                    return true;

                int[][] dp = new int[sourceLen + 1][targetLen + 1];
                // DP calculation, we fill the matrix column by column, bottom up
                for (int col = 1; col <= targetLen; ++col) {
                    for (int row = 1; row <= sourceLen; ++row) {
                        if (s.charAt(row - 1) == t.charAt(col - 1))
                            // find another match
                            dp[row][col] = dp[row - 1][col - 1] + 1;
                        else
                            // retrieve the maximal result from previous prefixes
                            dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
                    }
                    // check if we can consume the entire source string,
                    // with the current prefix of the target string.
                    if (dp[sourceLen][col] == sourceLen)
                        return true;
                }

                // matching failure
                return false;
            }
        }
    }

    // https://leetcode.com/problems/trapping-rain-water/
    class TrapRainWater {
        public int trap(int[] height) {
            int left = 0, right = height.length - 1;
            int leftMax = height[0], rightMax = height[height.length - 1];
            int water = 0;
            while (left < right) {
                if (leftMax < rightMax) {
                    left++;
                    if (leftMax < height[left]) {
                        leftMax = height[left];
                    } else {
                        water += leftMax - height[left];
                    }
                } else {
                    right--;
                    if (rightMax < height[right]) {
                        rightMax = height[right];
                    } else {
                        water += rightMax - height[right];
                    }
                }
            }
            return water;
        }
    }

    // https://leetcode.com/problems/majority-element/
    class MajorityElement {
        class MooreVoting {
            public int majorityElement(int[] nums) {
                int count = 0;
                Integer candidate = null;

                for (int num : nums) {
                    if (count == 0) {
                        candidate = num;
                    }
                    count += (num == candidate) ? 1 : -1;
                }

                return candidate;
            }
        }

        class DivideAndConquer {
            private int countInRange(int[] nums, int num, int lo, int hi) {
                int count = 0;
                for (int i = lo; i <= hi; i++) {
                    if (nums[i] == num) {
                        count++;
                    }
                }
                return count;
            }

            private int majorityElementRec(int[] nums, int lo, int hi) {
                // base case; the only element in an array of size 1 is the majority
                // element.
                if (lo == hi) {
                    return nums[lo];
                }

                // recurse on left and right halves of this slice.
                int mid = (hi - lo) / 2 + lo;
                int left = majorityElementRec(nums, lo, mid);
                int right = majorityElementRec(nums, mid + 1, hi);

                // if the two halves agree on the majority element, return it.
                if (left == right) {
                    return left;
                }

                // otherwise, count each element and return the "winner".
                int leftCount = countInRange(nums, left, lo, hi);
                int rightCount = countInRange(nums, right, lo, hi);

                return leftCount > rightCount ? left : right;
            }

            public int majorityElement(int[] nums) {
                return majorityElementRec(nums, 0, nums.length - 1);
            }
        }

        class HashMapSol {
            private Map<Integer, Integer> countNums(int[] nums) {
                Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
                for (int num : nums) {
                    if (!counts.containsKey(num)) {
                        counts.put(num, 1);
                    } else {
                        counts.put(num, counts.get(num) + 1);
                    }
                }
                return counts;
            }

            public int majorityElement(int[] nums) {
                Map<Integer, Integer> counts = countNums(nums);

                Map.Entry<Integer, Integer> majorityEntry = null;
                for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                    if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                        majorityEntry = entry;
                    }
                }

                return majorityEntry.getKey();
            }
        }
    }

    // https://leetcode.com/problems/longest-common-prefix/
    class LongestCommonPrefix {
        // checkout Tries

        class HorizontalScanning {
            public String longestCommonPrefix(String[] strs) {
                if (strs.length == 0) return "";
                String prefix = strs[0];
                for (int i = 1; i < strs.length; i++)
                    while (strs[i].indexOf(prefix) != 0) {
                        prefix = prefix.substring(0, prefix.length() - 1);
                        if (prefix.isEmpty()) return "";
                    }
                return prefix;
            }
        }

        class BinarySearch {
            public String longestCommonPrefix(String[] strs) {
                if (strs == null || strs.length == 0)
                    return "";
                int minLen = Integer.MAX_VALUE;
                for (String str : strs)
                    minLen = Math.min(minLen, str.length());
                int low = 1;
                int high = minLen;
                while (low <= high) {
                    int middle = (low + high) / 2;
                    if (isCommonPrefix(strs, middle))
                        low = middle + 1;
                    else
                        high = middle - 1;
                }
                return strs[0].substring(0, (low + high) / 2);
            }

            private boolean isCommonPrefix(String[] strs, int len) {
                String str1 = strs[0].substring(0, len);
                for (int i = 1; i < strs.length; i++)
                    if (!strs[i].startsWith(str1))
                        return false;
                return true;
            }
        }
    }

    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    class LongSubStrNoRepChar {
        // Sliding Window Optimized
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>(); // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j + 1);
            }
            return ans;
        }
    }

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    class BuySellStock {
        public int maxProfit(int prices[]) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice)
                    minprice = prices[i];
                else if (prices[i] - minprice > maxprofit)
                    maxprofit = prices[i] - minprice;
            }
            return maxprofit;
        }
    }


    /**
     * Final Reference: Tries:
     * https://leetcode.com/problems/longest-common-prefix/editorial/ - Follow up
     * https://leetcode.com/problems/implement-trie-prefix-tree/solutions/3180933/solution/
     * **/

}
