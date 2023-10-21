package Q4_LibrarySystem;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            menu();
            int type = scanner.nextInt();
            switch (type) {
                case 1 -> addBook();
                case 2 -> searchBook();
                case 3 -> Library.showBooks();
                case 4 -> {
                    return;
                }
                default -> System.out.println("操作数输入错误");
            }
        }
    }

    public static void menu(){
        System.out.println("**********************************************************");
        System.out.println("请输入操作：\n1：添加图书\t 2：查找图书\t3：显示所有图书\t4：退出");
        System.out.println("**********************************************************");
    }

    public static void addBook(){
        System.out.print("请输入书名:");
        String title = scanner.next();
        System.out.print("请输入作者：");
        String author = scanner.next();
        System.out.print("请输入出版年份：");
        int year = scanner.nextInt();
        System.out.print("请输入价格：");
        double price = scanner.nextDouble();
        Book book = new Book(title, author, year, price);
        Library.addBook(book);
        System.out.println("添加成功");
    }

    public static void searchBook(){
        System.out.println("通过什么查找？请输入操作：\n1：书名\t2：作者\t3：出版年份\t4：价格");
        int opera = scanner.nextInt();
        switch (opera) {
            case 1 -> {
                System.out.println("请输入书名");
                String title = scanner.next();
                Library.searchBookByTitle(title);
            }
            case 2 -> {
                System.out.println("请输入作者");
                String author = scanner.next();
                Library.searchBookByAuthor(author);
            }
            case 3 -> {
                System.out.println("请输入出版年份");
                int year = scanner.nextInt();
                Library.searchBookByYear(year);
            }
            case 4 -> {
                System.out.println("请输入出版年份");
                double price = scanner.nextDouble();
                Library.searchBookByPrice(price);
            }
            default -> System.out.println("操作数输入错误");
        }
    }

}
