package Practice819Weekend.movie_theater;

import java.util.Objects;

public class Movie {
    private String name;
    private double price;
    private String director;
    private int date;
    private int ticketCount;

    public Movie() {
    }

    public Movie(String name, double price, String director, int date,int ticketCount) {
        this.name = name;
        this.price = price;
        this.director = director;
        this.date = date;
        this.ticketCount = ticketCount;
    }


    public String toString(){
        return " Name:"+getName()+
                ",directed by:"+ getDirector()+
                ",release date:"+ getDate()+
                ",price:"+ getPrice() +
                ",ticket count:" + getTicketCount();
    }

    public boolean equals(Movie obj) {
        if (this == obj)
            return true;
        return Objects.equals(this.name, obj.name)
                && this.price == obj.price
                && Objects.equals(this.director, obj.director)
                && this.date == obj.date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setTicketCount(int ticketCount){
        this.ticketCount = ticketCount;
    }

    public int getTicketCount(){
        return ticketCount;
    }
}
