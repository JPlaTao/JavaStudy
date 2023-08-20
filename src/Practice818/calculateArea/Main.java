package Practice818.calculateArea;

public class Main {
    public static void main(String[] args) {
        Employee manger = new Manager("ala", 3000, 648);
        Employee developer = new Developer("jsj", 21.3, 176);
        System.out.println(manger.calculateSalary());
        System.out.println(developer.calculateSalary());
    }
}