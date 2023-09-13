import java.util.ArrayList;

/**
 * Класс тектового интерфейса
 */
public class TUI {

    /**
     * Метод меню, выполняющийся при начале работы
     */
    public static void start() {
        ArrayList<Room> list = new ArrayList<>();
        int choice;
        System.out.println("!!Добро пожаловать в программу!!");
        do {
            menuOutput();
            choice = Input.naturalIntInput();
            switch (choice) {
                case 1:
                    chooseCreateMode(list);
                    break;
                case 2:
                    deleteRoom(list);
                    break;
                case 3:
                    printAllRooms(list);
                    break;
                case 4:
                    compareRooms(list);
                    break;
                default:
                    if (choice != 5) {
                        System.err.println("Использована неизвестная команда");
                    }
            }
        } while (choice != 5);
    }

    /**
     * Метод для выбора режима создания 1 - с заполнением полей 2 - с полями по умолчанию
     *
     * @param list список с помещениями
     */
    private static void chooseCreateMode(ArrayList<Room> list) {
        int choice;
        createInfo();
        do {
            choice = Input.intInput();
            if (choice == 1) {
                addRoom(list);
                break;
            } else if (choice == 2) {
                addClearRoom(list);
                break;
            } else if (choice != 3) {
                System.err.println("Выберите действие из предложенных");
            }
        } while (choice != 3);
    }

    /**
     * Метод для выбора типа помещения для создания с заполнением полей
     *
     * @param list список с помещениями средствами
     */
    private static void addRoom(ArrayList<Room> list) {
        int choice;
        typesOutput();
        choice = Input.intInput();
        switch (choice) {
            case 1 -> list.add(roomMakerInput());
            case 2 -> list.add(classroomMakerInput());
            case 3 -> list.add(gymMakerInput());
            case 4 -> list.add(officeMakerInput());
            default -> System.err.println("Использована неизвестная команда");
        }

    }

    /**
     * Метод для выбора создаваемого средства без полей
     *
     * @param list список с транспортными средствами
     */
    private static void addClearRoom(ArrayList<Room> list) {
        int choice;
        typesOutput();
        choice = Input.intInput();
        switch (choice) {
            case 1 -> list.add(new Room());
            case 2 -> list.add(new Classroom());
            case 3 -> list.add(new Gym());
            case 4 -> list.add(new Office());
            default -> System.err.println("Использована неизвестная команда");
        }

    }

    /**
     * Метод для создания животного с полями
     *
     * @return экземляр класса Room
     */
    private static Room roomMakerInput() {
        String wallColor;
        int capacity;
        System.out.println("Вместимость:");
        capacity = Input.spNaturalIntInput();
        System.out.println("Цвет стен:");
        wallColor = Input.stringInput();
        return new Room(capacity, wallColor);
    }

    /**
     * Метод для создания рыбы с полями
     *
     * @return экземляр класса Gym
     */
    private static Gym gymMakerInput() {
        String wallColor;
        String trainingProgram;
        int capacity;
        int numSimulators;
        System.out.println("Вместимость:");
        capacity = Input.spNaturalIntInput();
        System.out.println("Цвет стен:");
        wallColor = Input.stringInput();
        System.out.println("Количество тренажеров:");
        numSimulators = Input.spNaturalIntInput();
        System.out.println("Программа тренировок:");
        trainingProgram = Input.stringInput();
        return new Gym(capacity, wallColor, numSimulators, trainingProgram);
    }

    /**
     * Метод для создания хищника с полями
     *
     * @return экземляр класса Classroom
     */
    private static Classroom classroomMakerInput() {
        String wallColor;
        String faculty;
        int capacity;
        int numBoards;
        System.out.println("Вместимость:");
        capacity = Input.spNaturalIntInput();
        System.out.println("Цвет стен:");
        wallColor = Input.stringInput();
        System.out.println("Количество досок:");
        numBoards = Input.spNaturalIntInput();
        System.out.println("Факультет:");
        faculty = Input.stringInput();
        return new Classroom(capacity, wallColor, numBoards, faculty);
    }

    /**
     * Метод для создания рептилии с полями
     *
     * @return экземляр класса Reptile
     */
    private static Office officeMakerInput() {
        String wallColor;
        String lighting;
        int capacity;
        int numComputers;
        System.out.println("Вместимость:");
        capacity = Input.spNaturalIntInput();
        System.out.println("Цвет стен:");
        wallColor = Input.stringInput();
        System.out.println("Количество компьютеров:");
        numComputers = Input.spNaturalIntInput();
        System.out.println("Освещение:");
        lighting = Input.stringInput();
        return new Office(capacity, wallColor, numComputers, lighting);
    }

    /**
     * Метод для вывода всех помещений из списка
     *
     * @param list список с помещений
     */
    private static void printAllRooms(ArrayList<Room> list) {
        int count = 1;
        if (list.isEmpty()) {
            System.out.println("Помещений нет");
        } else {
            System.out.println("""
          ВАШИ ПОМЕЩЕНИЯ
          _____________________
          """);
            for (Room room: list) {
                System.out.println("№" + count++ + " " + room.toString());
            }
            System.out.println("______________________");
        }
    }

    /**
     * Метод для удаления помещений из списка
     *
     * @param list список с помещениями
     */
    private static void deleteRoom(ArrayList<Room> list) {
        if (list.isEmpty()) {
            System.out.println("Помещений нет");
        } else {
            System.out.println("Введите номер элемента для удаления:");
            try {
                list.remove(Input.naturalIntInput() - 1);
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Выбран несуществующий элемент");
            }
        }
    }

    /**
     * Метод для сравнения 2-х экземпляров
     *
     * @param list список с помещениями
     */
    private static void compareRooms(ArrayList<Room> list) {
        int firstRoomNumber, secondRoomNumber;
        if (list.size() < 2) {
            System.out.println("Помещений недостаточно");
        } else {
            System.out.println("Введите номер помещения:");
            firstRoomNumber = Input.naturalIntInput();
            System.out.println("Введите номер помещения для сравнения:");
            secondRoomNumber = Input.naturalIntInput();
            try {
                if (list.get(firstRoomNumber - 1).hashCode() == list.get(secondRoomNumber - 1)
                        .hashCode() &&
                        list.get(firstRoomNumber - 1).equals(list.get(secondRoomNumber - 1))) {
                    System.out.println("Помещения эквивалентны");
                } else {
                    System.out.println("Помещения различаются");
                }
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Выбраны несуществующие индексы");
            }
        }
    }

    /**
     * Метод для вывода типов помещений
     */
    private static void typesOutput() {
        System.out.print("""
        ДОБАВЛЕНИЕ
        _______________________________________
        Выберите тип транспорта для добавления:
        1 - Помещение
        2 - Учебная аудитория
        3 - Спортзал
        4 - Кабинет
        5 - Назад
        _______________________________________
        """);
    }

    /**
     * Метод для вывода пунктов меню
     */
    private static void menuOutput() {
        System.out.print("""
        МЕНЮ:
        ______________________________
        Выберите пункт меню:
        1 - Добавить помещение
        2 - Удалить помещение
        3 - Вывод всех помещений
        4 - Сравнение помещений
        5 - Выход
        ______________________________
        """);
    }

    /**
     * Метод для вывода меню создания
     */
    private static void createInfo() {
        System.out.print("""
        СОЗДАНИЕ:
        ____________________________________________
        Выберите пункт меню:
        1 - Заполнить данные о помещение
        2 - Создать помещение без данных
        3 - Назад
        ____________________________________________
        """);
    }
}