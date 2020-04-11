package problems;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author SYAM K
 * @problem : Evaluate the given Postfix - using operand stack
 */
public class Prob4 {

    private static List<String> operatorStack = Arrays.asList("*", "+", "-", "/");

    public static void main(String[] args) {
        Stack<String> operandStack = new Stack<>();
        evaluateExpression(operandStack, "321*+");
    }

    private static void evaluateExpression(Stack<String> stack, String expression) {
        int value1 = 0, value2 = 0;
        for (int i = 0; i < expression.length(); i++) {
            String charValue = expression.charAt(i) + "";
            if (!operatorStack.contains(charValue))
                stack.push(charValue);
            else if (operatorStack.contains(charValue)) {
                if (!stack.isEmpty())
                    value1 = Integer.parseInt(stack.pop());
                else {
                    System.out.println("Evaluation Error");
                    break;
                }
                if (!stack.isEmpty())
                    value2 = Integer.parseInt(stack.pop());
                else {
                    System.out.println("Evaluation Error");
                    break;
                }
                switch (findOperatorType(charValue)) {
                    case ADD:
                        stack.push((value1 + value2) + "");
                        break;
                    case MULTIPLY:
                        stack.push((value1 * value2) + "");
                        break;
                    case SUBTRACT:
                        stack.push((value1 - value2) + "");
                        break;
                    case DIVIDE:
                        stack.push((value1 / value2) + "");
                        break;
                }
            }
        }
        System.out.println(stack.peek());
    }

    private static OperatorType findOperatorType(String charValue) {
        OperatorType operatorType;
        switch (charValue) {
            case "*":
                operatorType = OperatorType.MULTIPLY;
                break;
            case "+":
                operatorType = OperatorType.ADD;
                break;
            case "-":
                operatorType = OperatorType.SUBTRACT;
                break;
            case "/":
                operatorType = OperatorType.DIVIDE;
                break;
            default:
                operatorType = OperatorType.ADD;
        }
        return operatorType;
    }

    enum OperatorType {
        MULTIPLY,
        ADD,
        SUBTRACT,
        DIVIDE
    }
}
