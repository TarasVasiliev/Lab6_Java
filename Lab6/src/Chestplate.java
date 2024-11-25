/**
 * Клас Chestplate є підкласом класу ArmorPiece і представляє броню в амуніції лицаря.
 * Цей клас містить конструктор, який ініціалізує ім'я елементу амуніції як "Броня",
 * а також вага і ціна цього елементу.
 *
 * @author Vasiliev Taras
 */
public class Chestplate extends ArmorPiece {

    /**
     * Конструктор класу, який ініціалізує броню із заданою вагою та ціною.
     *
     * @param броня
     * @param weight вага броні у грамах
     * @param price  ціна броні
     */
    public Chestplate(String броня, double weight, double price) {
        super("Броня", weight, price);
    }
}