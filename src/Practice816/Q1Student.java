package Practice816;

public class Q1Student {
    private String name;
    private int age;
    private int studentId;
    private double score;

    public Q1Student(){

    }


    public Q1Student(String name, int age, int studentId, double score) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getScore() {
        return score;
    }
}
