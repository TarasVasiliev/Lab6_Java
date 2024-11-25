/**
 * Клас Gauntlets є підкласом класу ArmorPiece і представляє рукавиці в амуніції лицаря.
 * Цей клас містить конструктор, який ініціалізує ім'я елементу амуніції як "Рукавиці",
 * а також вага і ціна цього елементу.
 *
 * @author Vasiliev Taras
 */
public class Gauntlets extends ArmorPiece {

    /**
     * Конструктор класу, який ініціалізує рукавиці із заданою вагою та ціною.
     *
     * @param рукавиці
     * @param weight   вага рукавичок у грамах
     * @param price    ціна рукавичок
     */
    public Gauntlets(String рукавиці, double weight, double price) {
        super("Рукавиці", weight, price);
    }
}