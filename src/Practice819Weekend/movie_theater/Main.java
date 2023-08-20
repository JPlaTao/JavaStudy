package Practice819Weekend.movie_theater;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static User currentUser;

    public static void main(String[] args) {
        while (true) {
            menu();
            int opera = scanner.nextInt();
            switch (opera) {
                case 1 -> selectMovie();
                case 2 -> showAllMovies();
                case 3 -> loginAdministrator();
                case 4 -> loginUser();
                case 5 -> userSignUp();
                case 6 -> {
                    System.out.println("退出");
                    return;
                }
            }
        }

    }

    public static void menu() {
        System.out.println("**********************************");
        System.out.println("请输入操作：");
        System.out.println("1.查询电影信息");
        System.out.println("2.显示所有电影信息");
        System.out.println("3.管理员登录");
        System.out.println("4.用户登录");
        System.out.println("5.用户注册");
        System.out.println("6.退出");
        System.out.println("**********************************");
    }

    public static void adminMain() {
        while (true) {
            adminMenu();
            int opera = scanner.nextInt();
            switch (opera) {
                case 1 -> addMovie();
                case 2 -> deleteMovie();
                case 3 -> modifyMovieInfo();
                case 4 -> showAllUsers();
                case 5 -> {
                    System.out.println("退出");
                    return;
                }
            }
        }
    }

    public static void adminMenu() {
        System.out.println("**********************************");
        System.out.println("请输入操作：");
        System.out.println("1.新增电影");
        System.out.println("2.删除电影");
        System.out.println("3.修改电影");
        System.out.println("4.查看所有用户信息");
        System.out.println("5.退出");
        System.out.println("**********************************");
    }

    private static void addMovie() {
        System.out.print("请输入电影名：");
        String name = scanner.next();
        System.out.print("请输入导演：");
        String director = scanner.next();
        System.out.print("请输入上映时间：");
        int date = scanner.nextInt();
        System.out.print("请输入价格：");
        double price = scanner.nextDouble();
        System.out.print("请输入电影票数：");
        int ticketCount = scanner.nextInt();
        Movie newMovie = new Movie(name, price, director, date, ticketCount);
        MovieTheater.addMovie(newMovie);
        MovieTheater.sortMovies();
        System.out.println("添加成功");
        System.out.println(newMovie.toString());
    }

    private static void deleteMovie() {
        System.out.println("请输入电影名");
        String name = scanner.next();
        MovieTheater.deleteMovie(name);
    }

    private static void modifyMovieInfo() {
        System.out.print("请输入电影名：");
        String name = scanner.next();
        if (!MovieTheater.isAMovie(name))
            return;
        selectMovie(name);
        int index = MovieTheater.selectMovieReturnIndex(name);
        System.out.println("要修改什么内容？请输入操作");
        System.out.println("1.价格");
        System.out.println("2.上映时间");
        System.out.println("3.电影票数量");
        int opera = scanner.nextInt();
        switch (opera) {
            case 1 -> {
                System.out.print("请输入价格：");
                double newPrice = scanner.nextDouble();
                MovieTheater.setMoviePrice(newPrice, index);
                System.out.println("修改成功");
                MovieTheater.showMovie(index);
            }
            case 2 -> {
                System.out.print("请输入日期：");
                int newDate = scanner.nextInt();
                MovieTheater.setMovieDate(newDate, index);
                System.out.println("修改成功");
                MovieTheater.showMovie(index);
            }
            case 3 -> {
                System.out.print("请输入电影票数量：");
                int newTickets = scanner.nextInt();
                MovieTheater.setTicketCount(newTickets, index);
                System.out.println("修改成功");
                MovieTheater.showMovie(index);
            }
        }
    }

    private static void showAllUsers() {
        MovieTheater.showAllUsers();
    }

    public static void userMain() {
        while (true) {
            userMenu();
            int opera = scanner.nextInt();
            switch (opera) {
                case 1 -> modifyUserInfo();
                case 2 -> showUserInfo();
                case 3 -> byTicket();
                case 4 -> {
                    System.out.println("退出");
                    return;
                }
            }
        }
    }

    public static void userMenu() {
        System.out.println("**********************************");
        System.out.println("请输入操作：");
        System.out.println("1.修改用户信息");
        System.out.println("2.查询用户信息");
        System.out.println("3.买票");
        System.out.println("4.退出");
        System.out.println("**********************************");
    }

    private static void modifyUserInfo() {
        System.out.println("**********************************");
        System.out.println(currentUser.toString());
        System.out.println("要修改什么?请输入操作：");
        System.out.println("1.用户名");
        System.out.println("2.手机号");
        System.out.println("3.密码");
        System.out.println("**********************************");
        int opera = scanner.nextInt();
        switch (opera) {
            case 1 -> {
                System.out.print("请输入新用户名：");
                String newUserName = scanner.next();
                currentUser.setUsername(newUserName);
                System.out.println("修改成功");
            }
            case 2 -> {
                System.out.print("请输入新手机号：");
                int newPhone = scanner.nextInt();
                currentUser.setPhone(newPhone);
                System.out.println("修改成功");
            }
            case 3 -> {
                System.out.print("请输入新密码：");
                String newPassword = scanner.next();
                currentUser.setPassword(newPassword);
                System.out.println("修改成功");
            }
        }
    }

    private static void byTicket() {
        showAllMovies();
        System.out.print("请输入要购票的电影名：");
        String name = scanner.next();
        System.out.print("请输入要购买的数量：");
        int num = scanner.nextInt();
        if (!MovieTheater.isAMovie(name))
            return;
        int index = MovieTheater.selectMovieReturnIndex(name);
        currentUser.addMovies(MovieTheater.getMovie(index));
        MovieTheater.showMovie(index);
        int currTickets = MovieTheater.getTicketCount(index);
        MovieTheater.setTicketCount(currTickets-num, index);
        System.out.println("购买成功");
        MovieTheater.showMovie(index);
    }

    private static void showUserInfo() {
        System.out.println(currentUser.toString());
    }


    public static void selectMovie() {
        System.out.println("请输入电影名：");
        String name = scanner.next();
        MovieTheater.selectMovie(name);
    }

    public static void selectMovie(String name) {
        MovieTheater.selectMovie(name);
    }


    private static void showAllMovies() {
        MovieTheater.showAllMovies();
    }

    private static void loginAdministrator() {
        System.out.print("请输入管理员用户名：");
        String adminUserName = scanner.next();
        System.out.print("请输入管理员电话号：");
        int phone = scanner.nextInt();
        System.out.print("请输入管理员密码：");
        String adminPassword = scanner.next();
        User loginUser = new User(adminUserName, phone, adminPassword);
        if (MovieTheater.isUser(loginUser)) {
            System.out.println("登录成功");
            currentUser = loginUser;
            adminMain();
        } else System.out.println("输入错误");
    }

    private static void loginUser() {
        System.out.print("请输入用户名：");
        String adminUserName = scanner.next();
        System.out.print("请输入电话号：");
        int phone = scanner.nextInt();
        System.out.print("请输入密码：");
        String adminPassword = scanner.next();
        User loginUser = new User(adminUserName, phone, adminPassword);
        if (MovieTheater.isUser(loginUser)) {
            currentUser = loginUser;
            System.out.println("登录成功");
            userMain();
        } else System.out.println("没有此用户或输入错误");
    }

    private static void userSignUp() {
        System.out.print("请输入用户名：");
        String adminUserName = scanner.next();
        System.out.print("请输入电话号：");
        int phone = scanner.nextInt();
        System.out.print("请输入密码：");
        String adminPassword = scanner.next();
        User signUser = new User(adminUserName, phone, adminPassword);
        MovieTheater.addUser(signUser);
        System.out.println("注册成功");
    }


//    private static boolean isIllegal(User[] user) {
//        return user[1] == null;
//    }

}
