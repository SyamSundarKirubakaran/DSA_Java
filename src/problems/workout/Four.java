package problems.workout;

import java.util.Stack;

public class Four {

    public static void main(String[] args) {
        String s = "abbaca";

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

        System.out.println(sb.toString());
    }

}
