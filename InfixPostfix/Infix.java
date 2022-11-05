package InfixPostfix;

import java.util.Stack;

public class Infix {
    private String infix;

    public String getInfix() {
        return infix;
    }
    public void setInfix(String infix) {
        this.infix = infix;
    }

    public String getPostfix() {
        convertToPostfix();
        return postfix;
    }

    public void setPostfix(String postfix) {
        this.postfix = postfix;
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
                while (Character.isDigit(n)) {
                    num = 0;
                    num = num * 10 + num;
                    i++;
                    n = infix.charAt(i);
                }
                i--;
                postfix += num;
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
