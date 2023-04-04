import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
/** Обчислення та відображення результатів.
 * Містить реалізацію статичного методу main().
 * @author xone
 * @version 1.0
 * @see Main#main
 */
public class Main {
    /** Об'єкт класу {@linkplain Calc}.<br>Вирішує задачу інд. завдання. */
    private final Calc calc = new Calc();
    /**
     * Метод для відображення головного меню та взаємодії з користувачем.
     */
    private void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Enter command...");
                System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
                try {
                    s = in.readLine();
                } catch(IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'q' -> System.out.println("Exit.");
                case 'v' -> {
                    System.out.println("View current.");
                    calc.show();
                }
                case 'g' -> {
                    Scanner scanner = new Scanner(System.in);

                    System.out.print("Введіть ціле число: ");
                    int num = scanner.nextInt();
                    calc.SetDig(num);

                    System.out.println("Выберіть тип представлення: ");
                    System.out.println("1 - Двійкове");
                    System.out.println("2 - Вісімкове");
                    System.out.println("3 - Шістнадцяткове");
                    int choice = scanner.nextInt();

                    calc.Choice(choice);
                    calc.show();
                }
                case 's' -> {
                    System.out.println("Save current.");
                    try {
                        calc.save();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                }
                case 'r' -> {
                    System.out.println("Restore last saved.");
                    try {
                        calc.restore();
                    } catch (Exception e) {

                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                }
                default -> System.out.print("Wrong command. ");
            }
        } while(s.charAt(0) != 'q');
    }
    /** Виконується під час запуску програми.
     * Обчислюється значення функції для різних аргументів.
     * Результати обчислень відображаються на екрані.
     * @param args – параметри запуску програми.
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}