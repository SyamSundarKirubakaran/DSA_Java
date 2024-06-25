package generic_workout;

// https://leetcode.com/problems/string-to-integer-atoi/

public class GOptimized {

    public static void main(String[] args) {
        System.out.println(myAtoi("  -457  -word"));
    }

    enum State {q0, q1, q2, qd}

    static class StateMachine {
        // Store current state value.
        private State currentState;
        // Store result formed and it's sign.
        private int result, sign;

        public StateMachine() {
            currentState = State.q0;
            result = 0;
            sign = 1;
        }

        // Transition to state q1.
        private void toStateQ1(char ch) {
            sign = (ch == '-') ? -1 : 1;
            currentState = State.q1;
        }

        // Transition to state q2.
        private void toStateQ2(int digit) {
            currentState = State.q2;
            appendDigit(digit);
        }

        // Transition to dead state qd.
        private void toStateQd() {
            currentState = State.qd;
        }

        // Append digit to result, if out of range return clamped value.
        private void appendDigit(int digit) {
            if ((result > Integer.MAX_VALUE / 10) ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                if (sign == 1) {
                    // If sign is 1, clamp result to Integer.MAX_VALUE.
                    result = Integer.MAX_VALUE;
                } else {
                    // If sign is -1, clamp result to Integer.MIN_VALUE.
                    result = Integer.MIN_VALUE;
                    sign = 1;
                }

                // When the 32-bit int range is exceeded, a dead state is reached.
                toStateQd();
            } else {
                // Append current digit to the result.
                result = result * 10 + digit;
            }
        }

        // Change state based on current input character.
        public void transition(char ch) {
            if (currentState == State.q0) {
                // Beginning state of the string (or some whitespaces are skipped).
                if (ch == ' ') {
                    // Current character is a whitespaces.
                    // We stay in same state.
                    return;
                } else if (ch == '-' || ch == '+') {
                    // Current character is a sign.
                    toStateQ1(ch);
                } else if (Character.isDigit(ch)) {
                    // Current character is a digit.
                    toStateQ2(ch - '0');
                } else {
                    // Current character is not a space/sign/digit.
                    // Reached a dead state.
                    toStateQd();
                }
            } else if (currentState == State.q1 || currentState == State.q2) {
                // Previous character was a sign or digit.
                if (Character.isDigit(ch)) {
                    // Current character is a digit.
                    toStateQ2(ch - '0');
                } else {
                    // Current character is not a digit.
                    // Reached a dead state.
                    toStateQd();
                }
            }
        }

        // Return the final result formed with it's sign.
        public int getInteger() {
            return sign * result;
        }

        // Get current state.
        public State getState() {
            return currentState;
        }
    }

    public static int myAtoi(String s) {
        StateMachine Q = new StateMachine();

        for (int i = 0; i < s.length() && Q.getState() != State.qd; ++i) {
            Q.transition(s.charAt(i));
        }

        return Q.getInteger();
    }

}
