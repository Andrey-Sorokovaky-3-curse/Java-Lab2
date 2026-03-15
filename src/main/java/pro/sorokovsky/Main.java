package pro.sorokovsky;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Клас, для запуску програми.
 *
 * @author Сороковський Андрій
 * @version 1.0
 */
public class Main {
    /**
     * Метод, для запуску програми.
     */
    static void main() {
        level1();
    }

    /**
     * Метод, демонстрація 1-го рівня.
     */
    private static void level1() {
        System.out.println("Рівень 1");
        final var oneArray = new OneArray(enterCount("розмір одновимірного масиву"));
        oneArray.generate();
        oneArray.show("Вхідний масив");
        oneArray.sort();
        oneArray.show("Відсортований масив");
    }

    /**
     * Метод, для введеня числа > 0.
     *
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
                System.out.println(name + " має бути >= 0, спробуйте ще.");
            } catch (InputMismatchException _) {
                isCorrect = false;
                System.out.println("Не вірне значення, спробуйте ще.");
            }
        } while (!isCorrect);
        return count;
    }
}
