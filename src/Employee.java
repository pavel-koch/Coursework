import java.util.Objects;

public class Employee {
    private final String fullName;
    private double salary;
    private int department;

    private int id;
    public static int count = 0;

    public Employee(String fullName, double salary, int department) {
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
        this.id = count++;
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

    public int getDepartment() {
        return department;
    }

    public void setSalary(double salary) {
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
        return "Id: " + id + "\nФИО: " + fullName + "\nОтдел: " + department + "\nЗарплата: " + salary + "\n";
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Employee e1 = (Employee) other;
        return fullName.equals(e1.fullName) && salary == e1.salary
                && department == e1.department && id == e1.id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(fullName, salary, department, id);
    }
}
