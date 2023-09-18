package Vehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle motorcycle = new Motorcycle("toyota", 1996,true);
        Vehicle car = new Car("Mercedes", 1886, 4);
        motorcycle.displayInfo();
        car.displayInfo();
    }
}
