import java.util.Scanner;

//Написать программу вычисления n-ого треугольного числа.
public class triangular {
    public static void main(String[] args) {
        System.out.println(triangular_num(ask_user()));
    }
    
    public static double triangular_num(int num) {
        return 0.5 * num * (num + 1);
    }

    public static int ask_user() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println ("Введите число: ");
        int num = iScanner.nextInt();
        iScanner.close();
        return num;
    }

}
