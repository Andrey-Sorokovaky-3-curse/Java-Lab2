package pro.sorokovsky;

import java.util.Arrays;
import java.util.random.RandomGenerator;

/**
 * Клас, який дозволяє працювати з одновимірними масивами.
 *
 * @author Сороковський Андрій
 * @version 1.0
 */
public class OneArray {
    private final int[] array;
    private final int count;

    /**
     * Створює новий одновимірний масив
     *
     * @param count кількість елементів, має бути понад 0.
     */
    public OneArray(int count) {
        array = new int[count];
        this.count = count;
    }

    /**
     * Генерує масив.
     */
    public void generate() {
        for (int i = 0; i < count; i++) {
            array[i] = RandomGenerator.getDefault().nextInt();
        }
    }

    /**
     * Виводить масив на екран
     *
     * @param title заголовок для масиву.
     */
    public void show(String title) {
        System.out.printf("Масив '%s': ", title);
        for (int i = 0; i < count; i++) {
            System.out.printf(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Сортує масив.
     */
    public void sort() {
        Arrays.sort(array);
    }
}
