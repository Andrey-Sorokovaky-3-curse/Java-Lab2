package pro.sorokovsky.lab2.level2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.random.RandomGenerator;

/**
 * Клас, який дозволяє працювати з двовимірними масивами.
 *
 * @author Сороковський Андрій
 * @version 1.0
 */
public class TwoArray {
    private int count;
    private final RandomGenerator generator = RandomGenerator.getDefault();
    private int[][] array;

    /**
     * Створює новий двовимірний масив.
     *
     * @param count розмір двовимірного масиву.
     * @throws IllegalArgumentException якщо count менше ніж 0.
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
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                array[i][j] = generator.nextInt((max - min) + 1) + min;
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

    /**
     * Читає двовимірний масив із текстового файлу.
     *
     * @param filePath шлях до файлу із двовимірним масивом.
     */
    public void parseFromFile(String filePath) {
        int[][] backup = array;
        try {
            final var file = Paths.get(filePath);
            if (Files.notExists(file)) {
                System.out.println("Файл не знайдено.");
            } else {
                List<String> lines = Files.readAllLines(file);
                count = lines.toArray().length;
                array = new int[count][count];
                for (int i = 0; i < count; i++) {
                    final var line = Arrays.stream(lines.get(i).trim().split(" "))
                            .filter(string -> !string.isEmpty())
                            .map(Integer::parseInt)
                            .toList();
                    for (int j = 0; j < count; j++) {
                        array[i][j] = line.get(j);
                    }
                }
                System.out.printf("Двовимірний масив успішно прочитано із файлу: %s%n", filePath);
            }
        } catch (IOException | NumberFormatException | InvalidPathException _) {
            System.out.println("Сталася помилка читання файлу.");
            array = backup;
            count = backup.length;
        }
    }

    /**
     * Записує двовимірний масив у файл.
     *
     * @param filePath шлях до файлу у який треба записати двовимірний масив.
     */
    public void saveToFile(String filePath) {
        try {
            final var file = Paths.get(filePath);
        } catch (InvalidPathException _) {
            System.out.println("Сталася помилка читання файлу.");
        }
    }

    /**
     * Сортує двовимірний масив, кожен рядок окремо.
     */
    public void sort() {
        for (int i = 0; i < count; i++) {
            Arrays.sort(array[i]);
        }
    }
}
