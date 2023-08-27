package Day818_Sys_Methods.Animal;

public class Cat extends Animal {

    private String name = "cat";
    private String sound = "meow";

    public Cat() {
    }

    public Cat(String name, String sound) {
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
