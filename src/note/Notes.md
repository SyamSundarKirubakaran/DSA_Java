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

- Learn how end index can Influence a Sub String result in java. Kinda tricky when dealing with inclusive and exclusive counting.