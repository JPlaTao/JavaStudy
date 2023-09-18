package Animal;

public class SnowPanther extends Animal {
    private String name = "雪豹";
    private String sound = "闭嘴！";
    public SnowPanther() {
    }
    public SnowPanther(String name, String sound) {
        super(name, sound);
    }
    public void makeSound(){
        System.out.println(this.name +" "+this.sound);
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
