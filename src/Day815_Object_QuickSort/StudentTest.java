package Day815_Object_QuickSort;

public class StudentTest {
    public static void main(String[] args) {
        Student stu0 = new Student();
        stu0.id = 0;
        stu0.name = "懒羊羊";
        stu0.gender = "公";
        stu0.age = 18;
        stu0.score = 59;
        System.out.println(stu0.say());
    }
}
