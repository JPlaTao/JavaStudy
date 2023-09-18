class Cat {
    String color;
    String breed;

    public Cat(){

    }
    public Cat(String color,String breed){
        this.color = color;
        this.breed = breed;
    }

    public void eat() {
        System.out.println(this.color + "的" + this.breed + "正在吃鱼....");
    }

    public void catchMouth() {
        System.out.println(this.color + "的" + this.breed + "正在逮老鼠....");
    }
}

class Dog{
    String color;
    String breed;
    public Dog(){

    }
    public Dog(String color,String breed){
        this.color = color;
        this.breed = breed;
    }
    public void eat() {
        System.out.println(this.color + "的" + this.breed + "正在啃骨头....");
    }

    public void watchingHome() {
        System.out.println(this.color + "的" + this.breed + "正在看家....");
    }
}
public class Pet {
    public Pet() {
    }

    @Override
    public String toString() {
        return "Pet{}";
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
    }
}