import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Interface {

    static GamerMap gamers = new GamerMap();
    static BufferedReader br = null;
    static Scanner console = new Scanner(System.in);

    public static void initialInterface() throws Exception {
        System.out.println("Создайте список для работы, его можно ввести из консоли в формате \"имя_игрока колличество_очков\",\"имя_игрока1 колличество_очков1\"");
        System.out.println("либо можно записать его из файла(написать путь до файла в консоль), формат для записи из файла аналогичен");
        System.out.println("Закончить выполнение приложения можно командой EXIT, так же введенной в консоль");
        inputData();
        headerInterface();

    }


    public static void headerInterface() throws Exception {
        System.out.println("Вы можете добавить значение через консоль командой 1");
        System.out.println("удалить элемент по индексу командой 2");
        System.out.println("вывести текущий список в консоль командой 3");
        System.out.println("вывести лучшего игрока в консоль командой 4");
        System.out.println("Закончить выполнение приложения можно командой EXIT, так же введенной в консоль");
        String consoleIn = console.nextLine().toLowerCase();
        switch (consoleIn) {
            case "1":
                inputData();
                headerInterface();
                break;
            case "2":
                consoleRemove();
                headerInterface();
                break;
            case "3":
                consolePrint();
                headerInterface();
                break;
            case "4":
                consoleBestResult();
                headerInterface();
                break;
            case "exit":
                break;
            default:
                System.out.println("Введены некорректные данные, повторите ввод");
                headerInterface();
                break;
        }
    }

    public static void inputData() throws Exception {
        System.out.println("Выберите вариант записи 1 через консоль 2 через файл");
        switch (console.nextLine().toLowerCase()) {
            case "1":
                consoleInput();
                break;
            case "2":
                fileInput();
                break;
            case "exit":
                break;
            default:
                System.out.println("Введены некорректные данные, повторите ввод");
                inputData();
                break;
        }
    }

    private static void consoleRemove() {
        System.out.println("Введите индеск результата, для прекращения ввода введите команду cancel");
        System.out.println("Команда ALL отчистит мапу");
        String consoleInput = console.nextLine();
        gamers.remove(consoleInput);
    }

    private static void consolePrint() {
        gamers.print();
    }

    private static void consoleBestResult() {
        gamers.printBest();
    }

    private static void consoleInput() {
        System.out.println("Введите данные соответствующим паттернум");
        String consoleInput = console.nextLine();
        addGamers(consoleInput);
    }

    private static void addGamers(String input) {
        String[] arrString = input.replace("\"", "").split(",");
        for (String s : arrString) {
            String[] mapStr = s.split(" ");
            gamers.add(mapStr[0], Integer.parseInt(mapStr[1]));
        }
    }

    private static void fileInput() throws Exception {
        System.out.println("Введите путь до файла");
        String path = console.nextLine();
        br = new BufferedReader(new FileReader(path));
        System.out.println("Вы ввели путь: " + path);
        addGamers(br.readLine());
    }
}
