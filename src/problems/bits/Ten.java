package problems.bits;

/**
 * @author SYAM K
 * @problem : Check if a Number is Odd or Even using Bitwise Operators
 */
public class Ten {

    public static void main(String[] args) {


        System.out.println(check(4) ? "Even" : "Odd");


    }

    private static boolean check(int n) {
        return ((n & 1) == 0); // Bit representation of a even number always ends with `0`, odd number always with `1`
    }

}
