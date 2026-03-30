package pro.sorokovsky.lab2.level2;

import pro.sorokovsky.console.commands.Command;
import pro.sorokovsky.console.commands.Context;
import pro.sorokovsky.console.exceptions.ValidationException;
import pro.sorokovsky.console.inputs.BooleanInput;
import pro.sorokovsky.console.inputs.StringInput;

/**
 * Команда для читання двовимірного масиву із файлу.
 *
 * @author Сороковський Андрій
 * @version 1.0.0
 */
public class ReadFromFileCommand extends Command {
    private final StringInput stringInput = new StringInput();
    private final BooleanInput booleanInput = new BooleanInput();
    private Boolean wasClaim = false;

    /**
     * Повертає назву команди.
     *
     * @return "Прочитати із файлу"
     */
    @Override
    protected String getName() {
        return "Прочитати із файлу";
    }

    /**
     * Виконує команду.
     *
     * @param context контекст команд для виконання.
     */
    @Override
    public void execute(Context context) {
        String name = "";
        try {
            wasClaim = true;
            name = stringInput.enter("назву масиву");
            if (!context.hasClaim(name)) {
                wasClaim = false;
                context.setClaim(name, new TwoArray());
            }
            final var path = stringInput.enter("шлях до файлу");
            context.getClaim(name, TwoArray.class).parseFromFile(path);
        } catch (ValidationException exception) {
            if (!wasClaim) context.clearClaim(name);
            final var retry = booleanInput.enter("спробувати ще");
            if (retry) execute(context);
        }
    }
}
