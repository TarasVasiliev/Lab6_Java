/**
 * Клас Boots є підкласом класу ArmorPiece і представляє черевики в амуніції лицаря.
 * Цей клас містить конструктор, який ініціалізує ім'я елементу амуніції як "Черевики",
 * а також вага і ціна цього елементу.
 *
 * @author Vasiliev Taras
 */
public class Boots extends ArmorPiece {

    /**
     * Конструктор класу, який ініціалізує черевики із заданою вагою та ціною.
     *
     * @param черевики
     * @param weight   вага черевиків у грамах
     * @param price    ціна черевиків
     */
    public Boots(String черевики, double weight, double price) {
        super("Черевики", weight, price);
    }
}