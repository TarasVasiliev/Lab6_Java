import java.util.Iterator;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Клас KnightArmor реалізує інтерфейс Set<ArmorPiece> та представляє набір амуніції лицаря.
 * Елементи зберігаються у вигляді двозв'язного списку.
 * Цей клас забезпечує операції додавання, видалення та ітерації над елементами, а також
 * додаткові функції, такі як підрахунок загальної вартості амуніції.
 *
 * @author Vasiliev Taras
 */
public class KnightArmor implements Set<ArmorPiece> {

    /**
     * Внутрішній клас Node представляє вузол двозв'язного списку.
     */
    private static class Node {
        ArmorPiece data; // Елемент амуніції
        Node next;       // Посилання на наступний вузол
        Node prev;       // Посилання на попередній вузол

        Node(ArmorPiece data) {
            this.data = data;
        }
    }

    private Node head; // Початок списку
    private Node tail; // Кінець списку
    private int size;  // Розмір списку

    /**
     * Конструктор за замовчуванням ініціалізує порожній список.
     */
    public KnightArmor() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * @return Кількість елементів у наборі.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return true, якщо набір порожній; інакше - false.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Перевіряє, чи міститься заданий елемент у наборі.
     *
     * @param o Об'єкт для перевірки.
     * @return true, якщо елемент присутній; інакше - false.
     */
    @Override
    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * @return Ітератор для ітерації по елементах набору.
     */
    @Override
    public Iterator<ArmorPiece> iterator() {
        return new Iterator<ArmorPiece>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public ArmorPiece next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                ArmorPiece data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * @return Масив, що містить всі елементи набору.
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    /**
     * Перетворює набір у масив заданого типу.
     *
     * @param <T> Тип елементів масиву.
     * @param a Масив, у який будуть скопійовані елементи.
     * @return Масив, що містить елементи набору.
     */
    @Override
    public <T> T[] toArray(T[] a) {
        Node current = head;
        int index = 0;
        for (int i = 0; i < a.length && current != null; i++) {
            a[i] = (T) current.data;
            current = current.next;
        }
        return a;
    }

    /**
     * Додає елемент до набору, якщо він ще не присутній.
     *
     * @param armorPiece Елемент амуніції для додавання.
     * @return true, якщо елемент було додано; інакше - false.
     */
    @Override
    public boolean add(ArmorPiece armorPiece) {
        if (contains(armorPiece)) {
            return false;
        }
        Node newNode = new Node(armorPiece);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * Видаляє заданий елемент із набору.
     *
     * @param o Об'єкт для видалення.
     * @return true, якщо елемент було видалено; інакше - false.
     */
    @Override
    public boolean remove(Object o) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Перевіряє, чи всі елементи колекції містяться у наборі.
     *
     * @param c Колекція для перевірки.
     * @return true, якщо всі елементи містяться у наборі; інакше - false.
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Додає всі елементи з колекції до набору.
     *
     * @param c Колекція, елементи якої додаються.
     * @return true, якщо хоча б один елемент було додано; інакше - false.
     */
    @Override
    public boolean addAll(Collection<? extends ArmorPiece> c) {
        boolean modified = false;
        for (ArmorPiece armorPiece : c) {
            if (add(armorPiece)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Видаляє всі елементи, що не містяться у заданій колекції.
     *
     * @param c Колекція, яку потрібно залишити.
     * @return true, якщо набір змінився; інакше - false.
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node current = head;
        while (current != null) {
            if (!c.contains(current.data)) {
                Node temp = current.next;
                remove(current.data);
                current = temp;
                modified = true;
            } else {
                current = current.next;
            }
        }
        return modified;
    }

    /**
     * Видаляє всі елементи, що містяться у заданій колекції.
     *
     * @param c Колекція для видалення.
     * @return true, якщо хоча б один елемент було видалено; інакше - false.
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c) {
            if (remove(o)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Очищає набір, видаляючи всі елементи.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // Додаткові методи

    /**
     * Обчислює загальну вартість амуніції в наборі.
     *
     * @return Загальна вартість всіх елементів амуніції.
     */
    public double getTotalCost() {
        double totalCost = 0;
        Node current = head;
        while (current != null) {
            totalCost += current.data.getPrice();
            current = current.next;
        }
        return totalCost;
    }

    /**
     * Виводить у консоль список усіх елементів амуніції.
     */
    public void printArmorPieces() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data.getName() + ": ціна - " + current.data.getPrice() + ", вага - " + current.data.getWeight());
            current = current.next;
        }
    }
}
