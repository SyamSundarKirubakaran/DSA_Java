package problems.strings;

/**
 * @author SYAM K
 * @problem : Remove adj duplicate characters in a given string
 */
public class Nineteen {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        String str1 = "geeksforgeeg";
        System.out.println(str1 + ": " + remove(str1));

        String str2 = "azxxxzy";
        System.out.println(str2 + ": " + remove(str2));

        String str3 = "caaabbbaac";
        System.out.println(str3 + ": " + remove(str3));

        String str4 = "gghhg";
        System.out.println(str4 + ": " + remove(str4));

        String str5 = "aaaacddddcappp";
        System.out.println(str5 + ": " + remove(str5));

        String str6 = "aaaaaaaaaa";
        System.out.println(str6 + ": " + remove(str6));

        String str7 = "qpaaaaadaaaaadprq";
        System.out.println(str7 + ": " + remove(str7));

        String str8 = "acaaabbbacdddd";
        System.out.println(str8 + ": " + remove(str8));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    static String removeUtil(String str, char lastRemoved) {
        if (str.length() == 0 || str.length() == 1)
            return str;

        if (str.charAt(0) == str.charAt(1)) {
            lastRemoved = str.charAt(0);
            while (str.length() > 1 && str.charAt(0) == str.charAt(1))
                str = str.substring(1);
            str = str.substring(1);
            return removeUtil(str, lastRemoved);
        }

        String remStr = removeUtil(str.substring(1), lastRemoved);

        if (remStr.length() != 0 && remStr.charAt(0) == str.charAt(0)) {
            lastRemoved = str.charAt(0);
            return remStr.substring(1);
        }


        if (remStr.length() == 0 && lastRemoved == str.charAt(0))
            return remStr;

        return (str.charAt(0) + remStr);
    }

    static String remove(String str) {
        char lastRemoved = '\0';
        return removeUtil(str, lastRemoved);
    }


}
