package Vehicle;

public class Motorcycle extends Vehicle {

    private boolean hasSideCar;

    public Motorcycle() {

    }

    public Motorcycle(String brand, int year,boolean hasSideCar) {
        super(brand, year);
        this.hasSideCar = hasSideCar;
    }
    public void displayInfo(){
        System.out.printf("brand:%s,year:%s,hasSideCar:%s\n",
                this.brand,this.year,this.hasSideCar);
    }

}

