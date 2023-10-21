package pm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Exe_Reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Account act1 = new Account();
        Class<?> actClass1 = act1.getClass();

        Class<?> actClass2 = Account.class;

        Class<?> actClass3 = Class.forName(
                "pm.Account");


        System.out.println(actClass1);
        System.out.println(actClass2);
        System.out.println(actClass3);

        Constructor<?> constructor = actClass1.getConstructor();
        System.out.println(constructor.getParameterCount());

        Method getName = actClass1.getMethod("getName");
        String name = getName.getName();
        System.out.println(name);
    }
}
