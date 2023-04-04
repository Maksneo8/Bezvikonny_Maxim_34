import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * Клас, який містить методи для обчислення та відображення результатів.
 *
 * @author Alex
 * @version 1.0
 */
public class Calc {
    /**
     * Об'єкт, який містить результат обчислень.
     */
    private Result result = new Result();
    /**
     * Ім'я файлу, в якому зберігається результат обчислень.
     */
    private static final String FNAME = "Objects.bin";
    /**
     * Введене користувачем число.
     */
    private int x;

    public void Choice(int c) {

        switch (c) {
            case 1 -> result.setValue(toBinaryString(x));
            case 2 -> result.setValue(toOctalString(x));
            case 3 -> result.setValue(toHexString(x));
            default -> System.out.println("Некоректний вибір!");
        }

    }

    /**
     * Встановлює число, введене користувачем.
     *
     * @param num Число, введене користувачем.
     */
    public void SetDig(int num) {

        this.x = num;
    }

    /**
     * Перетворює число в двійкову систему числення.
     *
     * @param x Число для перетворення.
     * @return Рядок, що містить двійкове представлення числа.
     */
    protected String toBinaryString(int x) {

        return Integer.toBinaryString(x);
    }

    /**
     * Перетворює число в вісімкову систему числення.
     *
     * @param x Число для перетворення.
     * @return Рядок, що містить двійкове представлення числа.
     */
    protected String toOctalString(int x) {
        return Integer.toOctalString(x);
    }

    /**
     * Перетворює число в шістнадцяткову систему числення.
     *
     * @param x Число для перетворення.
     * @return Рядок, що містить двійкове представлення числа.
     */
    protected String toHexString(int x) {
        return Integer.toHexString(x);
    }

    /**
     * Результат обчислень.
     */
    public void show() {

        System.out.println(result.getValue());
    }

    public Result getResult() {
        return result;
    }


    /**
     * Зберігає результат обчислень в файл.
     *
     * @throws IOException Виникає, якщо не вдається записати об'єкт у файл.
     */
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }

    /**
     * Відновлює результат обчислень з файлу.
     *
     * @throws IOException Виникає, якщо не вдається прочитати об'єкт з файлу.
     */
    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (Result) is.readObject();
        is.close();
    }
}