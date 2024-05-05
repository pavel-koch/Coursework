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
}
