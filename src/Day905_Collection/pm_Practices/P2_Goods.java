package Day905_Collection.pm_Practices;


import java.util.Iterator;
import java.util.Vector;

class Test{
    static Vector goods = new Vector();

    public static void main(String[] args) {
        goods.add(new Goods("鼠标",125.7));
        goods.add(new Goods("圆珠笔",1.5));
        goods.add(new Goods("水杯",10.8));
        goods.add(new Goods("卫生纸",7.6));
        goods.add(new Goods("鼠标垫",19.3));
        goods.forEach((goods)->{
            System.out.println(goods);
        });
        System.out.println(priceAvg());
    }



    public static double priceAvg(){
        Iterator iterator = goods.iterator();
        double avg = 0;
        Goods temp = null;
        while (iterator.hasNext()){
            temp = (Goods) iterator.next();
            avg += temp.getPrice();
        }
        return avg = avg / goods.size();
    }
}




class Goods {
    private String name;

    private double price;

    Goods(){

    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
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
    @Override
    public String toString() {
        return "Goods{" +
                "name: " + name +
                ", price: " + price +
                '}';
    }

}
