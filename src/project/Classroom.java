package project;

import java.util.Objects;

public class Classroom extends Room {
    /**
     * Количество досок
     */
    private int numBoards;
    /**
     * Факультет
     */
    private String faculty;

    /**
     * Параметризированный конструктор
     *
     * @param capacity                вместимость
     * @param wallColor               цвет стен
     * @param numBoards               количество досок
     * @param faculty                 факультет
     */
    public Classroom(int capacity, String wallColor,
                     int numBoards, String faculty) {
        super(capacity, wallColor);
        this.numBoards = numBoards;
        this.faculty = faculty;
    }

    /**
     * Конструктор без параметров
     */
    public Classroom() {
        super();
        this.numBoards = 0;
        this.faculty = "Неизвестно";
    }

    public int getNumBoards() {
        return this.numBoards;
    }
    public String getFaculty() {
        return this.faculty;
    }

    public void setNumBoards(int numBoards) {
        this.numBoards = numBoards;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * Сравнение
     *
     * @param o экземляр, с которым будет происходить сравнение
     * @return являются ли экземпляры эквивалентными
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Classroom classroom)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        return getNumBoards() == classroom.getNumBoards() && getFaculty().equals(classroom.getFaculty());
    }

    /**
     * Получение хэш-кода
     *
     * @return хэш
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumBoards(), getFaculty());
    }

    /**
     * Строковое представление экземляра
     *
     * @return строковое представление
     */
    @Override
    public String toString() {
        return "Учебная аудитория: " +
                "Количество досок - " + numBoards +
                ", Факультет - " + faculty +
                ' ';
    }
}
