import java.io.Serializable;

/**
 * Клас, що представляє результат обчислень.
 * Реалізує інтерфейс Serializable для можливості збереження об'єктів в файл.
 */
public class Result implements Serializable {
    /**
     * Значення результату.
     */
    private String value;

    /**
     * Конструктор за замовчуванням, що ініціалізує значення результату пустим рядком.
     */
    public Result() {
        value = "";
    }

    /**
     * Метод, що повертає значення результату.
     *
     * @return Значення результату.
     */
    public String getValue() {
        return value;
    }

    /**
     * Метод, що встановлює значення результату.
     *
     * @param value Нове значення результату.
     */
    public void setValue(String value) {
        this.value = value;
    }

}