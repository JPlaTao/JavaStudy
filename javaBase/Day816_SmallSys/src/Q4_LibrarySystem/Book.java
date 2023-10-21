package Q4_LibrarySystem;

public class Book {

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
