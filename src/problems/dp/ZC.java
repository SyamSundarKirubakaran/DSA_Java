package problems.dp;

import java.util.*;

/**
 * @author SYAM K
 * @problem : Count all distinct Palindromic sub string in a string
 */
public class ZC {

    public static void main(String[] args) {
        

        String str = "esass";
        int length = str.length();
        pss(str, str.toCharArray(), length);

        
    }

    private static void pss(String str, char[] strc, int length) {
        boolean[][] temp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            temp[i][i] = true;
        }
        int j;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int ls = 2; ls <= length; ls++) {
            for (int i = 0; i < length - ls + 1; i++) {
                j = i + ls - 1;
                if (strc[i] == strc[j]) {
                    if (i + 1 > j - 1) { // if it goes to lower triangular
                        temp[i][j] = true;
                    } else {
                        temp[i][j] = temp[i + 1][j - 1];
                    }
                    hashMap.put(i, j);
                } else {
                    temp[i][j] = false;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }
        Set<String> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            set.add(str.substring(entry.getKey(), entry.getValue() + 1));
        }
        for (String p : set) {
            System.out.println(p);
        }
    }

}
