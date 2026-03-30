package pro.sorokovsky.lab2.level3;

import pro.sorokovsky.console.commands.Command;
import pro.sorokovsky.console.commands.Context;
import pro.sorokovsky.console.exceptions.ValidationException;
import pro.sorokovsky.console.inputs.BooleanInput;
import pro.sorokovsky.console.inputs.StringInput;
import pro.sorokovsky.lab2.level2.TwoArray;

/**
 * Команда для перевірки подібності масивів.
 *
 * @author Сороковський Андрій
 * @version 1.0.0
 */
public class AreTwoArraysEqualCommand extends Command {
    private final StringInput stringInput = new StringInput();
    private final BooleanInput booleanInput = new BooleanInput();

    /**
     * Повертає назву команди.
     *
     * @return "Перевірити ідентичність масивів"
     */
    @Override
    protected String getName() {
        return "Перевірити ідентичність масивів";
    }

    /**
     * Виконує команду.
     *
     * @param context контекст команд для виконання.
     */
    @Override
    public void execute(Context context) {
        try {
            final var firstName = stringInput.enter("назву першого масиву");
            final var first = context.getClaim(firstName, TwoArray.class);
            final var secondName = stringInput.enter("назву другого масиву");
            final var second = context.getClaim(secondName, TwoArray.class);
            first.show(firstName);
            second.show(secondName);
            final var equals = first.equals(second);
            var result = "";
            if (!equals) result = " не";
            System.out.printf("Масиви '%s' і '%s' ->%s подібні.%n", firstName, secondName, result);
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
            final var retry = booleanInput.enter("спробувати ще");
            if (retry) execute(context);
        }
    }
}
