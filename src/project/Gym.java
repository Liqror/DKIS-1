package project;

import java.util.Objects;

public class Gym extends Room {
    /**
     * Количество тренажеров
     */
    private int numSimulators;
    /**
     * Программа тренировок
     */
    private String trainingProgram;

    /**
     * Параметризированный конструктор
     *
     * @param capacity                вместимость
     * @param wallColor               цвет стен
     * @param numSimulators           количество тренажеров
     * @param trainingProgram         программа тренировок
     */
    public Gym(int capacity, String wallColor,
               int numSimulators, String trainingProgram) {
        super(capacity, wallColor);
        this.numSimulators = numSimulators;
        this.trainingProgram = trainingProgram;
    }

    /**
     * Конструктор без параметров
     */
    public Gym() {
        super();
        this.numSimulators = 0;
        this.trainingProgram = "Неизвестно";
    }

    public int getNumSimulators() {
        return this.numSimulators;
    }
    public String getTrainingProgram() {
        return this.trainingProgram;
    }

    public void setNumSimulators(int numSimulators) {
        this.numSimulators = numSimulators;
    }

    public void setTrainingProgram(String trainingProgram) {
        this.trainingProgram = trainingProgram;
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
        if (!(o instanceof Gym gym)) return false;
        if (!super.equals(o)) return false;
        return getNumSimulators() == gym.getNumSimulators() && getTrainingProgram().equals(gym.getTrainingProgram());
    }

    /**
     * Получение хэш-кода
     *
     * @return хэш
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumSimulators(), getTrainingProgram());
    }

    /**
     * Строковое представление экземляра
     *
     * @return строковое представление
     */
    @Override
    public String toString() {
        return "Спортзал: " +
                "Количество тренажеров - " + numSimulators +
                ", Программа тренировок - " + trainingProgram +
                ' ';
    }
}
