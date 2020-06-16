package problems.backtracking;

/**
 * @author SYAM K
 * @problem : Print all permutations of given string
 */
public class One {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        String str = "ABC";
        int n = str.length();
        permute(str, 0, n - 1);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static void permute(String str, int l, int r) {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                System.out.println("Before: " + str + ", " + l + ", " + i);
                permute(str, l + 1, r);
                str = swap(str, l, i); // to get back up the tree, to form original string
                System.out.println("After: " + str + ", " + l + ", " + i + " (reversing)");
            }
        }
    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
