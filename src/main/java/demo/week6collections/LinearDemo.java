package demo.week6collections;

import java.util.Stack;

/*
Demoed:
1. Stack is Last-in-first-out (or first-in-last-out, i.e order is opposite)
since insertion/deletion on the same end (top)
2. Use stack to evaluate postfix expression
 */
public class LinearDemo {
    public static void main(String[] args) {
        // For a stack, removing order is the opposite
        // of the insertion order.
        Stack<Integer> stack = new Stack<>();
        System.out.println("insertion order: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            stack.push(i);
        }
        System.out.println("\nremoving order: ");
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    /**
     * Calculate the result of the postfix.
     * <br>Assuming the postfix is for 1-digit number only.
     * <br>And the operators can be +, -, * or /.
     *
     * <p>Infix vs. postfix:
     * <ul>
     *     <li>infix: operator is "in"between operands
     *     so it's more human-readable
     *     <br>e.g. 2 * (3 + 5)</li>
     *     <li>postfix: operator is "post" (after) operands
     *     so it's more compiler-readable
     *     <br>e.g. e.g. 235+*</li>
     * </ul>
     * @param postfix the expression being calculated (assume it's always valid).
     * @return result of calculation
     */
    static int evaluatePostfix(String postfix){
        // a stack used to keep track of the operands
        Stack<Integer> operands = new Stack<>();
        // go over the postfix
        for (char c: postfix.toCharArray()){
            // see operands, push to stack
            if (Character.isDigit(c))
                operands.push(c - '0'); // convert char to int
            // if see operator
            else{
               // pop 2 operands from stack
                int op2 = operands.pop();
                int op1 = operands.pop();
                // calculate the result, push result back to stack
                int result = calculate(c, op1, op2);
                operands.push(result);
            }
        }
        return operands.peek();
    }

    /**
     * Helper method to calculate op1 op op2.
     * @param op operation (+, -, *, or /)
     * @param op1 first operand
     * @param op2 second operand
     * @return result of op1 op op2
     */
    static int calculate(char op, int op1, int op2){
        return switch (op){
            case '+' -> op1 + op2;
            case '-' -> op1 - op2;
            case '*' -> op1 * op2;
            case '/' -> op1 / op2;
            default -> throw new IllegalArgumentException("not supported");
        };
    }
}
