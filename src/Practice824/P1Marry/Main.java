package Practice824.P1Marry;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入第一个人的姓名:");
        String p1name = scanner.next();
        System.out.print("请输入第一个人的年龄：");
        int p1age = scanner.nextInt();
        System.out.print("请输入第一个人的性别：");
        String genderTemp = scanner.next();
        char p1gender = genderTemp.charAt(0);
        System.out.println("此人是否已婚？(y/n)");
        boolean p1IsMarried = scanner.next().equals("y");

        Person p1 = new Person(p1name,p1gender,p1age,p1IsMarried);

        System.out.print("请输入第二个人的姓名:");
        String p2name = scanner.next();
        System.out.print("请输入第二个人的年龄：");
        int p2age = scanner.nextInt();
        System.out.print("请输入第二个人的性别");
        String genderTemp2 = scanner.next();
        char p2gender = genderTemp2.charAt(0);
        System.out.println("此人是否已婚？(y/n)");
        boolean p2IsMarried = scanner.next().equals("y");
        Person p2 = new Person(p2name,p2gender,p2age,p2IsMarried);
        System.out.println("此二人"+(CAB.canMarry(p1, p2)? "可以":"不可以" )+ "结婚");
    }
}
