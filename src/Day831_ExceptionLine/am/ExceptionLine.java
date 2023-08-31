package Day831_ExceptionLine.am;

import java.util.Arrays;

public class ExceptionLine {
    public static void main(String[] args) throws Exception {
        try {
            test2();
        } catch (Exception e) {
            System.out.println(e.getCause().getCause().getCause().getMessage());
            throw new Exception(e);
        }
    }
    static void test0() throws Exception {
        throw new Exception("test0 异常");
    }

    static void test1() throws Exception{
        try{
            test0();
        }catch (Exception e){
            throw new Exception("test1 异常",e);
        }
    }

    static void test2() throws Exception{
        try{
            test1();
        }catch (Exception e1){
            throw new Exception("test2 异常",e1);
        }
    }
}

