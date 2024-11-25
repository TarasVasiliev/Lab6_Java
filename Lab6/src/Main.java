/**
 * Клас Main - головний клас для тестування функціонала класу KnightArmor.
 * У цьому класі демонструється використання методів для роботи з набором амуніції,
 * зокрема додавання, видалення, перевірка наявності, обчислення загальної вартості
 * та ітерація по елементах.
 *
 * @author Vasiliev Taras
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Завдання:\n" +
                "Інтерфейс: Set \n" +
                "Внутрішня структура колекції: Двозв’язний список");

        // Створення екземпляра KnightArmor для зберігання амуніції
        KnightArmor knightArmor = new KnightArmor();

        // Додавання елементів амуніції до набору
        knightArmor.add(new Helmet("Шолом", 1500, 200)); // Додаємо шолом
        knightArmor.add(new Chestplate("Броня", 5000, 500)); // Додаємо броню
        knightArmor.add(new Gauntlets("Рукавиці", 750, 100)); // Додаємо рукавиці
        knightArmor.add(new Boots("Черевики", 1000, 150)); // Додаємо черевики

        // Обчислення та виведення загальної вартості всіх елементів амуніції
        System.out.println("\nЗагальна вартість амуніції: " + knightArmor.getTotalCost());

        // Виведення списку всіх елементів амуніції
        System.out.println("\nСписок амуніції:");
        knightArmor.printArmorPieces();

        // Пошук елементів у діапазоні цін
        double minPrice = 100; // Мінімальна ціна
        double maxPrice = 300; // Максимальна ціна
        System.out.println("\nЕлементи амуніції в діапазоні цін від " + minPrice + " до " + maxPrice + ":");
        for (ArmorPiece armorPiece : knightArmor) {
            if (armorPiece.getPrice() >= minPrice && armorPiece.getPrice() <= maxPrice) {
                // Виводимо елементи, що відповідають ціновому діапазону
                System.out.println(armorPiece.getName() + ": ціна - " + armorPiece.getPrice() + ", вага - " + armorPiece.getWeight());
            }
        }

        // Демонстрація видалення елемента амуніції
        System.out.println("\nВидалимо Черевики (Boots) із списку:");
        knightArmor.remove(new Boots("Черевики", 1000, 150)); // Видаляємо черевики
        knightArmor.printArmorPieces(); // Виводимо оновлений список

        // Перевірка наявності елемента в наборі
        boolean containsHelmet = knightArmor.contains(new Helmet("Шолом", 1500, 200)); // Чи є шолом у наборі
        System.out.println("\nЧи містить набір амуніції 'Шолом': " + containsHelmet);

        // Виведення кількості елементів у наборі
        System.out.println("\nКількість елементів у наборі амуніції: " + knightArmor.size());

        // Перевірка, чи набір порожній
        System.out.println("Чи набір амуніції порожній: " + knightArmor.isEmpty());
    }
}
