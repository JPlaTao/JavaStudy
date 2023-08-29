package Day829_InnerClass;

public class E2_Class {


}

class Student {
    private String name;
    private char gender;
    private int score;

    public Student() {
    }

    public Student(String name, char gender, int score) {
        this.name = name;
        this.gender = gender;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}


interface Plan {
    void printInfo();

    void avgScore();

}

class PlanA implements Plan {
    Student[] students = new Student[10];

    @Override
    public void printInfo() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public void avgScore() {
        int sum = 0;
        for (Student student : students) {
            sum += student.getScore();
        }
        System.out.println(sum / students.length);
    }
}

class PlanB implements Plan {
    Student[] students = new Student[10];

    @Override
    public void printInfo() {
        int maleCnt = 0, femaleCnt = 0;
        for (Student s : students) {
            System.out.println(s);
            if (s.getGender() == '男') maleCnt++;
            else femaleCnt++;
        }
        System.out.printf("男生人数：%d，女生人数：%d\n", maleCnt, femaleCnt);
    }

    @Override
    public void avgScore() {
        sort(students);
        int sum = 0;
        for (int i = 1; i < students.length - 1; i++) {
            sum += students[i].getScore();
        }
        System.out.printf("最高分：%d，最低分：%d，去掉最高分和最低分后的平均分：%d",
                students[0].getScore(),
                students[students.length - 1].getScore(),
                sum / (students.length - 2));
    }

    private void sort(Student[] s) {
        for (int i = 1; i < s.length; i++) {
            Student temp = new Student();
            int index = i - 1;
            while (index != 0 && s[i].getScore() < s[index].getScore()) {
                s[index + 1] = s[index];
                index--;
            }
            s[index + 1] = temp;
        }
    }
}
