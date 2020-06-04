package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Kth Ugly Number
 */
public class Five {

    public static void main(String[] args) {
        findUglyNumber(15);
    }

    private static void findUglyNumber(int k) {
        int[] finalResult = new int[k];
        int two = 2;
        int twoPtr = 1;
        int three = 3;
        int threePtr = 1;
        int five = 5;
        int fivePtr = 1;
        int twoResult, threeResult, fiveResult, pickedResult;
        finalResult[0] = 1;
        int finalResultPtr = 1;
        for (int i = 1; i < k; i++) {
            twoResult = two * twoPtr;
            threeResult = three * threePtr;
            fiveResult = five * fivePtr;
            pickedResult = Math.min(twoResult, Math.min(threeResult, fiveResult));
            if (pickedResult == twoResult) {
                twoPtr += 1;
            } else if (pickedResult == threeResult) {
                threePtr += 1;
            } else {
                fivePtr += 1;
            }
            if (finalResult[finalResultPtr - 1] != pickedResult) {
                finalResult[finalResultPtr] = pickedResult;
                finalResultPtr += 1;
            }
        }
        System.out.println(Arrays.toString(finalResult));
    }

}
