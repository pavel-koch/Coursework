public class Main {
    public static void main(String[] args) {
        Employee []emp = new Employee[10];

        emp [0] = new Employee("Иванов Иван Иванович", 96500, 7);
        emp [1] = new Employee("G G g", 9000, 4);
        emp [2] = new Employee("P  p p", 65090, 4);
        emp [3] = new Employee("Петров Иван Иванович", 76800.23, 4);
        emp [4] = new Employee("Сидоров Иван Иванович", 32500, 9);
        emp [5] = new Employee("Григорьев Иван Иванович", 82000, 4);
        Employee.getListOfEmployees(emp);
        double a = Employee.calculatingAmountSalaries(emp);
        System.out.println(a);
        Employee.searchForMinimumSalary(emp);
        Employee.searchForMaximumSalary(emp);
        double b = Employee.calculationAverageSalary(emp);
        System.out.println(b);
        Employee.printFullNameEmployee(emp);
    }
}