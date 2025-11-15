// Base Class
class Employee {
    String name;
    int employeeId;

    Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    void DisplayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
    }
}

// Full-Time Employee Class
class FullTimeEmployee extends Employee {
    double salary;

    FullTimeEmployee(String name, int employeeId, double salary) {
        super(name, employeeId);
        this.salary = salary;
    }

    @Override
    void DisplayDetails() {
        super.DisplayDetails();
        System.out.println("Salary: ₹" + salary);
        System.out.println();
    }
}

// Part-Time Employee Class
class PartTimeEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;

    PartTimeEmployee(String name, int employeeId, double hourlyRate, int hoursWorked) {
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    void DisplayDetails() {
        super.DisplayDetails();
        System.out.println("Hourly Rate: ₹" + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Total Pay: ₹" + (hourlyRate * hoursWorked));
        System.out.println();
    }
}

// Main Class
public class EmployeeManagement {
    public static void main(String[] args) {
        Employee emp1 = new FullTimeEmployee("Rahul", 101, 45000);
        Employee emp2 = new PartTimeEmployee("Sneha", 102, 300, 40);

        System.out.println("=== Employee Details ===");
        emp1.DisplayDetails();
        emp2.DisplayDetails();
    }
}
