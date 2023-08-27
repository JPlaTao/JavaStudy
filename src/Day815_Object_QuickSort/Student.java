package Day815_Object_QuickSort;

public class Student {
    String name;
    String gender;
    int age;
    int id;
    double score;
    public String say(){
        return id +"号:"+ name+";性别:"+ gender +";今年"+ age +"岁;这次考了"+ score+"分。";
    }
}
