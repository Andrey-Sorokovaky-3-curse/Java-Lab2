package pro.sorokovsky.lab2.level2;

import pro.sorokovsky.console.commands.Command;
import pro.sorokovsky.console.commands.Context;
import pro.sorokovsky.console.exceptions.ValidationException;
import pro.sorokovsky.console.inputs.BooleanInput;
import pro.sorokovsky.console.inputs.StringInput;

/**
 * Команда сортування двовимірного масиву.
 *
 * @author Сороковський Андрій
 * @version 1.0.0
 */
public class SortTwoArrayCommand extends Command {
    private final StringInput stringInput = new StringInput();
    private final BooleanInput booleanInput = new BooleanInput();

    /**
     * Повертає ім'я команди.
     *
     * @return "Відсортувати двовимірний масив"
     */
    @Override
    protected String getName() {
        return "Відсортувати двовимірний масив";
    }

    /**
     * Виконує команду.
     *
     * @param context контекст команд для виконання.
     */
    @Override
    public void execute(Context context) {
        try {
            String name = stringInput.enter("назву одновимірного масиву");
            context.getClaim(name, TwoArray.class).sort();
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
            final var retry = booleanInput.enter("спробувати ще");
            if (retry) execute(context);
        }
    }
}
