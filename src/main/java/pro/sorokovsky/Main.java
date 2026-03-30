package pro.sorokovsky;

import pro.sorokovsky.console.commands.Context;
import pro.sorokovsky.console.commands.ExitCommand;
import pro.sorokovsky.lab2.level1.CreateOneCommand;
import pro.sorokovsky.lab2.level1.GenerateOneCommand;
import pro.sorokovsky.lab2.level1.ShowOneCommand;
import pro.sorokovsky.lab2.level1.SortOneCommand;
import pro.sorokovsky.lab2.level2.*;

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
        final var context = new Context("Головне меню");
        context
                .addCommand(new ExitCommand())
                .addCommand(setupLevel1())
                .addCommand(setupLevel2())
                .addCommand(setupLevel3())
                .start();
    }

    /**
     * Метод, демонстрація 1-го рівня.
     * @return Контекст виконання 1-го рівня.
     */
    private static Context setupLevel1() {
        return new Context("Рівень 1")
                .addCommand(new ExitCommand())
                .addCommand(new CreateOneCommand())
                .addCommand(new GenerateOneCommand())
                .addCommand(new ShowOneCommand())
                .addCommand(new SortOneCommand());
    }

    /**
     * Метод, демонстрація 2-го рівня.
     * @return Контекст виконання 2-го рівня.
     */
    private static Context setupLevel2() {
        return new Context("Рівень 2")
                .addCommand(new ExitCommand())
                .addCommand(new CreateTwoCommand())
                .addCommand(new GenerateTwoCommand())
                .addCommand(new ShowTwoCommand())
                .addCommand(new SortTwoArrayCommand())
                .addCommand(new ReadFromFileCommand());
    }

    /**
     * Метод, демонстрація 3-го рівня.
     * @return Контекст виконання 3-го рівня.
     */
    private static Context setupLevel3() {
        return new Context("Рівень 3")
                .addCommand(new ExitCommand());
    }
}
