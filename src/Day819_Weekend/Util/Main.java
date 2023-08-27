package Day819_Weekend.Util;

import Day819_Weekend.movie_theater.Movie;

public class Main {
    public static void main(String[] args) {
        List movies = new List();
        List users = new List();
        movies.add(new Movie("蜘蛛侠：纵横宇宙",
                26, "乔伊姆",
                20230602, 31));
        movies.add(new Movie("天空之城",
                25.8, "宫崎骏",
                20230601,23));
        movies.add(new Movie("超级马里奥",
                26.6, "亚伦", 20230405,
                85));
        System.out.println(movies);

        movies.delete(1);
        System.out.println(movies);

        Movie mv = (Movie) movies.get(1);
        System.out.println(mv);
        System.out.println();
        System.out.println(movies);
    }
}
