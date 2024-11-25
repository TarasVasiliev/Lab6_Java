/**
 * Клас Helmet є підкласом класу ArmorPiece і представляє шолом в амуніції лицаря.
 * Цей клас містить конструктор, який ініціалізує ім'я елементу амуніції як "Шолом",
 * а також вага і ціна цього елементу.
 *
 * @author Vasiliev Taras
 */
public class Helmet extends ArmorPiece {

    /**
     * Конструктор класу, який ініціалізує шолом із заданою вагою та ціною.
     *
     * @param шолом
     * @param weight вага шолома у грамах
     * @param price  ціна шолома
     */
    public Helmet(String шолом, double weight, double price) {
        super("Шолом", weight, price);
    }
}