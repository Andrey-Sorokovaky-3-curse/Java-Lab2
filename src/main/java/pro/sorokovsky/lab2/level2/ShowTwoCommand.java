package pro.sorokovsky.lab2.level2;

import pro.sorokovsky.console.commands.Command;
import pro.sorokovsky.console.commands.Context;
import pro.sorokovsky.console.exceptions.ValidationException;
import pro.sorokovsky.console.inputs.BooleanInput;
import pro.sorokovsky.console.inputs.StringInput;

/**
 * Команда для виведення двовимірного масиву.
 * @author Сороковський Андрій
 * @version 1.0.0
 */
public class ShowTwoCommand extends Command {
    private final StringInput stringInput = new StringInput();
    private final BooleanInput booleanInput = new BooleanInput();

    /**
     * Повертає назву команди.
     * @return "Виведення двовимірного масиву на екран".
     */
    @Override
    protected String getName() {
        return "Виведення двовимірного масиву на екран";
    }

    /**
     * Виконує команду.
     * @param context контекст команд для виконання.
     */
    @Override
    public void execute(Context context) {
        try {
            final var name = stringInput.enter("назву двовимірного масиву");
            context.getClaim(name, TwoArray.class).show(name);
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
            if (booleanInput.enter("спробувати ще")) execute(context);
        }
    }
}
