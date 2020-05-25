package problems.LinkedList;

import java.util.LinkedHashMap;

/**
 * @author SYAM K
 * @problem : Memory efficient DLL
 */
public class Fourteen {

    // You can't retrieve the object using HashCode. Therefore saving it in HashMap.
    // This will increase the space complexity anyway.
    // So what is the point of memory efficient DLL, you might ask, I say fu*k Java.
    // Code in C++.
    private static LinkedHashMap<Integer, MemNode> hashMap = new LinkedHashMap<>();

    public static void main(String[] args) {
        MemNode head = inflate();
        print(head, 3);
    }

    private static void print(MemNode head, int size) {
        int hashCode = 121;
        MemNode temp;

//        MemNode one = hashMap.get(121 ^ head.address);
//        MemNode two = hashMap.get(one.address ^ head.hashCode());
//        MemNode three = hashMap.get(two.address ^ one.hashCode());
//        System.out.print(one.value + " " + two.value + " " + three.value);

        System.out.print(head.value + " ");
        for (int i = 0; i < size; i++) {
            temp = hashMap.get(hashCode ^ head.address);
            System.out.print(temp.value + " ");
            hashCode = head.hashCode();
            head = temp;
        }

    }

    private static MemNode inflate() {
        // 121 -> random number used to represent `null`
        MemNode zero = new MemNode(0);
        MemNode one = new MemNode(1);
        MemNode two = new MemNode(2);
        MemNode three = new MemNode(3);

        hashMap.put(zero.hashCode(), zero);
        hashMap.put(one.hashCode(), one);
        hashMap.put(two.hashCode(), two);
        hashMap.put(three.hashCode(), three);

        zero.address = 121 ^ one.hashCode();
        one.address = zero.hashCode() ^ two.hashCode();
        two.address = one.hashCode() ^ three.hashCode();
        three.address = two.hashCode() ^ 121;

        return zero;
    }

    static class MemNode {
        int value;
        int address;

        MemNode(int value) {
            this.value = value;
            address = 0;
        }
    }

}
