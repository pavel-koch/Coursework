public class EmployeeBook {
    private Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public Employee getEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        throw new RuntimeException ("Работник с таким Id не существует");
    }

    public void addEmployee(String fullName, double salary, int department) {
        if (size >= employees.length) {
            System.out.println("Нельзя добавить работника, закончилось место");
        }
        Employee newEmployee = new Employee(fullName, salary, department);
        employees[size++] = newEmployee;
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                System.out.println(employees[i].getId() + " " + employees[i].getFullName() + " удален");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
                return;
            }
        }
    }

    public void getListOfEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public double calculatingAmountSalaries() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public void searchForMinimumSalary() {
        double min = employees[0].getSalary();
        int idEmployee = 0;
        for (int i = 0; i < Employee.count; i++) {
            if (min > employees[i].getSalary()) {
                min = employees[i].getSalary();
                idEmployee = i;
            }
        }
        System.out.println("Минимальная зарплата у:\n" + employees[idEmployee]);
    }

    public void searchForMaximumSalary() {
        double max = employees[0].getSalary();
        int idEmployee = 0;
        for (int i = 0; i < Employee.count; i++) {
            if (max < employees[i].getSalary()) {
                max = employees[i].getSalary();
                idEmployee = i;
            }
        }
        System.out.println("Максимальная зарплата у:\n" + employees[idEmployee]);
    }

    public double calculationAverageSalary() {
        double average = (double) (calculatingAmountSalaries() / size);
        return average;
    }

    public void printFullNameEmployee() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i].getFullName());
        }
    }

    public void indexingSalary(double percent) {
        percent /= 100;
        double newSalary = 0;
        for (int i = 0; i < size; i++) {
            newSalary = employees[i].getSalary() + employees[i].getSalary() * percent;
            employees[i].setSalary(newSalary);
        }

    }

    public void searchForMinimumSalaryOfDepartment(int numDepartment) {
        double min = 0;
        int idEmployee = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == numDepartment) {
                min = employees[i].getSalary();
                idEmployee = i;
            }
        }
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == numDepartment && min > employees[i].getSalary()) {
                min = employees[i].getSalary();
                idEmployee = i;
            }
        }
        System.out.println("Минимальная зарплата в " + numDepartment + "  у:\n" + employees[idEmployee]);
    }

    public void searchForMaximumSalaryOfDepartment(int numDepartment) {
        double max = 0;
        int idEmployee = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == numDepartment) {
                max = employees[i].getSalary();
                idEmployee = i;
            }
        }
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == numDepartment && max < employees[i].getSalary()) {
                max = employees[i].getSalary();
                idEmployee = i;
            }
        }
        System.out.println("Максимальная зарплата в " + numDepartment + " отделе у:\n" + employees[idEmployee]);
    }

    public void calculatingAmountSalariesOfDepartment(int numDepartment) {
        double sum = 0;
        for (int i = 0; i < Employee.count; i++) {
            if (employees[i].getDepartment() == numDepartment) {
                sum += employees[i].getSalary();
            }
        }
        System.out.printf("Сумма зарплат в %s отделе равна %s\n", numDepartment, sum);
    }

    public void calculationAverageSalaryDepartment(int numDepartment) {
        double sum = 0;
        int sumElement = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == numDepartment) {
                sum += employees[i].getSalary();
                sumElement++;
            }
        }
        sum = (double) sum / sumElement;
        System.out.printf("Средняя зарплат в %s отделе равна %s\n", numDepartment, sum);
    }

    public void indexingSalaryOfDepartment(double percent, int numDepartment) {
        percent /= 100;
        double newSalary = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == numDepartment) {
                newSalary = employees[i].getSalary() + employees[i].getSalary() * percent;
                employees[i].setSalary(newSalary);
            }
        }

    }

    public void printAllEmployeeDepartment(int numDepartment) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == numDepartment) {
                System.out.println("\nId: " + employees[i].getId() + "\nФИО: " + employees[i].getFullName()
                        + "\nЗарплата: " + employees[i].getSalary());
            }
        }
    }

    public void findingLessNumber(int number) {
        for (int i = 0; i < Employee.count; i++) {
            if (number > employees[i].getSalary()) {
                System.out.println("\nId: " + employees[i].getId() + "\nФИО: " + employees[i].getFullName()
                        + "\nЗарплата: " + employees[i].getSalary());
            }
        }
    }

    public void findingMoreNumber(int number) {
        for (int i = 0; i < size; i++) {
            if (number <= employees[i].getSalary()) {
                System.out.println("\nId: " + employees[i].getId() + "\nФИО: " + employees[i].getFullName()
                        + "\nЗарплата: " + employees[i].getSalary());
            }
        }
    }
}
