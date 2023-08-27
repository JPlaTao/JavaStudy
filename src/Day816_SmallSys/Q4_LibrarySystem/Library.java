package Day816_SmallSys.Q4_LibrarySystem;

public class Library {
    static Book[] stack = new Book[10];
    static int count;

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
            if (book != null) {
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
            if (book != null) {
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
            if (book != null) {
                if (book.price == price) {
                    System.out.println("这本书是《" + book.title + "》,作者是：" + book.author + ",出版年份是" + book.year + "年,价格为：" + book.price);
                    return;
                }
            }
        }
        System.out.println("查无此书");
    }
}
