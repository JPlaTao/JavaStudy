package Day819_Weekend.movie_theater;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static User currentUser;


    /**
     * 主界面
     *
     * @param args Main方法
     */
    public static void main(String[] args) {
        while (true) {
            menu();
            int opera = scanner.nextInt();
            switch (opera) {
                case 1 -> selectMovie();
                case 2 -> showAllMovies();
                case 3 -> login(true);
                case 4 -> login(false);
                case 5 -> userSignUp();
                case 0 -> {
                    System.out.println("退出");
                    return;
                }
            }
        }

    }

    /**
     * 主菜单
     */
    public static void menu() {
        System.out.println("**********************************");
        System.out.println("请输入操作：");
        System.out.println("1.查询电影信息");
        System.out.println("2.显示所有电影信息");
        System.out.println("3.管理员登录");
        System.out.println("4.用户登录");
        System.out.println("5.用户注册");
        System.out.println("0.退出");
        System.out.println("**********************************");
    }

    /**
     * 管理员界面
     */
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


    /**
     * 管理员菜单
     */
    public static void adminMenu() {
        System.out.println("**********************************");
        System.out.println("请输入操作：");
        System.out.println("1.新增电影");
        System.out.println("2.删除电影");
        System.out.println("3.修改电影");
        System.out.println("4.查看所有用户信息");
        System.out.println("0.返回上一级");
        System.out.println("**********************************");
    }


    /**
     * 添加电影
     */
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
        System.out.println(newMovie);
    }


    /**
     * 删除电影
     */
    private static void deleteMovie() {
        System.out.println("请输入电影名");
        String name = scanner.next();
        MovieTheater.deleteMovie(name);
    }


    /**
     * 修改电影信息
     */
    private static void modifyMovieInfo() {
        System.out.print("请输入电影名：");
        String name = scanner.next();
        if (MovieTheater.isNotMovie(name))
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


    /**
     * 展示所有用户
     */
    private static void showAllUsers() {
        MovieTheater.showAllUsers();
    }


    /**
     * 用户交互
     */
    public static void userMain() {
        while (true) {
            userMenu();
            int opera = scanner.nextInt();
            switch (opera) {
                case 1 -> modifyUserInfo();
                case 2 -> showUserInfo();
                case 3 -> buyTicket();
                case 0 -> {
                    System.out.println("退出");
                    return;
                }
            }
        }
    }


    /**
     * 用户菜单
     */
    public static void userMenu() {
        System.out.println("**********************************");
        System.out.println("请输入操作：");
        System.out.println("1.修改用户信息");
        System.out.println("2.查询用户信息");
        System.out.println("3.买票");
        System.out.println("0.退出");
        System.out.println("**********************************");
    }

    /**
     * 修改用户信息
     */
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
                currentUser = MovieTheater.modifyUserName(currentUser, newUserName);
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


    /**
     * 买票方法
     */
    private static void buyTicket() {
        //显示所有电影
        showAllMovies();
        //交互
        System.out.print("请输入要购票的电影名：");
        String name = scanner.next();
        System.out.print("请输入要购买的数量：");
        int num = scanner.nextInt();
        //输入合法判断
        if (MovieTheater.isNotMovie(name))
            return;
        //拿下标
        int index = MovieTheater.selectMovieReturnIndex(name);
        //用户电影数组添加
        userAddMovie(index, num);
        //显示此电影
        MovieTheater.showMovie(index);
        //改电影票数量 获取此电影的票数
        int currTickets = MovieTheater.getTicketCount(index);
        //修改票数
        MovieTheater.setTicketCount(currTickets - num, index);
        System.out.println("购买成功");
        MovieTheater.showMovie(index);
    }


    /**
     * 用户电影信息添加
     *
     * @param index 下标
     * @param num   数量
     */
    public static void userAddMovie(int index, int num) {
        Movie movieToAdd = new Movie(
                MovieTheater.getMovie(index).getName(),
                MovieTheater.getMovie(index).getPrice(),
                MovieTheater.getMovie(index).getDirector(),
                MovieTheater.getMovie(index).getDate(),
                num
        );
        currentUser.addMovies(movieToAdd);
        currentUser.setMoviesTickets(num);
        MovieTheater.setUsers(currentUser);
        currentUser = MovieTheater.getUser(currentUser);
    }


    /**
     * 展示用户信息
     */
    private static void showUserInfo() {
        System.out.println(currentUser.toString());
    }

    /**
     * 查询电影
     */
    public static void selectMovie() {
        System.out.println("请输入电影名：");
        String name = scanner.next();
        MovieTheater.selectMovie(name);
    }

    /**
     * 选择电影重载，直接接收电影名查找，用来在方法里调用
     *
     * @param name 接收电影名
     */
    public static void selectMovie(String name) {
        MovieTheater.selectMovie(name);
    }

    /**
     * 展示所有电影
     */
    private static void showAllMovies() {
        MovieTheater.showAllMovies();
    }


    /**
     * 登录方法
     */
    private static void login(boolean isAdmin){
        System.out.print("请输入用户名：");
        String userName = scanner.next();
        System.out.print("请输入密码：");
        String password = scanner.next();
        currentUser = MovieTheater.selectUser(userName,password, isAdmin);
        if (currentUser == null){
            System.out.println("没有找到此用户");
            return;
        }
        System.out.println("登录成功");
    }

    /**
     * 用户注册
     */
    private static void userSignUp() {
        System.out.print("请输入用户名：");
        String adminUserName = scanner.next();
        System.out.print("请输入电话号：");
        int phone = scanner.nextInt();
        System.out.print("请输入密码：");
        String password = scanner.next();
        System.out.println("请再次输入密码");
        String passwordAgain = scanner.next();
        while (!verifyPassword(password,passwordAgain)) {
            System.out.println("密码两次不一致，请重新输入");
            System.out.print("请输入密码：");
            password = scanner.next();
            System.out.println("请再次输入密码");
            passwordAgain = scanner.next();
        }
        User signUpUser = new User(adminUserName, phone, password);
        MovieTheater.addUser(signUpUser);
        System.out.println("注册成功");
    }

    /**
     * 验证手机号是否被注册过
     */
    private static void verifyPhone(int phone){

    }


    /**
     * 验证两次输入的密码是否一致
     */
    private static boolean verifyPassword(String password,String passwordAgain){
        return Objects.equals(password,passwordAgain);
    }



    /**
     * 是否非法判断
     * @param user 接收
     * @return 返回布尔值
     */
    private static boolean isIllegal(User[] user) {
        return user[1] == null;
    }


    //不优雅的代码
    //
    //    /**
    //     * 管理员登录
    //     */
//    private static void loginAdministrator() {
//        System.out.print("请输入管理员用户名：");
//        String adminUserName = scanner.next();
//        System.out.print("请输入管理员电话号：");
//        int phone = scanner.nextInt();
//        System.out.print("请输入管理员密码：");
//        String adminPassword = scanner.next();
//        User loginUser = new User(adminUserName, phone, adminPassword);
//        if (MovieTheater.isUser(loginUser)) {
//            currentUser = loginUser;
//            System.out.println("登录成功");
//            adminMain();
//        } else System.out.println("输入错误");
//    }
//
//    /**
//     * 用户登录 跟管理员登录基本一样，待会改
//     */
//    private static void loginUser(boolean isAdmin) {
//        System.out.print("请输入用户名：");
//        String adminUserName = scanner.next();
//        System.out.print("请输入电话号：");
//        int phone = scanner.nextInt();
//        System.out.print("请输入密码：");
//        String adminPassword = scanner.next();
//        currentUser = MovieTheater.selectUser(adminUserName,adminPassword,isAdmin);
//        if (currentUser == null) {
//            System.out.println("没有此用户");
//            return;
//        }
//
//        System.out.println(currentUser);
//        System.out.println("登录成功");
//        userMain();
//
////        if (MovieTheater.isUser(loginUser)) {
////            currentUser = loginUser;
////            System.out.println("登录成功");
////            userMain();
//    }

}
