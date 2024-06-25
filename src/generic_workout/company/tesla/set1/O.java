package generic_workout.company.tesla.set1;

import java.util.*;

// https://leetcode.com/problems/insert-delete-getrandom-o1/editorial/

public class O {

    static class RandomizedSet {
        Map<Integer, Integer> dict;
        List<Integer> list;
        Random rand = new Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {
            dict = new HashMap<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (dict.containsKey(val)) return false;

            dict.put(val, list.size());
            list.add(list.size(), val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (! dict.containsKey(val)) return false;

            // move the last element to the place idx of the element to delete
            int lastElement = list.get(list.size() - 1);
            int idx = dict.get(val);
            list.set(idx, lastElement);
            dict.put(lastElement, idx);
            // delete the last element
            list.remove(list.size() - 1);
            dict.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}
