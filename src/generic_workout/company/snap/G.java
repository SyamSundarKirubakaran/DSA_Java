package generic_workout.company.snap;

// https://leetcode.com/problems/score-of-parentheses/editorial/

public class G {


    public int scoreOfParentheses(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i - 1) == '(')
                    ans += 1 << bal;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new G().scoreOfParentheses("(()(()))"));
    }

}
