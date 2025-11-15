import java.util.ArrayList;

// Custom Exception: Duplicate Employee
class DuplicateEmployeeException extends Exception {
    public DuplicateEmployeeException(String msg) {
        super(msg);
    }
}

// Custom Exception: Employee Not Found
class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String msg) {
        super(msg);
    }
}

// Employee Class
class Employee {
    int id;
    String name, designation;

    Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Designation: " + designation);
    }
}

public class EmployeeDirectory {

    private ArrayList<Employee> employees = new ArrayList<>();

    // Add Employee
    public void addEmployee(Employee emp) throws DuplicateEmployeeException {
        for (Employee e : employees) {
            if (e.id == emp.id)
                throw new DuplicateEmployeeException("Duplicate Employee ID!");
        }
        employees.add(emp);
        System.out.println("Employee Added: " + emp.name);
    }

    // Search Employee
    public Employee searchEmployee(int id) throws EmployeeNotFoundException {
        for (Employee e : employees) {
            if (e.id == id)
                return e;
        }
        throw new EmployeeNotFoundException("Employee not found!");
    }

    // Print All Employees
    public void displayAll() {
        System.out.println("\n=== Employee List ===");
        for (Employee e : employees) {
            e.display();
        }
    }

    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        try {
            directory.addEmployee(new Employee(1, "Rahul", "Manager"));
            directory.addEmployee(new Employee(2, "Sneha", "Developer"));
            directory.addEmployee(new Employee(2, "Amit", "Tester")); // Duplicate

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Employee emp = directory.searchEmployee(3); // Not found
            emp.display();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        directory.displayAll();
    }
}
