package InfixPostfix;

import java.sql.SQLOutput;

public class ReversePolishNotation {
    public static void main(String[] args) {
        Infix exp1 = new Infix();
        exp1.setInfix("3+4*2/(1-5)*2");

        System.out.println(exp1.getPostfix());

    }
}
