import java.util.Scanner;

public class Menu {
    public static EmployeeBook employeeBook = new EmployeeBook();
    public static Scanner scanner = new Scanner(System.in);

    public static void createMenu() {
        System.out.println("Добро пожаловть в 'Книгу сотрудников'");
        printChoice();
        printStartMenu();
        switch (scanner.nextInt()) {
            case 1 -> createReadyEmployeeBook();
            case 2 -> addNewEmployee();
            default -> System.out.println("Нет такого пункта меню");
        }
        goToMainMenu();
        System.out.println("Спасибо, что воспользовались данной программой.");
    }

    public static void printChoice() {
        System.out.println("Выберите нужный пункт меню:");
    }

    public static void printStartMenu() {
        System.out.println("1 - Использовать готовую книгу сотрудников");
        System.out.println("2 - Создать новую книгу сотрудников");
    }

    public static void printMainMenu() {
        printChoice();
        System.out.println("""
                1 - Добавить сотрудника
                2 - Удалить сотрудника
                3 - Вывести все данные по сотрудникам
                4 - Вывести ФИО всех сотрудников
                5 - Вывести всех сотрудников отдела (1-5)
                6 - Финансы
                7 - Поиск
                0 - Завершить работу программы
                """);
    }

    public static void goToMainMenu() {
        while (true) {
            printMainMenu();
            switch (scanner.nextInt()) {
                case 1 -> addNewEmployee();
                case 2 -> deleteEmployee();
                case 3 -> employeeBook.printListOfEmployees();
                case 4 -> employeeBook.printFullNameEmployee();
                case 5 -> printEmployeesDepartment();
                case 6 -> goToFinanceMenu();
                case 7 -> goToSearchMenu();
                case 0 -> {
                    scanner.close();
                    return;
                }
                default -> System.out.println("Нет такого пункта меню");

            }
        }

    }

    public static void goToFinanceMenu() {
        while (true) {
            printChoice();
            System.out.println("""
                    1 - Посчитать сумму затрат на ЗП в месяц
                    2 - Подсчитать среднее значение зарплат
                    3 - Сумму затрат на ЗП по отделу
                    4 - Подсчитать среднюю ЗП по отделу
                    5 - Проиндексировать зарплату всех сотрудников
                    6 - Проиндексировать зарплату по отделу
                    0 - Вернуться в предыдущее меню
                    """);

            switch (scanner.nextInt()) {
                case 1 -> System.out.println(employeeBook.calculatingAmountSalaries());
                case 2 -> System.out.println(employeeBook.calculationAverageSalary());
                case 3 -> calculatingAmountSalariesDepartment();
                case 4 -> calculationAverageSalaryDepartment();
                case 5 -> indexingSalary();
                case 6 -> indexingSalaryDepartment();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Нет такого пункта меню");
            }
        }

    }

    public static void goToSearchMenu() {
        while (true) {
            printChoice();
            System.out.println("""
                    1 - Найти работника по Id
                    2 - Найти сотрудника с минимальной ЗП
                    3 - Найти сотрудника с максимальной ЗП
                    4 - Найти сотрудника с минимальной ЗП по отделу
                    5 - Найти сотрудника с максимальной ЗП по отделу
                    6 - Найти сотрудника с ЗП меньше чем ХХХХ
                    7 - Найти сотрудника с ЗП больше чем ХХХХ
                    0 - Вернуться в предыдущее меню
                    """);

            switch (scanner.nextInt()) {
                case 1 -> searchEmployeesById();
                case 2 -> employeeBook.searchForMinimumSalary();
                case 3 -> employeeBook.searchForMaximumSalary();
                case 4 -> searchForMinimumSalaryOfDepartment();
                case 5 -> searchForMaximumSalaryOfDepartment();
                case 6 -> printEmployeesWithLessSalaries();
                case 7 -> printEmployeesWithHigherSalaries();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Нет такого пункта меню");
            }
        }
    }


