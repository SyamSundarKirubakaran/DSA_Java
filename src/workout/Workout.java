package workout;

import java.util.ArrayList;

public class Workout {

    public static void main(String[] args) {
        System.out.println(convert("AB", 3));
    }

    public static String convert(String s, int numRows) {
        ArrayList<StringBuilder> sbArr = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            sbArr.add(new StringBuilder());
        }

        boolean isGoingDown = false;
        int position = 0;
        for(char c: s.toCharArray()){
            sbArr.get(position).append(c);
            if(position == numRows - 1 || position == 0) isGoingDown = !isGoingDown;
            if(isGoingDown){
                position += 1;
            } else {
                position -= 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(StringBuilder s1: sbArr){
            sb.append(s1.toString());
        }

        return sb.toString();
    }

}
