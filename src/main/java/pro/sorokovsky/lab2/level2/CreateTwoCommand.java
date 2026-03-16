package pro.sorokovsky.lab2.level2;

import pro.sorokovsky.console.commands.Command;
import pro.sorokovsky.console.commands.Context;
import pro.sorokovsky.console.inputs.SizeInput;
import pro.sorokovsky.console.inputs.StringInput;

/**
 * Команда для створення двовимірного масиву.
 * @author Сороковський Андрій
 * @version 1.0.0
 */
public class CreateTwoCommand extends Command {
    private final StringInput stringInput = new StringInput();
    private final SizeInput sizeInput = new SizeInput();

    /**
     * Повертає назву команди.
     * @return "Створення двовимірного масиву".
     */
    @Override
    protected String getName() {
        return "Створення двовимірного масиву";
    }

    /**
     * Виконує команду.
     * @param context контекст команд для виконання.
     */
    @Override
    public void execute(Context context) {
        final var name = stringInput.enter("назву двовимірного масиву");
        final var count = sizeInput.enter("Розмір двовимірного масиву");
        context.setClaim(name, new TwoArray(count));
        System.out.println("Двовимірний масив успішно створено.");
    }
}
