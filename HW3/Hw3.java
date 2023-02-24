package Task11;

import java.util.ArrayList;

public class Hw3 {
    public static void main(String[] args) {
        int[][] field = drawField();
        findPath(field);
        showPath(0, 8, field);
        printArray(field);
    }

    static void findPath(int[][] field) {
        ArrayList<Integer> storage = new ArrayList<>();
        storage.add(5);
        storage.add(0);

        while (storage.size() > 0) {
            int x = storage.get(0);
            int y = storage.get(1);
            storage.remove(0);
            storage.remove(0);

            if (x < 9 && field[x+1][y] == 0) {
                storage.add(x+1); storage.add(y);
                field[x+1][y] = field[x][y] + 1;
            }
            if (y < 8 && field[x][y+1] == 0) {
                storage.add(x); storage.add(y+1);
                field[x][y+1] = field[x][y] + 1;
            }
            if (x > 0 && field[x-1][y] == 0) {
                storage.add(x-1); storage.add(y);
                field[x-1][y] = field[x][y] + 1;
            }
            if (y > 0 && field[x][y-1] == 0) {
                storage.add(x); storage.add(y-1);
                field[x][y-1] = field[x][y] + 1;
            }
        }
        field[5][0] = 0;
    }

    static void showPath(int endX, int endY, int[][] field) {
        int x = endX;
        int y = endY;
        int count = 0;
        ArrayList<Integer> storage = new ArrayList<>();
        while (storage.size()/2 < field[endX][endY]) {
            if (x < 9 && field[x+1][y] == field[x][y]-1) {
                storage.add(x+1); storage.add(y);
                x = x + 1;
            }
            else if (y < 8 && field[x][y+1] == field[x][y]-1) {
                storage.add(x); storage.add(y+1);
                y = y + 1;
            }
            else if (x > 0 && field[x-1][y] == field[x][y]-1) {
                storage.add(x-1); storage.add(y);
                x = x - 1;
            }
            else if (y > 0 && field[x][y-1] == field[x][y]-1) {
                storage.add(x); storage.add(y-1);
                y = y - 1;
            }
        }
        for (int i = 0; i < storage.size()-1; i=i+2) {
            field[storage.get(i)][storage.get(i+1)] = -5;
        }
    }

    static int[][] drawField() {
        return new int[][]
                {
                        {0, 0,  0,  0,  0,  0,  0, -1, 0},
                        {0, 0,  0, -1,  0,  0,  0,  0, 0},
                        {0, 0, -1, -1, -1, -1, -1,  0, 0},
                        {0, 0,  0, -1,  0, -1,  0,  0, 0},
                        {0, 0,  0, -1,  0, -1,  0,  0, 0},
                        {0, 0,  0, -1,  0, -1,  0,  0, 0},
                        {0, 0,  0,  0,  0, -1, -1,  0, 0},
                        {0, 0, -1, -1,  0, -1,  0,  0, 0},
                        {0, 0,  0,  0,  0,  0, -1,  0, 0},
                        {0, 0,  0,  0,  0,  0,  0,  0, 0}
                };
    }

    static void printArray(int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (anInt == -1) System.out.print("*" + "\t");
                else if (anInt == -5) System.out.print("@" + "\t");
                else System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
