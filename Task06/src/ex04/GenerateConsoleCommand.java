package ex04;
import ex02.View;

import java.util.Scanner;

/** Консольная команда
 * Generate;
 * шаблон Command
 * @author xone
 * @version 1.0
 */
public class GenerateConsoleCommand implements ConsoleCommand {
    /** Объект, реализующий интерфейс {@linkplain View};
     * обслуживает коллекцию объектов {@linkplain ex02.Result}
     */
    private View view;
    /** Инициализирует поле {@linkplain GenerateConsoleCommand#view}
     * @param view объект, реализующий интерфейс {@linkplain View}
     */
    public GenerateConsoleCommand(View view) {
        this.view = view;
    }
    @Override
    public char getKey() {
        return 'g';
    }
    @Override
    public String toString() {
        return "'g'enerate";
    }
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true) {
            System.out.print("Введіть ціле число: ");

            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                break;
            } else {
                System.out.println("Введено невірне значення. Спробуйте ще раз.");
                scanner.next();
            }
        }

        int choice;
        while (true) {
            System.out.println("Выберіть тип представлення: ");
            System.out.println("1 - Двійкове");
            System.out.println("2 - Вісімкове");
            System.out.println("3 - Шістнадцяткове");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3) {
                    break;
                } else {
                    System.out.println("Введено некорректное значение. Попробуйте еще раз.");
                }
            } else {
                System.out.println("Введено невірне значення. Спробуйте ще раз.");
                scanner.next();
            }
        }
        view.viewInit(choice, num);
        view.viewShow();
    }
}