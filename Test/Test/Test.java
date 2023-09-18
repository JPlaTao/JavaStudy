package Test;

public class Test {
    public static void main(String[] args) {
        
    }
    static void func(){
    }
    final void func2(){

    }
    static void func2(int i){

    }
}
class Test1 extends Test{
    //final修饰的方法不能被重写
//    final void func2(){}
}

final class TestFinal{

}

//final类不能被继承
//class TestFinalExtends extends TestFinal{
//}
