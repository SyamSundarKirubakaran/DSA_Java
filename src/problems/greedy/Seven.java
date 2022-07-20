package problems.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author SYAM K
 * @problem : Huffman's Coding
 */
public class Seven {

    public static void main(String[] args) {


        perform();


    }

    private static void perform() {
        Scanner s = new Scanner(System.in);

        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charFreq = {5, 9, 12, 13, 16, 45};

        PriorityQueue<HuffmanNode> q
                = new PriorityQueue<>(n, (o1, o2) -> 0);

        for (int i = 0; i < n; i++) {

            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.data = charFreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size() > 1) {

            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode f = new HuffmanNode();

            f.data = x.data + y.data;
            f.c = '-';
            f.left = x;
            f.right = y;

            root = f;

            q.add(f);
        }

        printCode(root, "");
    }

    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }

        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    static class HuffmanNode {
        int data;
        char c;
        HuffmanNode left;
        HuffmanNode right;
    }


}
