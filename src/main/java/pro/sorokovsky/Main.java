package pro.sorokovsky;

import pro.sorokovsky.console.commands.Context;
import pro.sorokovsky.console.commands.ExitCommand;
import pro.sorokovsky.lab2.level1.OneArray;
import pro.sorokovsky.lab2.level2.TwoArray;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Клас, для запуску програми.
 * @author Сороковський Андрій
 * @version 1.0
 */
public class Main {
    /**
     * Метод, для запуску програми.
     */
    static void main() {
        final var context = new Context("Рівень 1");
        context
                .addCommand(new ExitCommand())
                .start();
        //level1();
        //level2();
    }

    /**
     * Метод, демонстрація 1-го рівня.
     */
    private static void level1() {
        System.out.println("Рівень 1");
        final var array = new OneArray(enterCount("розмір одновимірного масиву"));
        array.generate();
        array.show("Вхідний масив");
        array.sort();
        array.show("Відсортований масив");
    }

    /**
     * Метод, демонстрація 2-го рівня.
     */
    private static void level2() {
        System.out.println("Рівень 2");
        final var array = new TwoArray(enterCount("розмір двовимірного масиву"));
        array.generate();
        array.show("Згенерований вхідний масив");
        array.parseFromFile(enterString("шлях до файлу із двовимірним масивом"));
        array.show("Вхідний масив із файлу");
        array.saveToFile(enterString("шлях до файлу"));
    }

    /**
     * Метод, для введеня числа >= 0.
     * @param name ім'я змінної.
     * @return результат введення.
     */
    private static int enterCount(String name) {
        int count = 0;
        boolean isCorrect;
        do {
            isCorrect = false;
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.printf("Введіть %s: ", name);
                count = scanner.nextInt();
                if (count >= 0) isCorrect = true;
                else System.out.println(name + " має бути >= 0, спробуйте ще.");
            } catch (InputMismatchException _) {
                System.out.println("Не вірне значення, спробуйте ще.");
            }
        } while (!isCorrect);
        return count;
    }


    /**
     * Запитує у користувача рядок.
     *
     * @param name назва змінної для введення рядка.
     * @return введений рядок.
     */
    private static String enterString(String name) {
        System.out.printf("Введіть %s: ", name);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
