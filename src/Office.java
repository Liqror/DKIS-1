import java.util.Objects;

public class Office extends Room {
    /**
     * Количество компьютеров
     */
    private int numComputers;
    /**
     * Освещение
     */
    private String lighting;

    /**
     * Параметризированный конструктор
     *
     * @param capacity                вместимость
     * @param wallColor               цвет стен
     * @param numComputers            количество компьютеров
     * @param lighting                освещение
     */
    public Office(int capacity, String wallColor,
                  int numComputers, String lighting) {
        super(capacity, wallColor);
        this.numComputers = numComputers;
        this.lighting = lighting;
    }

    /**
     * Конструктор без параметров
     */
    public Office() {
        super();
        this.numComputers = 0;
        this.lighting = "Неизвестно";
    }

    public int getNumComputers() {
        return this.numComputers;
    }
    public String getLighting() {
        return this.lighting;
    }

    public void setNumComputers(int numComputers) {
        this.numComputers = numComputers;
    }

    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    /**
     * Сравнение
     *
     * @param o экземляр, с которым будет происходить сравнение
     * @return являются ли экземпляры эквивалентными
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Office office)) return false;
        if (!super.equals(o)) return false;
        return getNumComputers() == office.getNumComputers() && getLighting().equals(office.getLighting());
    }

    /**
     * Получение хэш-кода
     *
     * @return хэш
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumComputers(), getLighting());
    }

    /**
     * Строковое представление экземляра
     *
     * @return строковое представление
     */
    @Override
    public String toString() {
        return "Кабинет: " +
                "Количество компьютеров - " + numComputers +
                ", Освещение - " + lighting +
                ' ';
    }
}
