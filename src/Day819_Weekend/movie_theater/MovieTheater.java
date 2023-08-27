package Day819_Weekend.movie_theater;

import java.util.Objects;

public class MovieTheater {
    static private Movie[] movies;
    static private User[] users;
    static private int usersCnt;
    static private int moviesCnt;

    static {
        movies = new Movie[10];
        users = new User[10];
        users[0] = new User("admin", 1234567891, "root",true);
        usersCnt =1;

        movies[0] = new Movie("蜘蛛侠：纵横宇宙", 26, "乔伊姆", 20230602,31);
        movies[1] = new Movie("天空之城", 25.8, "宫崎骏", 20230601,23);
        movies[2] = new Movie("超级马里奥", 26.6, "亚伦", 20230405,85);
        movies[3] = new Movie("流浪地球2", 32.5, "郭帆", 20230122,32);
        sortMovies();
        moviesCnt = 4;
    }

    public MovieTheater() {

    }


    public static void moviesExpansionMovies() {
        Movie[] movies1 = new Movie[movies.length * 2];
        System.arraycopy(movies, 0, movies1, 0, movies.length);
        movies = movies1;
    }

    public static void usersExpansion() {
        User[] users1 = new User[users.length * 2];
        System.arraycopy(users, 0, users1, 0, users.length);
        users = users1;
    }

    public static void selectMovie(String name) {
        for (Movie movie : movies) {
            if (movie == null) return;
            if (movie.getName().equals(name)/*Objects.equals(movie.getName(), name)*/) {
                System.out.println(movie.toString());
            }
        }
        System.out.println("没有找到此电影");
    }

    public static void showMovie(int index){
        System.out.println(movies[index].toString());
    }

    public static int selectMovieReturnIndex(String name) {
        for (int i = 0; i < moviesCnt; i++) {
            if (movies[i].getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public static boolean isNotMovie(String name){
        for (Movie movie : movies) {
            if (movie == null) return true;
            if (movie.getName().equals(name)/*Objects.equals(movie.getName(), name)*/) {
                return false;
            }
        }
        return true;
    }

    public static void sortMovies(){

        for (int i = 0; i < moviesCnt - 1; i++) {
            for (int j = 0; j < moviesCnt - 1 - i; j++) {
                if (movies[j].getDate() < movies[j + 1].getDate()) {
                    Movie temp = movies[j];
                    movies[j] = movies[j + 1];
                    movies[j + 1] = temp;
                }
            }
        }
    }

    public static void showAllMovies() {
        for (Movie movie : movies) {
            if (movie == null) return;
            System.out.println(movie);
        }
    }



    public static void showAllUsers(){
        for (User user : users) {
            if (user == null) return;
            System.out.println(user);
        }
    }


    public static boolean isUser(User loginUser) {
        for (User user : users) {
            if (user == null) return false;
            if (user.equals(loginUser)){
                return true;
            }
        }
        return false;
    }

    public static void addUser(User singUpUser) {
        users[usersCnt] = singUpUser;
        usersCnt++;
        if (users.length == usersCnt)
            usersExpansion();
    }

    public static User selectUser(String name,String password,boolean isAdmin){
        for (int i = 0; i < usersCnt; i++) {
            if (Objects.equals(users[i].getUsername(),name)
            &&  Objects.equals(users[i].getPassword(),password)
            && users[i].isAdmin() == isAdmin){
                return users[i];
            }
        }
        return null;
    }

    /**
     * 修改用户信息，并传值
     */
    public static User modifyUserName(User user, String userName){
        for (int i = 0; i < users.length; i++) {
            if (users[i].equals(user)){
                users[i].setUsername(userName);
                return users[i];
            }
        }
        return null;
    }

    public static void addMovie(Movie newMovie) {
        movies[moviesCnt] = newMovie;
        moviesCnt++;
        if (movies.length == usersCnt)
            moviesExpansionMovies();
    }

    public static void deleteMovie(String name) {
        for (int i = 0; i < movies.length; i++) {
            if (movies[i] == null){
                return;
            }
            if (name.equals(movies[i].getName())) {
                movies[i] = null;
                while (movies[i+1] != null){
                    movies[i] = movies[i+1];
                    i++;
                }
                movies[i] = null;
                usersCnt--;
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("没有此电影");
    }

    public static Movie getMovie(int index){
        return movies[index];
    }

    public static Movie[] getMovies() {
        return movies;
    }

    public static void setMovies(Movie[] movies) {
        MovieTheater.movies = movies;
    }

    public static void setMoviePrice(double newPrice,int index){
        movies[index].setPrice(newPrice);
    }

    public static void setMovieDate(int newDate,int index){
        movies[index].setDate(newDate);
    }

    public static int getTicketCount(int index){
        return movies[index].getTicketCount();
    }

    public static void setTicketCount(int newTickets, int index){
        movies[index].setTicketCount(newTickets);
    }

    public static User[] getUsers() {
        return users;
    }

    public static void setUsers(User user) {
        for (int i = 0; i < usersCnt; i++) {
            if (users[i].equals(user)){
                users[i] = user;
            }
        }
    }


    public static User getUser(User user){
        for (int i = 0; i < usersCnt; i++) {
            if (users[i].equals(user))
                return users[i];
        }
        return null;
    }

    public static void setUsers(User[] users) {
        MovieTheater.users = users;
    }
}
