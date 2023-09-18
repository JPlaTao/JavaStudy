package E1_Animal;

public abstract class Animal {
    String name;

    Animal(){

    }

    public abstract String makeSound();
}

class Dog extends Animal{

    public Dog(){

    }
    public Dog(String name){
        this.name = name;
    }

    @Override
    public String makeSound() {
        return name+":bark!";
    }
}

class Cat extends Animal{
    public Cat(){

    }
    public Cat(String name){
        this.name = name;
    }

    @Override
    public String makeSound() {
        return name+":meow~";
    }
}

class Cow extends Animal{
    public Cow(){

    }
    public Cow(String name){
        this.name = name;
    }

    @Override
    public String makeSound() {
        return name+":moomoo~";
    }
}
class Zoo{
    Animal zoo[] = new Animal[5];

    Zoo (){

    }
    Zoo(Animal... animals){
        for (int i = 0; i < animals.length; i++) {
            zoo[i] = animals[i];
        }
    }

    public void makeSound(){
        for (Animal animal : zoo) {
            if (animal!= null) System.out.println(animal.makeSound());
        }
    }
}