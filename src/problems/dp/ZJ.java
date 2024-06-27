package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Count no.of ways to reach a score in a given game, player can score 2, 4 or 6 points
 */
public class ZJ {

    public static void main(String[] args) {
        

        count(10);

        
    }

    private static void count(int score) {
        int[] count = new int[score / 2 + 1];
        for (int i = 0; i <= score / 2; i++) {
            count[i] = 0;
        }
        count[0] = 1;
        count[1] = 1;
        count[2] = 2;
        for (int i = 3; i <= score / 2; i++) {
            count[i] = count[i - 1] + count[i - 2] + count[i - 3];
        }
        System.out.println(Arrays.toString(count));
        System.out.println(count[score / 2]);
    }

}
