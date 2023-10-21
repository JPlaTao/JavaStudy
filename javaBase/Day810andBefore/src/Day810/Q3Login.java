package Day810;

import java.util.Scanner;

public class Q3Login {
    public static void main(String[] args) {
        logIn();
    }

    public static void logIn(){
        String userName = "jwt";
        int passWord = 123;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; true; i++) {
            System.out.print("请输入用户名:");
            String userNameIn = scanner.next();
            System.out.print("请输入密码:");
            int passWordIn = scanner.nextInt();
            if (userName.equals(userNameIn) && passWord == passWordIn) {
                System.out.println("登录成功!");
                break;
            } else if (i == 3) {
                System.out.println("错误次数超过三次,登陆失败");
                break;
            } else {
                System.out.println("用户名或密码输入错误,请重新输入,剩余次数:" + (2 - i));
            }
        }
    }
}
