package problems.strings;

/**
 * @author SYAM K
 * @problem : Check if given sequence of moves for robot is circular or not
 */
public class O {

    private static final String path = "GLGLGLG";

    public static void main(String[] args) {


        System.out.println(isCircular(path.toCharArray()));

        
    }

    static boolean isCircular(char[] path) {
        int x = 0, y = 0;
        int dir = 0;
        for (char move : path) {
            if (move == 'R')
                dir = (dir + 1) % 4;
            else if (move == 'L')
                dir = (dir + 3) % 4; // 3 / 4th rotation on right to reach left
            else {
                if (dir == 0)
                    y++; // up
                else if (dir == 1)
                    x++; // right
                else if (dir == 2)
                    y--; // down
                else if (dir == 3)
                    x--; // left
            }
        }
        return (x == 0 && y == 0);
    }

}
