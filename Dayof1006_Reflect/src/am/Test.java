package am;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

class Test {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        SimpleFrame.use(new Music("出暖花开去见你","福禄寿",4.33));
    }
}
