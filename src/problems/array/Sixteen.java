package problems.array;

/**
 * @author SYAM K
 * @problem : Array of unknown size. 0s followed by 1s find the first index of 1
 */

class Sixteen {
    static int[] arr = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};

    public static void main(String[] args) {
        findFirstIndexOfOne(arr);
    }

    static void findFirstIndexOfOne(int[] arr) {
        int pointer = 0;
        // potential array out of bounds exception, since endIndex is not known
        while (arr[pointer] == 0) {
            pointer += 5;
        }
        while (arr[pointer] == 1) {
            pointer--;
        }
        System.out.println("Index: " + (pointer + 1));
    }
}