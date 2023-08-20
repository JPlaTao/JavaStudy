package Practice818.calculateArea;

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
