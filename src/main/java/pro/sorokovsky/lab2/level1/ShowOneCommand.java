package pro.sorokovsky.lab2.level1;

import pro.sorokovsky.console.commands.Command;
import pro.sorokovsky.console.commands.Context;
import pro.sorokovsky.console.exceptions.ValidationException;
import pro.sorokovsky.console.inputs.BooleanInput;
import pro.sorokovsky.console.inputs.StringInput;

/**
 * Клас для виведення одновимірного масиву на екран.
 * @author Сороковський Андрій
 * @version 1.0.0
 */
public class ShowOneCommand extends Command {
    private final StringInput stringInput = new StringInput();
    private final BooleanInput booleanInput = new BooleanInput();

    /**
     * Повертає назву команди.
     * @return "Виведення одновимірного масиву".
     */
    @Override
    protected String getName() {
        return "Виведення одновимірного масиву";
    }

    /**
     * Виконує команду.
     * @param context контекст команд для виконання.
     */
    @Override
    public void execute(Context context) {
        try {
            final var name = stringInput.enter("назву масиву");
            final var array = context.getClaim(name, OneArray.class);
            array.show(name);
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
            if (booleanInput.enter("спробувати ще")) execute(context);
        }
    }
}
