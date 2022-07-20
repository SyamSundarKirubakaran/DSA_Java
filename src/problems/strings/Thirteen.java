package problems.strings;

import java.util.HashMap;

/**
 * @author SYAM K
 * @problem : All combinations of strings used to dail a number (Old Phone Key pad)
 */
public class Thirteen {

    public static void main(String[] args) {


        printStringForNumber("23");
        System.out.println();


    }

    static void printStrings(String phNo, int i,
                             HashMap<Character, String> hm,
                             StringBuilder str) {

        if (i == phNo.length()) {
            System.out.print(str + " ");
            return;
        }

        String s = hm.get(phNo.charAt(i));
        for (int j = 0; j < s.length(); j++) {
            str.append(s.charAt(j));
            printStrings(phNo, i + 1, hm, str);
            str.deleteCharAt(str.length() - 1);
        }
    }

    static void printStringForNumber(String phNo) {
        HashMap<Character, String> hm =
                new HashMap<>();

        hm.put('2', "ABC");
        hm.put('3', "DEF");
        hm.put('4', "GHI");
        hm.put('5', "JKL");
        hm.put('6', "MNO");
        hm.put('7', "PQRS");
        hm.put('8', "TUV");
        hm.put('9', "WXYZ");
        hm.put('1', "1");
        hm.put('0', "0");

        StringBuilder str = new StringBuilder();

        printStrings(phNo, 0, hm, str);
    }

}
