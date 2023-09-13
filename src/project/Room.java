package project;

import java.util.Objects;

public class Room {
    /**
     * Вместимость
     */
    private int capacity;
    /**
     * Цвет стен
     */
    private String wallColor;

    /**
     * Параметризированный конструктор
     *
     * @param capacity           вместимость
     * @param wallColor          цвет стен
     */
    public Room(int capacity, String wallColor) {
        this.capacity = capacity;
        this.wallColor = wallColor;

    }

    /**
     * Конструктор без параметров
     */
    public Room() { this(0, "Неизвестно");
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getWallColor() {
        return this.wallColor;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setWallColor(String wallColor) {
        this.wallColor = wallColor;
    }

    /**
     * Сравнение
     *
     * @param o екземляр, с которым будет происходить сравнение
     * @return являются ли экземпляры эквивалентными
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Room room)) {
            return false;
        }
        return getCapacity() == room.getCapacity()  && getWallColor().equals(
                room.getWallColor());
    }

    /**
     * Получения хэш-кода
     *
     * @return хэш
     */
    @Override
    public int hashCode() {
        return Objects.hash(getCapacity(), getWallColor());
    }

    /**
     * Строкового представления экземляра
     *
     * @return строковое представление
     */
    @Override
    public String toString() {
        return "Помещение: " +
                "Вместимость - " + capacity +
                ", Цвет стен  " + wallColor +
                ' ';
    }
}
