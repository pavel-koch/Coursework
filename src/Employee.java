public class Employee {
    private final String fullName;
    private double salary;
    private int department;

    private int id;
    public static int count = 0;

    public Employee(String fullName, double salary, int department) {
        this.fullName = fullName;
        if (salary > 0) {
            this.salary = salary;
        } else {
            this.salary = 100500;
        }
        if (department >= 1 && department <= 5) {
            this.department = department;
        } else {
            this.department = 1 + (int) (Math.random() * 5);
        }
        this.id = count;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 0) {
            System.out.println("Зарплата не может быть отрицательной!");
            return;
        }
        this.salary = salary;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            System.out.println("Значение отдела должно быть от 1 до 5");
            return;
        }
        this.department = department;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\nФИО: " + fullName + "\nОтдел: " + department + "\nЗарплата: " + salary;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Employee e1 = (Employee) other;
        if (fullName == null && e1.fullName == null && salary == 0 && e1.salary == 0 && department == 0 && e1.department == 0) {
            return true;
        }
        return fullName.equals(e1.fullName) && salary == e1.salary && department == e1.department;
    }

    @Override
    public int hashCode() {
        if (fullName == null || salary == 0 || department == 0) {
            return 0;
        }
        return ((int) (fullName.hashCode() + salary + department));
    }

    public static void getListOfEmployees(Employee[] arr) {
        for (int i = 0; i < Employee.count; i++) {
            System.out.println(arr[i]);
        }
    }

    public static double calculatingAmountSalaries(Employee[] arr) {
        double sum = 0;
        for (int i = 0; i < Employee.count; i++) {
            sum += arr[i].salary;
        }
        return sum;
    }

    public static void searchForMinimumSalary(Employee[] arr) {
        double min = arr[0].salary;
        int idEmployee = 0;
        for (int i = 0; i < Employee.count; i++) {
            if (min > arr[i].salary) {
                min = arr[i].salary;
                idEmployee = i;
            }
        }
        System.out.println("Минимальная зарплата у:\n" + arr[idEmployee]);
    }

    public static void searchForMaximumSalary(Employee[] arr) {
        double max = arr[0].salary;
        int idEmployee = 0;
        for (int i = 0; i < Employee.count; i++) {
            if (max < arr[i].salary) {
                max = arr[i].salary;
                idEmployee = i;
            }
        }
        System.out.println("Максимальная зарплата у:\n" + arr[idEmployee]);
    }

    public static double calculationAverageSalary(Employee[] arr) {
        double average = (double) (calculatingAmountSalaries(arr) / count);
        return average;
    }

    public static void printFullNameEmployee(Employee[] arr) {
        for (int i = 0; i < Employee.count; i++) {
            System.out.println(arr[i].fullName);
        }
    }

    public static void indexingSalary(double percent, Employee[] arr) {
        percent /= 100;
        for (int i = 0; i < Employee.count; i++) {
            arr[i].salary += arr[i].salary * percent;
        }

    }

    public static void searchForMinimumSalaryOfDepartment(Employee[] arr, int numDepartment) {
        double min = 0;
        int idEmployee = 0;
        for (int i = 0; i < Employee.count; i++) {
            if (arr[i].department == numDepartment) {
                min = arr[i].salary;
                idEmployee = i;
            }
        }
        for (int i = 0; i < Employee.count; i++) {
            if (arr[i].department == numDepartment && min > arr[i].salary) {
                min = arr[i].salary;
                idEmployee = i;
            }
        }
        System.out.println("Минимальная зарплата в " + numDepartment + "  у:\n" + arr[idEmployee]);
    }

    public static void searchForMaximumSalaryOfDepartment(Employee[] arr, int numDepartment) {
        double max = 0;
        int idEmployee = 0;
        for (int i = 0; i < Employee.count; i++) {
            if (arr[i].department == numDepartment) {
                max = arr[i].salary;
                idEmployee = i;
            }
        }
        for (int i = 0; i < Employee.count; i++) {
            if (arr[i].department == numDepartment && max < arr[i].salary) {
                max = arr[i].salary;
                idEmployee = i;
            }
        }
        System.out.println("Максимальная зарплата в " + numDepartment + " отделе у:\n" + arr[idEmployee]);
    }

    public static void calculatingAmountSalariesOfDepartment(Employee[] arr, int numDepartment) {
        double sum = 0;
        for (int i = 0; i < Employee.count; i++) {
            if (arr[i].department == numDepartment) {
                sum += arr[i].salary;
            }
        }
        System.out.printf("Сумма зарплат в %s отделе равна %s\n", numDepartment, sum);
    }

    public static void calculationAverageSalary(Employee[] arr, int numDepartment) {
        double sum = 0;
        int sumElement = 0;
        for (int i = 0; i < Employee.count; i++) {
            if (arr[i].department == numDepartment) {
                sum += arr[i].salary;
                sumElement++;
            }
        }
        sum = (double) sum / sumElement;
        System.out.printf("Средняя зарплат в %s отделе равна %s\n", numDepartment, sum);
    }

    public static void indexingSalaryOfDepartment(double percent, Employee[] arr, int numDepartment) {
        percent /= 100;
        for (int i = 0; i < Employee.count; i++) {
            if (arr[i].department == numDepartment) {
                arr[i].salary += arr[i].salary * percent;
            }
        }

    }

    public static void printAllEmployeeDepartment(Employee[] arr, int numDepartment) {
        for (int i = 0; i < Employee.count; i++) {
            if (arr[i].department == numDepartment) {
                System.out.println("\nId: " + arr[i].id + "\nФИО: " + arr[i].fullName + "\nЗарплата: " + arr[i].salary);
            }
        }
    }

    public static void findingLessNumber(Employee[] arr, int nuber) {
        for (int i = 0; i < Employee.count; i++) {
            if (nuber > arr[i].salary) {
                System.out.println("\nId: " + arr[i].id + "\nФИО: " + arr[i].fullName + "\nЗарплата: " + arr[i].salary);
            }
        }
    }

    public static void findingMoreNumber(Employee[] arr, int nuber) {
        for (int i = 0; i < Employee.count; i++) {
            if (nuber <= arr[i].salary) {
                System.out.println("\nId: " + arr[i].id + "\nФИО: " + arr[i].fullName + "\nЗарплата: " + arr[i].salary);
            }
        }
    }
}
