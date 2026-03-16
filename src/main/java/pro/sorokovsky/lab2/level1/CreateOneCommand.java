package pro.sorokovsky.lab2.level1;

import pro.sorokovsky.console.commands.Command;
import pro.sorokovsky.console.commands.Context;
import pro.sorokovsky.console.inputs.SizeInput;
import pro.sorokovsky.console.inputs.StringInput;

/**
 * Клас для створення одновимірного масиву.
 * @author Сороковський Андрій
 * @version 1.0.0
 */
public class CreateOneCommand extends Command {
    private final SizeInput sizeInput = new SizeInput();
    private final StringInput stringInput = new StringInput();

    /**
     * Отримає назву команди.
     * @return назва команди.
     */
    @Override
    protected String getName() {
        return "Створити одновимірний масив";
    }

    /**
     * Створює одновимірний масив.
     * @param context контекст команд для виконання.
     */
    @Override
    public void execute(Context context) {
        final var name = stringInput.enter("назву масиву");
        final var count = sizeInput.enter("розмір масиву");
        context.setClaim(name, new OneArray(count));
        System.out.println("Одновимірний масив успішно створено.");
    }
}
