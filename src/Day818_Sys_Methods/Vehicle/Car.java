package Day818_Sys_Methods.Vehicle;

public class Car extends Vehicle{
    private int numDoors;
    public Car(){

    }
    public Car(String brand,int year,int numDoors){
        super(brand,year);
        this.numDoors = numDoors;
    }
    public void displayInfo(){
        System.out.printf("brand:%s,year:%s,numDoors:%s\n",
                this.brand,this.year,this.numDoors);
    }
}
