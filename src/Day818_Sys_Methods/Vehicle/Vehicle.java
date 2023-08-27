package Day818_Sys_Methods.Vehicle;

public class Vehicle {
    String brand;
    int year;
    Vehicle(){

    }
    Vehicle(String brand,int year){
        this.brand = brand;
        this.year = year;
    }
    public void displayInfo(){
        System.out.printf("brand:%s,year:%s",this.brand,this.year);
    }
}
