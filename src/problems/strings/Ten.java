package problems.strings;

/**
 * @author SYAM K
 * @problem : Excel column name for a given excel column number (MS Excel)
 */
public class Ten {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        printString(26);
        printString(51);
        printString(52);
        printString(80);
        printString(676);
        printString(702);
        printString(705);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static void printString(int columnNumber) {
        StringBuilder columnName = new StringBuilder();
        while (columnNumber > 0) {
            int rem = columnNumber % 26;
            if (rem == 0) {
                columnName.append("Z");
                columnNumber = (columnNumber / 26) - 1; // why `-1` adjustment since it starts from `0` but it should actually start from `1`
            } else {
                columnName.append((char) ((rem - 1) + 'A')); // why `-1` adjustment since it starts from `0` but it should actually start from `1`
                columnNumber = columnNumber / 26;
            }
        }
        System.out.println(columnName.reverse());
    }

}
