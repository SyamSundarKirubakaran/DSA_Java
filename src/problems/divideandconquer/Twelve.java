package problems.divideandconquer;

/**
 * @author SYAM K
 * @problem : External Sorting
 */
public class Twelve {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        // External sorting algorithm takes place if RAM doesn't have enough capacity to hold all the elements
        // that are about to be sorted, therefore, offloading to HDD is done and loading is done when required
        // batch wise sorting is done

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

}
