import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        EmployeeBook employeeBook = new EmployeeBook();
        int a;
        System.out.println("Добро пожаловть в 'Книгу сотрудников'");
        printChoice();
        printStartMenu();
        a = scanner.nextInt();
        switch (a) {
            case 1 -> createReadyEmployeeBook(employeeBook);
            case 2 -> addNewEmployee(employeeBook);
            default -> System.out.println("Нет такого пункта меню");
        }
        goToMainMenu(employeeBook);
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
        System.out.println("1 - Добавить сотрудника");
        System.out.println("2 - Удалить сотрудника");
        System.out.println("3 - Вывести все данные по сотрудникам");
        System.out.println("4 - Вывести ФИО всех сотрудников");
        System.out.println("5 - Вывести всех сотрудников отдела (1-5)");
        System.out.println("6 - Финансы");
        System.out.println("7 - Поиск");
        System.out.println("0 - Завершить работу программы");
    }

    public static void goToMainMenu(EmployeeBook employeeBook) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMainMenu();
            int a = scanner.nextInt();
            switch (a) {
                case 1 -> addNewEmployee(employeeBook);
                case 2 -> deleteEmployee(employeeBook);
                case 3 -> employeeBook.getListOfEmployees();
                case 4 -> employeeBook.printFullNameEmployee();
                case 5 -> printEmployeesDepartment(employeeBook);
                case 6 -> goToFinanceMenu(employeeBook);
                case 7 -> goToSearchMenu(employeeBook);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Нет такого пункта меню");

            }
        }

    }

    public static void goToFinanceMenu(EmployeeBook employeeBook) {
        while (true) {
            printChoice();
            System.out.println("1 - Посчитать сумму затрат на ЗП в месяц ");
            System.out.println("2 - Подсчитать среднее значение зарплат");
            System.out.println("3 - Сумму затрат на ЗП по отделу");
            System.out.println("4 - Подсчитать среднюю ЗП по отделу");
            System.out.println("5 - Проиндексировать зарплату всех сотрудников");
            System.out.println("6 - Проиндексировать зарплату по отделу");
            System.out.println("0 - Вернуться в предыдущее меню");

            Scanner scanner = new Scanner(System.in);
            int f = scanner.nextInt();
            switch (f) {
                case 1 -> System.out.println(employeeBook.calculatingAmountSalaries());
                case 2 -> System.out.println(employeeBook.calculationAverageSalary());
                case 3 -> calculatingAmountSalariesDepartment(employeeBook);
                case 4 -> calculationAverageSalaryDepartment(employeeBook);
                case 5 -> indexingSalary(employeeBook);
                case 6 -> indexingSalaryDepartment(employeeBook);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Нет такого пункта меню");
            }
        }

    }


    public static void goToSearchMenu(EmployeeBook employeeBook) {
        while (true) {
            printChoice();
            System.out.println("1 - Найти работника по Id");
            System.out.println("2 - Найти сотрудника с минимальной ЗП");
            System.out.println("3 - Найти сотрудника с максимальной ЗП");
            System.out.println("4 - Найти сотрудника с минимальной ЗП по отделу");
            System.out.println("5 - Найти сотрудника с максимальной ЗП по отделу");
            System.out.println("6 - Найти сотрудника с ЗП меньше чем ХХХХ");
            System.out.println("7 - Найти сотрудника с ЗП больше чем ХХХХ");
            System.out.println("0 - Вернуться в предыдущее меню");

            Scanner scanner = new Scanner(System.in);
            int s = scanner.nextInt();
            switch (s) {
                case 1 -> searchEmployeesById(employeeBook);
                case 2 -> employeeBook.searchForMinimumSalary();
                case 3 -> employeeBook.searchForMaximumSalary();
                case 4 -> searchForMinimumSalaryOfDepartment(employeeBook);
                case 5 -> searchForMaximumSalaryOfDepartment(employeeBook);
                case 6 -> findingLessNumber(employeeBook);
                case 7 -> findingMoreNumber(employeeBook);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Нет такого пункта меню");
            }
        }
    }


    public static void createReadyEmployeeBook(EmployeeBook employeeBook) {
        employeeBook.addEmployee("Иванов Иван Иванович", 96500, 1);
        employeeBook.addEmployee("Гаврилов Антон Игоревич", 9000, 5);
        employeeBook.addEmployee("Ларьков Петр Сергеевич", 65090, 4);
        employeeBook.addEmployee("Петров Андрей Николаевич", 76800.23, 2);
        employeeBook.addEmployee("Сидоров Геннадий Андреевич", 32500, 3);
        employeeBook.addEmployee("Григорьев Сергей Вячеславович", 82000, 5);

        System.out.println("Книга создана");
        employeeBook.getListOfEmployees();
    }

    public static void addNewEmployee(EmployeeBook employeeBook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО сотрудника:");
        String fullName = scanner.next();
        System.out.println("Введите зарплату сотрудника: ");
        double salary = scanner.nextDouble();
        System.out.println("Введите отдел в котором работает сотрудник (1-5): ");
        int department = scanner.nextInt();
        employeeBook.addEmployee(fullName, salary, department);
    }

    public static void deleteEmployee(EmployeeBook employeeBook) {
        System.out.println("Веведите Id сотрудника которого нужно удалить:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        employeeBook.removeEmployee(id);
    }

    public static void printEmployeesDepartment(EmployeeBook employeeBook) {
        System.out.println("Выберите отдел (1-5): ");
        Scanner scanner = new Scanner(System.in);
        int numDepartment = scanner.nextInt();
        employeeBook.printAllEmployeeDepartment(numDepartment);
    }

    public static void calculatingAmountSalariesDepartment(EmployeeBook employeeBook) {
        System.out.println("Выберите отдел (1-5): ");
        Scanner scanner = new Scanner(System.in);
        int numDepartment = scanner.nextInt();
        employeeBook.calculatingAmountSalariesOfDepartment(numDepartment);
    }

    public static void calculationAverageSalaryDepartment(EmployeeBook employeeBook) {
        System.out.println("Выберите отдел (1-5): ");
        Scanner scanner = new Scanner(System.in);
        int numDepartment = scanner.nextInt();
        employeeBook.calculationAverageSalaryDepartment(numDepartment);
    }

    public static void indexingSalary(EmployeeBook employeeBook) {
        System.out.println("Введите процент, на который нужно увеличить ЗП: ");
        Scanner scanner = new Scanner(System.in);
        int percent = scanner.nextInt();
        employeeBook.indexingSalary(percent);
    }

    public static void indexingSalaryDepartment(EmployeeBook employeeBook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите отдел (1-5): ");
        int numDepartment = scanner.nextInt();
        System.out.println("Введите процент, на который нужно увеличить ЗП: ");
        int percent = scanner.nextInt();
        employeeBook.indexingSalaryOfDepartment(percent, numDepartment);
    }

    public static void searchEmployeesById(EmployeeBook employeeBook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Id сотрудника: ");
        int id = scanner.nextInt();
        System.out.println(employeeBook.getEmployeeById(id));
    }

    public static void searchForMinimumSalaryOfDepartment(EmployeeBook employeeBook) {
        System.out.println("Выберите отдел (1-5): ");
        Scanner scanner = new Scanner(System.in);
        int numDepartment = scanner.nextInt();
        employeeBook.searchForMinimumSalaryOfDepartment(numDepartment);
    }

    public static void searchForMaximumSalaryOfDepartment(EmployeeBook employeeBook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите отдел (1-5): ");
        int numDepartment = scanner.nextInt();
        employeeBook.searchForMinimumSalaryOfDepartment(numDepartment);
    }

    public static void findingLessNumber(EmployeeBook employeeBook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите верхний уровень ЗП: ");
        int number = scanner.nextInt();
        employeeBook.findingLessNumber(number);
    }

    public static void findingMoreNumber(EmployeeBook employeeBook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите нижний уровень ЗП: ");
        int number = scanner.nextInt();
        employeeBook.findingMoreNumber(number);
    }

}
