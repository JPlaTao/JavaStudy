package Day828_Abstract.E1_Animal;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo(new Dog("毛旺财"),
                new Cat("苟小白"),
                new Cow("马牛"));
        zoo.makeSound();
    }
}
