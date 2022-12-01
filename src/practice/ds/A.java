package practice.ds;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate/

class A {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> conSet = new HashSet<>();
        boolean result = false;
        for(int x: nums){
            if(conSet.contains(x)) {
                result = true;
                break;
            }
            conSet.add(x);
        }
        return result;
    }
}