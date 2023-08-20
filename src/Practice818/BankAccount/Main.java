package Practice818.BankAccount;

import java.util.Scanner;

abstract class Main {
    static Scanner scanner = new Scanner(System.in);
    static BankAccount bankAccount = null;

    public static void main(String[] args) {

        while (true) {
            menu();
            int opera = scanner.nextInt();
            if (!isLegal(opera,1,5)) {
                System.out.println("输入的字符不合法，请重新输入！");
                continue;
            }
            switch (opera) {
                case 1 -> creatAccount();
                case 2 -> deposit();
                case 3 -> withDraw();
                case 4 -> showInfo();
                case 5 -> {
                    System.out.println("退出系统！");
                    return;
                }
            }
        }

    }


    public static void menu() {
        System.out.println("*************************");
        System.out.println("请输入操作：");
        System.out.println("1.创建账户\t2.存款\t3.取款\t4.查询\t5.退出");
        System.out.println("*************************");
    }

    public static void creatAccount() {
        System.out.println("*************************");
        System.out.print("请输入账户类型：");
        System.out.println("1.储蓄账户\t2.支票账户");
        int type = scanner.nextInt();
        if (!isLegal(type,1,2)) {
            System.out.println("输入的字符不合法！");
            return;
        }
        if (type == 1 || type == 2) {
            bankAccount = switch (type) {
                case 1 -> {
                    System.out.println("已选择储蓄账户");
                    yield new SavingsAccount();
                }
                case 2 -> {
                    System.out.println("已选择支票账户");
                    yield new CheckingAccount();
                }
                default -> new BankAccount();
            };
        } else {
            System.out.println("输入字符不合法！");
            return;
        }
        System.out.print("请输入账号号码：");
        int accountNumber = scanner.nextInt();
        System.out.print("请输入首次存款的金额：");
        double balance = scanner.nextDouble();
        bankAccount.setAccountNumber(accountNumber);
        bankAccount.setBalance(balance);
        bankAccount.showInfo();
    }

    public static void deposit() {
        if (!isLegal(bankAccount)) {
            System.out.println("尚未建立账户！");
            return;
        }
        System.out.print("请输入存款金额:");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
    }

    public static void withDraw() {
        if (!isLegal(bankAccount)) {
            System.out.println("尚未建立账户！");
            return;
        }
        System.out.print("请输入取款金额：");
        double amount = scanner.nextDouble();
        bankAccount.withdraw(amount);
    }

    public static void showInfo() {
        if (!isLegal(bankAccount)) {
            System.out.println("尚未建立账户！");
            return;
        }
        bankAccount.showInfo();
    }

    private static boolean isLegal(Object obj) {
        return obj != null;
    }

    private static boolean isLegal(int n, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (n == i) return true;
        }
        return false;
    }

    private static boolean isLegal(int n, int... ints) {
        for (int anInt : ints) {
            if (n != anInt) return false;
        }
        return true;
    }


}
