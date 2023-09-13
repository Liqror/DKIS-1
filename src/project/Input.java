package project;

import java.util.Scanner;

/**
 * Класс для ввода в консоль
 */
public class Input {

    /**
     * Метод для ввода и проверки вводимых значений типа int
     *
     * @return Значение int
     */
    public static int intInput() {
        int num;
        Scanner in = new Scanner(System.in);
        while (!in.hasNextInt()) {
            System.err.println("Некорректный ввод");
            in.next();
        }
        num = in.nextInt();
        return num;
    }

    /**
     * Метод для ввода и проверки вводимых значений типа float
     *
     * @return Значение float
     */
    public static float floatInput() {
        float num;
        Scanner in = new Scanner(System.in);
        while (!in.hasNextFloat()) {
            System.err.println("Некорректный ввод");
            in.next();
        }
        num = in.nextFloat();
        return num;
    }

    /**
     * Метод для проверки принадлежности числа типа int к натуральным числам
     *
     * @return положительное число типа float
     */
    public static float naturalFloatInput() {
        float num;
        do {
            num = floatInput();
            if (num <= 0) {
                System.err.println("Число должно быть положительным");
            }
        } while (num <= 0);
        return num;
    }

    /**
     * Метод для проверки принадлежности числа типа int к натуральным числам
     *
     * @return положитлеьное число типа int
     */
    public static int naturalIntInput() {
        int num;
        do {
            num = intInput();
            if (num <= 0) {
                System.err.println("Число должно быть положительным");
            }
        } while (num <= 0);
        return num;
    }

    /**
     * Метод для проверки принадлежности числа типа int к натуральным числам
     *
     * @return положитлеьное число типа int
     */
    public static int spNaturalIntInput() {
        int num;
        do {
            num = intInput();
            if ((num <= 0) || (num > 100)) {
                System.err.println("Число должно быть в диапазоне от 0 до 100");
            }
        } while ((num <= 0) || (num > 100));
        return num;
    }

    public static String stringInput() {
        String string;
        Scanner in = new Scanner(System.in);
        do {
            string = in.nextLine();
            if (string.length() == 0) {
                System.err.println("Строка не может быть пустой");
            }
        }
        while (string.length() == 0);

        return string;
    }
}