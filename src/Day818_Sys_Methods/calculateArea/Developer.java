package Day818_Sys_Methods.calculateArea;

public class Developer extends Employee {
    private double hoursWorked;

    public Developer() {
    }
    public Developer(String name, double salary, double hoursWorked) {
        super(name, salary);
        this.hoursWorked = hoursWorked;
    }


    public double calculateSalary() {
        return super.calculateSalary() * hoursWorked;
    }
}
