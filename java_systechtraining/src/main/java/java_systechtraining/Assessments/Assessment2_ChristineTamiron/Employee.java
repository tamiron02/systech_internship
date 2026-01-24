package java_systechtraining.Assessments.Assessment2_ChristineTamiron;


public class Employee {
    private String name;
    private String id;
    private double salary;

    // Constructor
    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    
    // Developer subclass extending Employee
    static class Developer extends Employee {
        public Developer(String name, String id, double salary) {
            super(name, id, salary);
        }
    
        @Override
        public double calculateBonus() {
            return this.getSalary() * 0.10; // 10% bonus for developers
        }
    }

    //Managers subclass extending Employee
    static class Manager extends Employee {
        public Manager(String name, String id, double salary) {
            super(name, id, salary);
        }
    
        @Override
        public double calculateBonus() {
            return this.getSalary() * 0.15; // 15% bonus for managers
        }
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    public double calculateBonus() {
        return this.salary * 0.05; // 5% bonus
    }

public void displayInfo() {
    System.out.println ("Employee Name: " + name + ", ID: " + id + ", Salary: $" + salary + ", Bonus: $" + calculateBonus());
}

    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice", "E001", 60000.0);
        Employee emp2 = new Employee("Bob", "E002", 75000.0);
        Developer dev1 = new Developer("Dave", "D001", 80000.0);
        Manager mgr1 = new Manager("Eve", "M001", 90000.0);

        emp1.displayInfo();
        emp2.displayInfo();
        dev1.displayInfo();
        mgr1.displayInfo();
    }
}