package Practice816;

import java.util.Scanner;

public class Q4LibrarySystem {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            menu();
            int type = scanner.nextInt();
            switch (type) {
                case 1 -> {
                    addBook();
                }
                case 2 -> {
                    searchBook();
                }
                case 3 -> {
                    Library.showBooks();
                }
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

class Book {
    String title;
    String author;
    int year;
    double price;

    public Book() {

    }

    public Book(String title, String author, int year, double price) {
        this.author = author;
        this.price = price;
        this.year = year;
        this.title = title;
    }

    public void showInfo() {
        System.out.printf("《%s》，作者是：%s，出版年份为：%s年，价格为：%s\n", this.title,
                this.author, this.year, this.price);//拼接输出所有值
    }
}

class Library {
    static Book[] stack = new Book[10];
    static int count = 0;

    static {
        Book as = new Book("阿衰", "猫小乐", 2002, 19.9);
        Book java = new Book("java面向cv", "gsl", 1996, 36.5);
        Book c = new Book("c语言从入坑到入土", "lq", 1972, 26.8);
        stack[0] = as;
        stack[1] = java;
        stack[2] = c;
        count = 3;
    }

    public Library() {

    }

    public static void addBook(Book book) {
        stack[count] = book;
        count++;
    }

    public static void showBooks() {//显示所有图书的方法
        for (Book book : stack) {//for循环遍历存放book对象的数组stack 你的里面是Books
            if (book != null) {//如果此数组的title 不为空，则输出此对象的所有值
                book.showInfo();//调用了Book类的方法.showInfo
            }
        }
    }

    public static void searchBookByTitle(String title) {
        for (Book book : stack) {
            if(book != null) {
                if (title.equals(book.title)) {
                    System.out.println("这本书是《" + book.title + "》,作者是：" + book.author + ",出版年份是" + book.year + "年,价格为：" + book.price);
                    return;
                }
            }
        }
        System.out.println("查无此书");
    }

    public static void searchBookByAuthor(String author) {
        for (Book book : stack) {
            if (book != null) {
                if (author.equals(book.author)) {
                    System.out.println("这本书是《" + book.title + "》,作者是：" + book.author + ",出版年份是" + book.year + "年,价格为：" + book.price);
                    return;
                }
            }
        }
        System.out.println("查无此书");
    }

    public static void searchBookByYear(int year) {
        for (Book book : stack) {
            if (book!=null) {
                if (book.year == year) {
                    System.out.println("这本书是《" + book.title + "》,作者是：" + book.author + ",出版年份是" + book.year + "年,价格为：" + book.price);
                    return;
                }
            }
        }
        System.out.println("查无此书");
    }

    public static void searchBookByPrice(double price) {
        for (Book book : stack) {
            if (book !=null) {
                if (book.price == price) {
                    System.out.println("这本书是《" + book.title + "》,作者是：" + book.author + ",出版年份是" + book.year + "年,价格为：" + book.price);
                    return;
                }
            }
        }
        System.out.println("查无此书");
    }
}