**Notes - Java**
- Traversal in upper triangular matrix, very much prevalent in Dynamic Programming.
```
for (int ls = 2; ls <= len; ls++) {
    for (int i = 0; i < len - ls + 1; i++) {
        j = i + ls - 1;
        // Used for Upper triangular Matrix construction
        // diagonal major order
    }
}
Traversal:
for 7x7 => indexed (0..6)x(0..6)
value: (0,1)
value: (1,2)
value: (2,3)
value: (3,4)
value: (4,5)
value: (5,6)
value: (0,2)
value: (1,3)
value: (2,4)
value: (3,5)
value: (4,6)
value: (0,3)
value: (1,4)
value: (2,5)
value: (3,6)
value: (0,4)
value: (1,5)
value: (2,6)
value: (0,5)
value: (1,6)
value: (0,6)
```

- Check HashMap if !present -> init to `1` else sum of `1` and value in hashmap

```
hashMap.merge(ch, 1, Integer::sum);
```

- Heaps using Standard Library -> MIN Heap

```
PriorityQueue<Node> pq = new PriorityQueue<>((Node o1, Node o2) -> {
            if(o1.freq < o2.freq) return -1;
            if(o1.freq > o2.freq) return 1;
            return 0;
        });
```
- The above represents MIN Heap: which can also be written as,
```
PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt((Node o) -> o.freq));
```

- Heaps using Standard Library -> MAX Heap

```
PriorityQueue<Node> pq = new PriorityQueue<>((Node o1, Node o2) -> {
            if(o1.freq > o2.freq) return -1;
            if(o1.freq < o2.freq) return 1;
            return 0;
        });
```
- The above represents MAX Heap: which can also be written as,
```
PriorityQueue<Node> pq = new PriorityQueue<>((Node o1, Node o2) -> Integer.compare(o2.freq, o1.freq));
```

- Learn how end index can Influence a `String.substring()` result in java. Kinda tricky when dealing with inclusive and exclusive counting.
- Try to use Java streams when ever possible - makes the code look elegant, but there should be trade-offs with run time.
- `str.substring(1)` - if 2nd arg is not specified it takes till end of string.

--------------------------------------------------

- Converting a decimal to binary will take `O(nlogn)` complexity

- LL number into reverse int
```java
    private static int appendToInt(ListNode head) {
        // LL number into reverse int
        // eg: 2 -> 4 -> 3 => 342
        if (head != null && head.next == null)
            return head.val;
        int result = 0;
        int count = 0;
        while (head != null) {
            result = (head.val * (int) Math.pow(10, count)) + result;
            count += 1;
            head = head.next;
        }
        return result;
    }
```