package InfixPostfix;

import java.util.Stack;

public class Infix {
    private String infix;
    private String postfix = "";

    public String getInfix() {
        return infix;
    }
    public void setInfix(String infix) {
        this.infix = infix;
        convertToPostfix();
    }

    public String getPostfix() {
        return postfix;
    }

    @Override
    public String toString() {
        return "infix expression: " + infix;
    }

    private void convertToPostfix() {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char n = infix.charAt(i);
            if (Character.isDigit(n)) {
                int num = 0;
                if (i != infix.length()-1) {
                    while (Character.isDigit(n)) {
                        num = num * 10 + Character.digit(n, 10);
                        i++;
                        n = infix.charAt(i);
                    }
                    i--;
                    postfix += num;
                }
                else
                    postfix += n;
            }

            else if (n == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.peek();
                    stack.pop();
                }
                stack.pop();
                }
            else
                stack.push(n);
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                stack.pop();
            postfix += stack.peek();
            stack.pop();
        }
    }
}
