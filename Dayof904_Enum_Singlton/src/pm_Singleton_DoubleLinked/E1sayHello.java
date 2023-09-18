package pm_Singleton_DoubleLinked;

import java.time.LocalTime;

enum HelloSayer {
    MORNING("good morning"), NOON("good noon"), AFTER_NOON("good after noon"),
    EVENING("good evening"), NIGHT("good night");
    private final String hello;

    HelloSayer(String hello) {
        this.hello = hello;
    }

    String say() {
        return hello;
    }
}

class sayHello {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
//        hour += 10;
        System.out.println("现在时间是："+now);
        if (hour > 6 && hour <= 8) {
            System.out.println(HelloSayer.MORNING.say());
        } else if (hour > 8 && hour <= 11) {
            System.out.println(HelloSayer.NOON.say());
        } else if (hour > 11 && hour <= 18) {
            System.out.println(HelloSayer.AFTER_NOON.say());
        } else if (hour > 18 && hour <= 21) {
            System.out.println(HelloSayer.EVENING.say());
        } else {
            System.out.println(HelloSayer.NIGHT.say());
        }
    }
}
