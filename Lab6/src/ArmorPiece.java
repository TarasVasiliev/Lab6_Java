import java.util.Objects;

/**
 * Абстрактний клас ArmorPiece представляє елемент амуніції лицаря, та є базовим класом для конкретних типів амуніції,
 * таких як шолом, броня, черевики тощо. Цей клас зберігає загальні властивості елементів амуніції, такі як назва,
 * вага та ціна.
 *
 * @author Vasiliev Taras
 */
public abstract class ArmorPiece {

    private String name;    // Назва елемента амуніції
    private double weight;  // Вага елемента амуніції в грамах
    private double price;   // Ціна елемента амуніції в одиницях валюти

    /**
     * Конструктор для ініціалізації елемента амуніції з назвою, вагою та ціною.
     *
     * @param name  назва елемента амуніції
     * @param weight вага елемента амуніції в грамах
     * @param price ціна елемента амуніції
     */
    public ArmorPiece(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public ArmorPiece(double price, double weight) {
    }

    /**
     * Геттер для отримання назви елемента амуніції.
     *
     * @return ім'я елемента амуніції
     */
    public String getName() {
        return name;
    }

    /**
     * Геттер для отримання ваги елемента амуніції.
     *
     * @return вага елемента амуніції в грамах
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Геттер для отримання ціни елемента амуніції.
     *
     * @return ціна елемента амуніції в одиницях валюти
     */
    public double getPrice() {
        return price;
    }

    /**
     * Перевизначення методу equals для коректного порівняння об'єктів ArmorPiece.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ArmorPiece that = (ArmorPiece) obj;
        return Double.compare(that.price, price) == 0 &&
                Double.compare(that.weight, weight) == 0 &&
                name.equals(that.name);
    }

    /**
     * Перевизначення методу hashCode для забезпечення унікальних хеш-кодів об'єктів ArmorPiece.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, price, weight);
    }
}