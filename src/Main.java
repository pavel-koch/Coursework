public class Main {
    public static void main(String[] args) {
        EmployeeBook emp = new EmployeeBook();

        emp.addEmployee ("Иванов Иван Иванович", 96500, 7);
        emp.addEmployee("G G g", 9000, 4);
        emp.addEmployee("P  p p", 65090, 4);
        emp.addEmployee("Петров Иван Иванович", 76800.23, 4);
        emp.addEmployee("Сидоров Иван Иванович", 32500, 9);
        emp.addEmployee("Григорьев Иван Иванович", 82000, 4);
        emp.getListOfEmployees();
        double a = emp.calculatingAmountSalaries();
        System.out.println(a);
        emp.searchForMinimumSalary();
        emp.searchForMaximumSalary();
        double b = emp.calculationAverageSalary();
        System.out.printf("%.2f\n", b);
        emp.printFullNameEmployee();
        emp.indexingSalary(15);
        emp.getListOfEmployees();
        System.out.println("------------------");
        emp.searchForMaximumSalaryOfDepartment(5);
        System.out.println("------------------");
        emp.printAllEmployeeDepartment(4);
        System.out.println("------------------");
        emp.findingLessNumber(100000);
        System.out.println("------------------");
        emp.findingMoreNumber(100000);
        System.out.println("------------------");
        System.out.println("------------------");
        System.out.println(emp.getEmployee(3));
    }
}