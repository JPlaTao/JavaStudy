package Practices;

import java.util.Set;
import java.util.stream.Collectors;

class Test {
    public static void main(String[] args) {
        Set<Employee> emp = Set.of(new Employee(6716.5),
                new Employee(7555.9),
                new Employee(3849.4),
                new Employee(6366.8),
                new Employee(3755.1));

        Set<Employee> collect = emp.stream().sorted().limit(3).collect(Collectors.toSet());
        collect.forEach(o -> System.out.println(o));
    }

}

class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private double salary;

    public Employee(double salary) {
        this.salary = salary;
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(salary, o.getSalary());
    }
}