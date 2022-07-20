package problems.mathematical;

/**
 * @author SYAM K
 * @problem : Prime or not
 */
public class One {

    public static void main(String[] args) {
        

        check(13);

        
    }

    private static void check(int n) {
        int flag = 0;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Prime");
        } else {
            System.out.println("!Prime");
        }

    }

}
