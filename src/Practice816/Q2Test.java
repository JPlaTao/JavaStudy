package Practice816;

import java.util.Scanner;

public class Q2Test {

    static Q2BankAccount bankAccount = new Q2BankAccount(121385,"夏侯惇");
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        while (true){
            menu();
            int opera = scanner.nextInt();
            switch (opera){
                case 1->showInfo();
                case 2-> {
                    System.out.println("请输入存款数额：");
                    double amount = scanner.nextDouble();
                    deposit(amount);
                }
                case 3->{
                    System.out.println("请输入取款数额：");
                    double amount = scanner.nextDouble();
                    withdrawal(amount);
                }
                case 4-> {
                    return;
                }
            }
        }
    }

    public static void menu(){
        System.out.println("**************************");
        System.out.println("请输入操作：");
        System.out.println("1.查询账号\t2.存款\t3.取款\t4.退出");
        System.out.println("**************************");
    }

    public static void showInfo(){
        bankAccount.showInfo();
    }

    public static void deposit(double amount){
        bankAccount.deposit(amount);
    }
    public static void withdrawal(double amount){
        bankAccount.withdrawal(amount);
    }
}
