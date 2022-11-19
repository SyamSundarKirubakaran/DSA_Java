package workout;

// https://leetcode.com/problems/count-and-say/description/

public class J {

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        String currentString = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder nextString = new StringBuilder();
            for (int j = 0, k = 0; j < currentString.length(); j = k) {
                while (k < currentString.length() &&
                        currentString.charAt(k) == currentString.charAt(j))
                    k++;
                nextString.append(k - j).append(currentString.charAt(j));
            }
            currentString = nextString.toString();
        }
        return currentString;
    }
}
