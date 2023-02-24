package interimTest;

import java.util.ArrayList;
import java.util.Random;


public class Lottery {
    ArrayList<Toy> toys;
    static final String toyWarehouse = "toyWH.bin";
    static final String toyWinList = "toyWinLst.bin";

    public Lottery(int toysAmount) {
        try {
            System.out.println("Поиск сохраненной базы данных...");
            this.toys = FileManagement.readFromFile(toyWarehouse);
            this.toys.addAll(createToyList(toysAmount));
            System.out.println("Добавление новых данных в базу...");
        } catch (Exception e) {
            System.out.println("Создание новой базы данных...");
            this.toys = createToyList(toysAmount);
        }
    }

    public void start() {
        Toy prize = chooseToy(toys);
        System.out.println("Выпал приз " + prize);
        givePrize(prize);
    }

    public void stop() {
        FileManagement.saveToFile(toyWarehouse, toys);
        System.out.println("База даных сохранена");
    }


    public Toy chooseToy(ArrayList<Toy> toys) {
        int listSize = toys.size();
        int randNum = new Random().nextInt(listSize);
        Toy prize = toys.get(randNum);
        toys.remove(randNum);
        return prize;
    }

    public void givePrize(Toy prize){
        try {
            ArrayList<Toy> prizeList = FileManagement.readFromFile(toyWinList);
            prizeList.add(prize);
            FileManagement.saveToFile(toyWinList, prizeList);
            System.out.println("Данные о выйгрыше успешно записаны в файл");
        } catch (Exception e) {
            FileManagement.saveToFile(toyWinList, prize);
            System.out.println("Создан новый файл. Данные успешно добавлены");
        }

    }

    public static ArrayList<Toy> createToyList(int amount) {
        ArrayList<Toy> toys  = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Toy toy = new Toy("toy" + i);
            toys.add(toy);
        }
        FileManagement.saveToFile(toyWarehouse, toys);
        return toys;
    }


}
