package Practice819Weekend.movie_theater;

import java.util.Objects;

public class User {
    private String username;
    private int phone;
    private String password;

    private boolean isAdmin;
    private Movie[] movies ;
    private int moviesCnt;

    {
        movies = new Movie[10];
    }

    public User() {
    }

    public User(String username, int phone, String password) {
        this.username = username;
        this.phone = phone;
        this.password = password;
    }

    public User(String username, int phone, String password,boolean isAdmin) {
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public void addMovies(Movie movie){
        movies[moviesCnt] = movie;
        moviesCnt++;
        if (moviesCnt == movies.length)
            moviesExpansionMovies();
    }

    public void moviesExpansionMovies() {
        Movie[] movies1 = new Movie[movies.length * 2];
        System.arraycopy(movies, 0, movies1, 0, movies.length);
        movies = movies1;
    }

    @Override
    public String toString() {
        return "用户名：" + username +
                ", 手机号：" + phone +
                ", 密码：" + password + getMovies();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return phone == user.phone &&
                Objects.equals(this.username, user.username) &&
                Objects.equals(this.password, user.password);
    }

    public String getMovies(){
        String str = "";
        for (Movie movie : movies) {
            if (movie == null) break;
            str = str + ("\nmovies:\n" + " Name:" + movie.getName() +
                    ",directed by:" + movie.getDirector() +
                    ",release date:" + movie.getDate() +
                    ",price:" + movie.getPrice() +
                    ",ticket count:" + movie.getTicketCount() + ";");
        }
        return str + "\nend";
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMovieTicketCount(){
        return movies[moviesCnt-1].getTicketCount();
    }

    public void setMoviesTickets(int num){
        this.movies[moviesCnt-1].setTicketCount(num);
    }

}
