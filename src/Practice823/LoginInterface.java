package Practice823;

import java.util.Scanner;

public class LoginInterface {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        login();
    }

    public static void login() {
        String name = "kfm";
        String password = "123456";
        for (int i = 3; i > 0; i--) {
            if (i != 3) {
                System.out.printf("请重新输入，剩余机会：%d\n", i);
            }
            System.out.println("请输入登录名：");
            String loginName = scanner.next();
            System.out.println("请输入密码：");
            String loginPassword = scanner.next();

            if (name.equals(loginName)) {
                if (password.equals(loginPassword)) {
                    System.out.println("欢迎进入系统");
                    return;
                } else System.out.println("密码输入错误");
            } else System.out.print("用户名或密码输入错误,");
        }
    }
}
