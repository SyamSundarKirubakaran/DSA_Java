package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Egg Dropping Problem
 */
public class ThirtyThree {

    public static void main(String[] args) {
        

        dropEgg(2, 10);

        
    }

    private static void dropEgg(int k, int n) {
        int[][] eggFloor = new int[k + 1][n + 1];
        int res;

        for (int i = 1; i <= k; i++) {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            eggFloor[1][i] = i;
        }

        System.out.println("1 + max((a, b), (x, y)), here (a, b) means \"we have 'a' eggs and 'b' floors to work with\" same for (x, y); (a, b) -> breaks, (x, y) -> !break");
        System.out.println();

        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    res = 1 + Math.max(
                            eggFloor[i - 1][x - 1], // breaks
                            eggFloor[i][j - x]      // !breaks
                    );
                    System.out.println("For: (" + i + ", " + j + "), From Floor: " + x + " = 1 + max((" + (i - 1) + ", " + (x - 1) + "), (" + i + ", " + (j - x) + ")) = " + res);
                    if (res < eggFloor[i][j]) { // Assign only MIN
                        eggFloor[i][j] = res;
                    }
                }
                System.out.println();
            }
        }

        for (int i = 0; i <= k; i++) {
            System.out.println(Arrays.toString(eggFloor[i]));
        }
        System.out.println(eggFloor[k][n]);
    }

}
