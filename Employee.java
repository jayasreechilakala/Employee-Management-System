import java.util.LinkedList;
import java.util.Scanner;

class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeManagementSystem {
    private LinkedList<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new LinkedList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void removeEmployee(int id) {
        boolean removed = false;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employees) {
                System.out.println("Name: " + employee.getName() + ", ID: " + employee.getId() + ", Salary: " + employee.getSalary());
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("------ Employee Management System ------");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Display Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.next();
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    Employee employee = new Employee(name, id, salary);
                    ems.addEmployee(employee);
                    break;
                case 2:
                    System.out.print("Enter employee ID to remove: ");
                    int removeId = scanner.nextInt();
                    ems.removeEmployee(removeId);
                    break;
                case 3:
                    ems.displayEmployees();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}


