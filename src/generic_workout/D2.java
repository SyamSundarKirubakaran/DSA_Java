package generic_workout;

// https://leetcode.com/problems/reverse-integer/

public class D2 {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        if (x < 10 && x > -10) return x;

        boolean isNegative = x < 0;
        x = Math.abs(x);
        int result = 0;

        char[] charArr = String.valueOf(x).toCharArray();
        int start = 0, end = charArr.length - 1;
        char temp;
        while (start < end) {
            temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            start += 1;
            end -= 1;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : charArr) {
            sb.append(c);
        }
        try {
            result = Integer.parseInt(sb.toString());
        } catch (Exception ignored) {
        }

        return isNegative && result != 0 ? -result : result;
    }

}
