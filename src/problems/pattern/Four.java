package problems.pattern;

/**
 * @author SYAM K
 * @problem : Rabin-Karp String Matching Algorithm
 */
public class Four {

    public final static int d = 256;

    public static void main(String[] args) {
        Long start = System.nanoTime();

        String txt = "SYAM SUNDAR K";
        String pat = "SUNDAR";
        int q = 101;
        search(pat, txt, q);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    static void search(String pat, String txt, int q) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;

        for (i = 0; i < M - 1; i++)
            h = (h * d) % q; // hash function

        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        for (i = 0; i <= N - M; i++) {

            if (p == t) { // if hash values match
                for (j = 0; j < M; j++) { // ensure they are the same by char comparison
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }

                if (j == M)
                    System.out.println("Pattern found at index " + i);
            }

            if (i < N - M) {
                // (txt.charAt(i) * h) -> removes 1st letter & (i + M) -> adds last letter and the hash is recalculated efficiently
                t = (d * (t - (txt.charAt(i) * h)) + txt.charAt(i + M)) % q;

                if (t < 0)
                    t = (t + q);
            }
        }
    }
}
