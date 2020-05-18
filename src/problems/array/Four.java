package problems.array;

/**
 * @author SYAM K
 * @problem : Element that occurs more than n/2 times - Unsorted
 */

class Four {
    static int[] arr = new int[]{1, 1, 2, 3, 3, 3, 3};
    static int[] failsArr = new int[]{1, 2, 1, 3, 1, 4, 5};

    public static void main(String[] args) {
        int result = performMooresVoting(arr);
        if (checkResult(result, arr.length - 1))
            System.out.println("Majority Element: " + result);
        else
            System.out.println("Moore's Voting Algorithm failed");

        int resultant = performMooresVoting(failsArr);
        if (checkResult(resultant, failsArr.length - 1))
            System.out.println("Majority Element: " + resultant);
        else
            System.out.println("Moore's Voting Algorithm failed");
    }

    static int performMooresVoting(int[] arr) {
        int majorityIndex = 0, count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[majorityIndex]) {
                count += 1;
            } else {
                count -= 1;
            }
            if (count == 0) {
                majorityIndex = i;
                count = 1;
            }
        }
        return arr[majorityIndex];
    }

    static boolean checkResult(int result, int length) {
        int count = 0;
        for (int value : arr) {
            if (value == result) {
                count += 1;
            }
        }
        return count >= length / 2;
    }
}