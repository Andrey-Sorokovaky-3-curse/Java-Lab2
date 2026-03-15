package pro.sorokovsky;

import java.util.random.RandomGenerator;

/**
 * Клас, який дозволяє працювати з двовимірними масивами.
 *
 * @author Сороковський Андрій
 * @version 1.0
 */
public class TwoArray {
    private final int count;
    private final int[][] array;

    /**
     * Створює новий двовимірний масив.
     *
     * @param count розмір двовимірного масиву.
     * @throws IllegalArgumentException якщо count < 0.
     */
    public TwoArray(int count) {
        if (count < 0) throw new IllegalArgumentException("Розмір масиву має бути позитивним числом");
        this.count = count;
        array = new int[count][count];
    }

    /**
     * Генерує двовимірний масив
     */
    public void generate() {
        var min = 1;
        var max = 999;
        final var generator = RandomGenerator.getDefault();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                array[i][j] = RandomGenerator.getDefault().nextInt((max - min) + 1) + min;
            }
        }
    }

    /**
     * Виводить двовимірний масив на екран.
     *
     * @param name - Ім'я масиву.
     */
    public void show(String name) {
        System.out.printf("Масив '%s': %n", name);
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                System.out.printf("%3d ", array[i][j]);
            }
            System.out.println();
        }
    }
}
