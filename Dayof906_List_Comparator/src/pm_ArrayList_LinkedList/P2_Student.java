package pm_ArrayList_LinkedList;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class P2_Student {

    static class Student {
        private int id;
        private int score;
//        private String name;
        static private int auto_increment_id = 0;

        public Student() {
            Random random = new Random();
            id = auto_increment_id++;
            score = random.nextInt(40) + 60;
        }

        public int getId() {
            return id;
        }

//        public String getName() {
//            return name;
//        }

        public void setId(int id) {
            this.id = id;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public static int getAuto_increment_id() {
            return auto_increment_id;
        }

        public static void setAuto_increment_id(int auto_increment_id) {
            Student.auto_increment_id = auto_increment_id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", score=" + score +
                    '}';
        }
    }


    static class Test {
        public static void main(String[] args) {
            LinkedList students = new LinkedList();
            for (int i = 0; i <= 20; i++) {
                students.add(new Student());
            }

            System.out.println("生成20个学生：");
            students.forEach(o -> System.out.println(o));

            students.sort(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    Student s1 = (Student) o1;
                    Student s2 = (Student) o2;
                    return s2.getScore() - s1.getScore();
                }
            });

//            students.sort(new Comparator() {
//                @Override
//                public int compare(Object o1, Object o2) {
//                    Student s1 = (Student) o1;
//                    Student s2 = (Student) o2;
//                    return s1.getName().compareTo(s2.getName());
//                }
//            });

            System.out.println("排序后:");
            students.forEach(o -> System.out.println(o));
            System.out.println("分数最高的：");
            System.out.println(students.getFirst());
            System.out.println("分数最低的：");
            System.out.println(students.getLast());

        }

    }
}