package Practice824.P1Marry;

public class Person {
    private String name;
    private Character gender;
    private Integer age;
    private Boolean isMarried;

    public Person(){

    }

    public Person(String name, Character gender,Integer age,Boolean isMarried){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.isMarried = isMarried;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Character getGender(){
        return gender;
    }

    public void setGender(Character gender){
        this.gender = gender;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public Boolean isMarried(){
        return isMarried;
    }

    public void setIsMarried(Boolean isMarried){
        this.isMarried = isMarried;
    }

}

