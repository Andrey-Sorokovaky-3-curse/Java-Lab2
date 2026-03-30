package pro.sorokovsky.lab2.level2;

import pro.sorokovsky.console.commands.Command;
import pro.sorokovsky.console.commands.Context;
import pro.sorokovsky.console.exceptions.ValidationException;
import pro.sorokovsky.console.inputs.BooleanInput;
import pro.sorokovsky.console.inputs.StringInput;

/**
 * Команда для збереження двовимірного масиву у файл.
 *
 * @author Сороковський Андрій
 * @version 1.0.0
 */
public class SaveToFileCommand extends Command {
    private final StringInput stringInput = new StringInput();
    private final BooleanInput booleanInput = new BooleanInput();

    /**
     * Повертає назву команди.
     *
     * @return "Зберегти двовимірний масив у файл"
     */
    @Override
    protected String getName() {
        return "Зберегти двовимірний масив у файл";
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
            final var path = stringInput.enter("шлях до нового файлу");
            context.getClaim(name, TwoArray.class).saveToFile(path);
            System.out.println("Успішно збережено.");
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
            final var retry = booleanInput.enter("спробувати ще");
            if (retry) execute(context);
        }
    }
}
