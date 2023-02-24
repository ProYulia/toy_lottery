package Task04;

import java.util.Scanner;

public class Hw2 {
    public static void main(String[] args) {
        int remain = getInfo();
        char k1 = 'A';
        char k2 = 'B';
        char k3 = 'C';
        TowerOfHanoi(k1, k3, k2, remain);
    }
    static void TowerOfHanoi(char a, char c, char b, int remain) {
        if (remain > 1) TowerOfHanoi(a, b, c, remain - 1);
        System.out.printf("Ход: Переместите диск с %c на %c \n", a, c);
        if (remain > 1) TowerOfHanoi(b, c, a, remain - 1);
    }

    static int getInfo() {
        System.out.println("Сколько дисков нужно переместить?");
        Scanner iScanner = new Scanner(System.in);
        int x = iScanner.nextInt();
        iScanner.close();
        return x;
    }
}
