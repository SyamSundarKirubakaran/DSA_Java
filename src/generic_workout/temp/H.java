package generic_workout.temp;

import java.util.Stack;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

class H {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            } else {
                if(stack.peek() == s.charAt(i)){
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}
