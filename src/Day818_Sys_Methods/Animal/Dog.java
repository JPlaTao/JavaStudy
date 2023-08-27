package Day818_Sys_Methods.Animal;

public class Dog extends Animal {
    private String name = "dog";
    private String sound = "bark";
    public Dog() {
    }

    public Dog(String name,String sound) {
        super(name,sound);
    }

    public void makeSound() {
        System.out.println(this.name +" "+this.sound);
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }


}
