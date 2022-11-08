package Brackets;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Task12 {
    public static void main(String[] args) {
        ArrayList<String> exp = new ArrayList<>();
        exp.add("a+(d*3)");
        exp.add("[a+(1*3)");
        exp.add("[6+(3*3)]");
        exp.add("{a}[+]{(d*3)}");
        exp.add("<{a}+{(d*3)}>");
        exp.add("{a+]}{(d*3)}");

        for (String item : exp)
            System.out.println(checkBrackets(item));
    }
    static boolean checkBrackets(String str) {
        HashMap<Character, Character> dict = new HashMap<>();
        dict.put('(', ')');
        dict.put('{', '}');
        dict.put('[', ']');
        dict.put('<', '>' );
        Stack<Character> stack = new Stack<>();

        char cur;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' ||
                    str.charAt(i) == '[' || str.charAt(i) == '<') {
                stack.push(str.charAt(i));
            }
            else if (str.charAt(i) == ')' || str.charAt(i) == '}' ||
                    str.charAt(i) == ']' || str.charAt(i) == '>') {
                if (!stack.isEmpty() && str.charAt(i) != dict.get(stack.peek()))
                    return false;
                if (!stack.isEmpty())
                    stack.pop();
            }
        }
        if (stack.isEmpty())
         return true;
        return false;
    }
}
