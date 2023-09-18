package am_Iterator;

import java.util.Iterator;
import java.util.Vector;

class IteratorExe {
    public static void main(String[] args) {
        Vector movies = new Vector();
        movies.add(new Movie("oppenheimer",
                "nolan", "oppenheimer",
                2023721));
        movies.add(new Movie("zootopia",
                "disney", "rabbit",
                20160304));
        movies.add(new Movie("coco", "pixar",
                "miguel", 20171124));


        System.out.println(".forEach()方法输出");
        movies.forEach((obj -> System.out.println(obj)));


        System.out.println("iterator迭代器输出");
        Iterator iterator = movies.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("size + for循环输出");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(movies.get(i));
        }

        System.out.println("增强for循环输出");
        for (Object movie : movies) {
            System.out.println(movie);
        }


//        movies.sort(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                if (o1 instanceof Movie && o2 instanceof Movie){
//                    return ((Movie) o1).getTime()-((Movie) o2).getTime();
//                }
//                return 0;
//            }
//        });
        movies.sort((o1, o2) -> {
            if (o1 instanceof Movie && o2 instanceof Movie) {
                return ((Movie) o1).getTime() - ((Movie) o2).getTime();
            }
            return 0;
        });

        System.out.println("排序后输出");
        movies.forEach((obj -> System.out.println(obj)));


    }
}


class Movie {
    private String name;
    private String director;
    private String mainCharacter;
    private int time;

    public Movie(String name, String director, String mainCharacter, int time) {
        this.name = name;
        this.director = director;
        this.mainCharacter = mainCharacter;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name: '" + name + '\'' +
                ", director: '" + director + '\'' +
                ", mainCharacter: '" + mainCharacter + '\'' +
                ", time: " + time +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMainCharacter() {
        return mainCharacter;
    }

    public void setMainCharacter(String mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}