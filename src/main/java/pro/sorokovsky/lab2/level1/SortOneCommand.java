package pro.sorokovsky.lab2.level1;

import pro.sorokovsky.console.commands.Command;
import pro.sorokovsky.console.commands.Context;
import pro.sorokovsky.console.exceptions.ValidationException;
import pro.sorokovsky.console.inputs.BooleanInput;
import pro.sorokovsky.console.inputs.StringInput;

/**
 * Клас для операції сортування одновимірного масиву.
 * @author Сороковський Андрій
 * @version 1.0.0
 */
public class SortOneCommand extends Command {
    private final StringInput stringInput = new StringInput();
    private final BooleanInput booleanInput = new BooleanInput();

    /**
     * Повертає назву команди.
     * @return "Відсотувати одновимірний масив."
     */
    @Override
    protected String getName() {
        return "Відсотувати одновимірний масив";
    }

    /**
     * Виконує команду.
     * @param context контекст команд для виконання.
     */
    @Override
    public void execute(Context context) {
        try {
            final var name = stringInput.enter("назву масиву");
            context.getClaim(name, OneArray.class).sort();
            System.out.println("Одновимірний масив успішно відсортовано.");
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
            if (booleanInput.enter("спробувати ще")) execute(context);
        }
    }
}
