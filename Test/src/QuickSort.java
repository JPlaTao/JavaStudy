import java.util.Arrays;

class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
}

public class QuickSort {
    public static void main(String[] args) {
        Student[] stu = new Student[3];
        stu[0] = new Student("张三", 19);
        stu[1] = new Student("李四", 14);
        stu[2] = new Student("王二麻子", 17);
        quickSort(stu, 0, stu.length - 1);
        System.out.println(Arrays.toString(stu));
    }

    public static void quickSort(Student[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        Student pivot = arr[left];
        while (left < right) {
            while (left < right && pivot.getAge() > arr[right].getAge()) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }
            while (left < right && pivot.getAge() <= arr[right].getAge()) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
            if (left == right) {
                arr[left] = pivot;
            }
            quickSort(arr, start, right - 1);
            quickSort(arr, left + 1, end);
        }
    }

}
