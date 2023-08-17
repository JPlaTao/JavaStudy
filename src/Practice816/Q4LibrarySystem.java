package Practice816;

import java.util.Scanner;

public class Q4LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        outer: while (true){
            System.out.println("请输入操作：\n1：添加图书\t 2：查找图书\t3：显示所有图书\t4：退出");
            int type = scanner.nextInt();
            switch (type){
                case 1 ->{
                    System.out.print("请输入书名:");
                    String title =scanner.next();
                    System.out.print("请输入作者：");
                    String author = scanner.next();
                    System.out.print("请输入出版年份：");
                    int year = scanner.nextInt();
                    System.out.print("请输入价格：");
                    double price = scanner.nextDouble();
                    Library.addBook(title,author,year,price);
                }
                case 2->{
                    System.out.println("通过什么查找？请输入操作：\n1：书名\t2：作者\t3：出版年份\t4：价格");
                    int opera = scanner.nextInt();
                    switch (opera){
                        case 1->{
                            System.out.println("请输入书名");
                            String title = scanner.next();
                            Library.searchBookByTitle(title);
                        }
                        case 2->{
                            System.out.println("请输入作者");
                            String author = scanner.next();
                            Library.searchBookByAuthor(author);
                        }
                        case 3->{
                            System.out.println("请输入出版年份");
                            int year = scanner.nextInt();
                            Library.searchBookByYear(year);
                        }
                        case 4->{
                            System.out.println("请输入出版年份");
                            double price = scanner.nextDouble();
                            Library.searchBookByPrice(price);
                        }
                        default -> System.out.println("操作数输入错误");
                    }
                }
                case 3->{
                    Library.showBooks();
                }
                case 4->{
                    break outer;
                }
                default -> System.out.println("操作数输入错误");
            }
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

    public void showInfo(){
        System.out.printf("《%s》，作者是：%s，出版年份为：%s年，价格为：%s\n",this.title,
                this.author,this.year,this.price);//拼接输出所有值
    }
}

class Library {
    static Book[] stack = new Book[10];
    static {
        for (int i = 0; i < stack.length; i++) {
            stack[i] = new Book();
        }
    }
    static int count = 0;

    public Library() {

    }

    public static void addBook(String title, String author, int year, double price) {
        Book book = new Book(title, author, year, price);
        stack[count] = book;
        count ++;
    }

    public static void showBooks(){//显示所有图书的方法
        for (int i = 0; i < stack.length; i++) {//for循环遍历存放book对象的数组stack 你的里面是Books
            if (stack[i].title!=null){//如果此数组的title 不为空，则输出此对象的所有值
                stack[i].showInfo();//调用了Book类的方法.showInfo
            }
        }
    }

    public static void searchBookByTitle(String title) {
        for (int i = 0; i < stack.length; i++) {
            if (stack[i].title.equalsIgnoreCase(title)) {
                System.out.println("这本书是《" + stack[i].title + "》,作者是：" + stack[i].author + ",出版年份是" + stack[i].year + "年,价格为：" + stack[i].price);
                return;
            }
            else System.out.println("查无此书");
            return;
        }
    }

    public static void searchBookByAuthor(String author) {
        for (int i = 0; i < stack.length; i++) {
            if (stack[i].author.equalsIgnoreCase(author)) {
                System.out.println("这本书是《" + stack[i].title + "》,作者是：" + stack[i].author + ",出版年份是" + stack[i].year + "年,价格为：" + stack[i].price);
                return;
            }
            else System.out.println("查无此书");
            return;
        }
    }

    public static void searchBookByYear(int year) {
        for (int i = 0; i < stack.length; i++) {
            if (stack[i].year == year) {
                System.out.println("这本书是《" + stack[i].title + "》,作者是：" + stack[i].author + ",出版年份是" + stack[i].year + "年,价格为：" + stack[i].price);
            return;
            }
            else System.out.println("查无此书");
            return;
        }
    }

    public static void searchBookByPrice(double price){
        for (int i = 0; i < stack.length; i++) {
            if (stack[i].price == price){
                System.out.println("这本书是《"+stack[i].title+"》,作者是："+stack[i].author+",出版年份是"+stack[i].year+"年,价格为："+stack[i].price);
            return;
            }
            else System.out.println("查无此书");
            return;
        }
    }
}