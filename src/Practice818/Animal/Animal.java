package Practice818.Animal;

public class Animal {
    private String name;
    private String sound;

    public Animal() {
    }

    public Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

//    public void makeSound() {
//        System.out.println(this.name +" "+this.sound);
//    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getName() {
        return name;
    }
}
