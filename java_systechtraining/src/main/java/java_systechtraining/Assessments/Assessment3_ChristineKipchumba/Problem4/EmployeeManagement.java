package java_systechtraining.Assessments.Assessment3_ChristineKipchumba.Problem4;

public class EmployeeManagement {
    private  String companyName;
    private String employeeName;
    private double salary;

    public EmployeeManagement(String name) {
        this.employeeName = name;
    }

    public void setCompanyName(String name) {
        companyName = name;
    }

    public  String getCompanyName() {
        return companyName;
    }

    public String getEmployeeName() {
        return employeeName;
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
        return salary * 0.1;
    }

    public static void main(String[] args) {
        EmployeeManagement emp = new EmployeeManagement("Alice");
        emp.setCompanyName("Tech Corp");
        try {
            emp.setSalary(5000);
            System.out.println("Employee: " + emp.getEmployeeName());
            System.out.println("Company: " + emp.getCompanyName());
            System.out.println("Salary: " + emp.getSalary());
            System.out.println("Bonus: " + emp.calculateBonus());
            emp.setSalary(-100); // Will throw exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