    public static void createReadyEmployeeBook() {
        employeeBook.addEmployee("Иванов Иван Иванович", 96500, 1);
        employeeBook.addEmployee("Гаврилов Антон Игоревич", 9000, 5);
        employeeBook.addEmployee("Ларьков Петр Сергеевич", 65090, 4);
        employeeBook.addEmployee("Петров Андрей Николаевич", 76800.23, 2);
        employeeBook.addEmployee("Сидоров Геннадий Андреевич", 32500, 3);
        employeeBook.addEmployee("Григорьев Сергей Вячеславович", 82000, 5);

        System.out.println("Книга создана");
        employeeBook.printListOfEmployees();
    }

    public static void addNewEmployee() {
        System.out.println("Введите ФИО сотрудника:");
        String fullName = scanner.next();
        if (fullName == null) {
            System.out.println("ФИО не может быть пустым");
            return;
        }
        System.out.println("Введите зарплату сотрудника: ");
        double salary = scanner.nextDouble();
        if (salary <= 0) {
            System.out.println("Зарплата не может быть меньше или равна 0");
            return;
        }
        System.out.println("Введите отдел в котором работает сотрудник (1-5): ");
        int department = scanner.nextInt();
        if (department < 1 || department > 5) {
            System.out.println("Отдел должен быть 1 - 5");
            return;
        }
        employeeBook.addEmployee(fullName, salary, department);
    }

    public static void deleteEmployee() {
        System.out.println("Веведите Id сотрудника которого нужно удалить:");
        int id = scanner.nextInt();
        employeeBook.removeEmployee(id);
    }

    public static void printEmployeesDepartment() {
        System.out.println("Выберите отдел (1-5): ");
        int numDepartment = scanner.nextInt();
        employeeBook.printAllEmployeeDepartment(numDepartment);
    }

    public static void calculatingAmountSalariesDepartment() {
        System.out.println("Выберите отдел (1-5): ");
        int numDepartment = scanner.nextInt();
        employeeBook.calculatingAmountSalariesOfDepartment(numDepartment);
    }

    public static void calculationAverageSalaryDepartment() {
        System.out.println("Выберите отдел (1-5): ");
        int numDepartment = scanner.nextInt();
        employeeBook.calculationAverageSalaryDepartment(numDepartment);
    }

    public static void indexingSalary() {
        System.out.println("Введите процент, на который нужно увеличить ЗП: ");
        int percent = scanner.nextInt();
        employeeBook.indexingSalary(percent);
    }

    public static void indexingSalaryDepartment() {
        System.out.println("Выберите отдел (1-5): ");
        int numDepartment = scanner.nextInt();
        System.out.println("Введите процент, на который нужно увеличить ЗП: ");
        int percent = scanner.nextInt();
        employeeBook.indexingSalaryOfDepartment(percent, numDepartment);
    }

    public static void searchEmployeesById() {
        System.out.println("Введите Id сотрудника: ");
        int id = scanner.nextInt();
        System.out.println(employeeBook.getEmployeeById(id));
    }

    public static void searchForMinimumSalaryOfDepartment() {
        System.out.println("Выберите отдел (1-5): ");
        int numDepartment = scanner.nextInt();
        employeeBook.searchForMinimumSalaryOfDepartment(numDepartment);
    }

    public static void searchForMaximumSalaryOfDepartment() {
        System.out.println("Выберите отдел (1-5): ");
        int numDepartment = scanner.nextInt();
        employeeBook.searchForMaximumSalaryOfDepartment(numDepartment);
    }

    public static void printEmployeesWithLessSalaries() {
        System.out.println("Введите верхний уровень ЗП: ");
        int number = scanner.nextInt();
        employeeBook.printEmployeesWithLessSalaries(number);
    }

    public static void printEmployeesWithHigherSalaries() {
        System.out.println("Введите нижний уровень ЗП: ");
        int number = scanner.nextInt();
        employeeBook.printEmployeesWithHigherSalaries(number);
    }

}
