package problems.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author SYAM K
 * @problem : Rearrange the characters in the string such that same characters become d-distance away from each other.
 */
public class Four {

    public static void main(String[] args) {
        

        String str = "abcdada";

        rearrange(str.toCharArray(), str.length(), 3);

        
    }

    private static void rearrange(char[] str, int length, int d) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int noOfDistinctCharacters = 0;
        for (char ch : str) {
            if (hashMap.get(ch) == null)
                noOfDistinctCharacters += 1;
            hashMap.merge(ch, 1, Integer::sum);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((Node o1, Node o2) -> Integer.compare(o2.freq, o1.freq));
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            Node temp = new Node(entry.getKey(), entry.getValue());
            pq.add(temp);
        }
        System.out.println(pq.toString());
        char[] arr = new char[length];
        for (int i = 0; i < length; i++) {
            arr[i] = '!';
        }
        Node popped;
        int p;
        for (int i = 0; i < noOfDistinctCharacters; i++) {
            popped = pq.remove();
            p = i;
            while (arr[p] != '!')
                p += 1;
            for (int k = 0; k < popped.freq; k++) {
                if (p + d * k >= length) {
                    System.out.println("Can't merge");
                    return;
                }
                arr[p + d * k] = popped.ch;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static class Node {
        char ch;
        int freq;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "ch=" + ch +
                    ", freq=" + freq +
                    '}';
        }
    }

}
