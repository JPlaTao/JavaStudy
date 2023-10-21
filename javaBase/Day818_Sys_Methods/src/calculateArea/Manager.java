package calculateArea;

public class Manager extends Employee {
    private double bonus;

    public Manager() {
    }

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double calculateSalary() {
        return super.calculateSalary() + bonus;
    }
}
