package pro.sorokovsky.console.commands;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Контекст команд, клас призначений для керування командами.
 *
 * @author Сороковський Андрій
 * @version 1.0.0
 */
public class Context extends Command {
    private final String name;

    private boolean isRunning;
    private final List<Command> commands = new LinkedList<>();

    /**
     * Створює контекст команд.
     *
     * @param name назва контексту.
     */
    public Context(String name) {
        this.name = name;
    }

    /**
     * Додає команду до контексту команд.
     *
     * @param command команда
     * @return модифікований контекст команди.
     */
    public Context addCommand(Command command) {
        commands.add(command);
        return this;
    }


    /**
     * Запускає контекст команд.
     */
    public void start() {
        isRunning = true;
        loop();
    }

    /**
     * Зупиняє контекст команд.
     */
    public void stop() {
        isRunning = false;
    }

    /**
     * Повертає назву контексту.
     *
     * @return назва контексту.
     */
    @Override
    protected String getName() {
        return name;
    }

    /**
     * Запускає контекст.
     *
     * @param context контекст команд для виконання.
     */
    @Override
    public void execute(Context context) {
        start();
    }

    /**
     * Запитує та запускає команди поки контекст не зупиниться.
     */
    private void loop() {
        while (isRunning) {
            try {
                prepare();
                showCommands();
                chooseCommand().execute(this);
            } catch (Exception _) {
                System.out.println("Сталася незрозуміла помилка, спробуйте ще.");
            }
        }
    }

    /**
     * Виводить список команд на екран.
     */
    private void showCommands() {
        System.out.printf("%s:%n", name);
        commands.forEach(command -> System.out.println(command.getTitle()));
    }

    /**
     * Запитує у користувача команду.
     *
     * @return вибрану команду.
     */
    private Command chooseCommand() {
        boolean isOk;
        Command command = null;
        do {
            try {
                final var scanner = new Scanner(System.in);
                isOk = true;
                System.out.print(">> ");
                final var number = scanner.nextLong();
                command = commands.stream().filter(item -> item.getId().equals(number)).findFirst().orElse(null);
                if (command == null) {
                    isOk = false;
                    System.out.println("Команду не розпізнано, спробуйте ще.");
                }
            } catch (InputMismatchException _) {
                System.out.println("Ви ввели не число, спробуйте ще.");
                isOk = false;
            }
        } while (!isOk);
        return command;
    }

    /**
     * Підготовлює команди для виконання.
     */
    private void prepare() {
        var index = 0L;
        for (Command command : commands) {
            command.setId(index);
            index++;
        }
    }
}
