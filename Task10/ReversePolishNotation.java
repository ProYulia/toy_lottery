package InfixPostfix;
public class ReversePolishNotation {
    public static void main(String[] args) {
        Infix exp1 = new Infix();
        exp1.setInfix("3+4*2/(1-5)*2");
        System.out.println(exp1.getPostfix());

        Infix exp2 = new Infix();
        exp2.setInfix("38+4*2/(10-5)*2");
        System.out.println(exp2.getPostfix());

    }
}
// добавить работу с пробелами
// добавить степень