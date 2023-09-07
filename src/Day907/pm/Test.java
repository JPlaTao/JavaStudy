package Day907.pm;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

class Test {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        TreeSet treeSetSortByGrand = new TreeSet<>(new Comparator(

        ) {
            @Override
            public int compare(Object o1, Object o2) {
                Game g1 = (Game) o1;
                Game g2 = (Game) o2;
                return g1.getPrice() - g2.getPrice();
            }
        });
        treeSet.add(new Game("sekiro",198,9));
        treeSet.add(new Game("breath of wild",300,10));
        treeSet.add(new Game("god of war",298,9));
        treeSet.add(new Game("god of war",298,10));

        treeSet.forEach(o -> System.out.println(o));

        treeSetSortByGrand.addAll(treeSet);
        System.out.println("按价格排序：");
        treeSetSortByGrand.forEach(o -> System.out.println(o));
    }

}

class Game implements Comparable{
    private String name;
    private int price;
    private double ignGrand;

    public Game() {
    }

    public Game(String name, int price, double ignGrand) {
        this.name = name;
        this.price = price;
        this.ignGrand = ignGrand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getIgnGrand() {
        return ignGrand;
    }

    public void setIgnGrand(double ignGrand) {
        this.ignGrand = ignGrand;
    }



    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", ignGrand=" + ignGrand +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return ignGrand == game.ignGrand && Objects.equals(name, game.name) && Objects.equals(price, game.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, ignGrand);
    }

    @Override
    public int compareTo(Object o) {
        if (o == null){
            throw new NullPointerException();
        }
        if (this.equals(o)){
            return 0;
        }
        if (o instanceof Game game){
            return name.compareTo(game.getName());
        }
        throw new ClassCastException("can not cast class to Game");
    }
}