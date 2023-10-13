package problems.company.tesla.set1;

// https://leetcode.com/problems/maximum-number-of-balloons/editorial/

public class C {

    public int maxNumberOfBalloons(String text) {
        int bCount = 0, aCount = 0, lCount = 0, oCount = 0, nCount = 0;

        // Count the frequencey of all the five characters
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'b') {
                bCount++;
            } else if (text.charAt(i) == 'a') {
                aCount++;
            } else if (text.charAt(i) == 'l') {
                lCount++;
            } else if (text.charAt(i) == 'o') {
                oCount++;
            } else if (text.charAt(i) == 'n') {
                nCount++;
            }
        }

        // Find the potential of each character.
        // Except for 'l' and 'o' the potential is equal to the frequency.
        lCount = lCount / 2;
        oCount = oCount / 2;

        // Find the bottleneck.
        return Math.min(bCount, Math.min(aCount, Math.min(lCount, Math.min(oCount, nCount))));
    }

    public static void main(String[] args) {
        System.out.println(new C().maxNumberOfBalloons("nlaebolko"));
    }
}

class Solution {
    private int findMaxNumberofPattern(String text, String pattern) {
        int n = text.length(), m = pattern.length(), answer = Integer.MAX_VALUE;
        int freqInText[] = new int[26];
        int freqInPattern[] = new int[26];

        // Frequency of characters in text.
        for (int i = 0; i < n; i++) {
            freqInText[text.charAt(i) - 'a']++;
        }
        // Frequency of characters in pattern.
        for (int i = 0; i < m; i++) {
            freqInPattern[pattern.charAt(i) - 'a']++;
        }

        // Compare the maximum string that can be produced
        // considering one character at a time.
        for (int i = 0; i < 26; i++) {
            // Do not divide by zero.
            if (freqInPattern[i] > 0) {
                answer = Math.min(answer, freqInText[i] / freqInPattern[i]);
            }
        }

        return answer;
    }

    public int maxNumberOfBalloons(String text) {
        // Any string made up of lowercase English letters.
        String pattern = "balloon";
        return findMaxNumberofPattern(text, pattern);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxNumberOfBalloons("nlaebolko"));
    }
}
