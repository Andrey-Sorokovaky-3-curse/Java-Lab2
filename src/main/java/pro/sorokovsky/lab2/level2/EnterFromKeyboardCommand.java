package pro.sorokovsky.lab2.level2;

import pro.sorokovsky.console.commands.Command;
import pro.sorokovsky.console.commands.Context;
import pro.sorokovsky.console.exceptions.ValidationException;
import pro.sorokovsky.console.inputs.BooleanInput;
import pro.sorokovsky.console.inputs.StringInput;

/**
 * Команда для введення двовимірного масиву із клавіатури.
 *
 * @author Сороковський Андрій
 * @version 1.0.0
 */
public class EnterFromKeyboardCommand extends Command {
    private final StringInput stringInput = new StringInput();
    private final BooleanInput booleanInput = new BooleanInput();

    /**
     * Повертає назву команди.
     *
     * @return "Заповнити двовимірний масив із клавіатури."
     */
    @Override
    protected String getName() {
        return "Заповнити двовимірний масив із клавіатури.";
    }

    /**
     * Виконує команду.
     *
     * @param context контекст команд для виконання.
     */
    @Override
    public void execute(Context context) {
        try {
            final var name = stringInput.enter("назву масиву");
            context.getClaim(name, TwoArray.class).enterFromKeyBoard();
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
            final var retry = booleanInput.enter("спробувати ще");
            if (retry) execute(context);
        }
    }
}
