package pro.sorokovsky.lab2.level1;

import pro.sorokovsky.console.commands.Command;
import pro.sorokovsky.console.commands.Context;
import pro.sorokovsky.console.exceptions.ValidationException;
import pro.sorokovsky.console.inputs.BooleanInput;
import pro.sorokovsky.console.inputs.StringInput;

/**
 * Клас команди для генерації значення масиву.
 * @author Сороковський Андрій
 * @version 1.0.0
 */
public class GenerateOneCommand extends Command
{
    private final StringInput stringInput = new StringInput();
    private final BooleanInput booleanInput = new BooleanInput();

    @Override
    protected String getName() {
        return "Заповнити одновимірний масив випадковими значеннями";
    }

    @Override
    public void execute(Context context) {
        try {
            String name = stringInput.enter("назву одновимірного масиву");
            if (context.hasClaim(name)) {
                context.getClaim(name, OneArray.class).generate();
                System.out.println("Масив успішно заповнено випадковими значеннями.");
            } else {
                throw new ValidationException("Одновимірний масив не знайдений");
            }
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
            final var retry = booleanInput.enter("спробувати ще");
            if (retry) execute(context);
        }
    }
}
