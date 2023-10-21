package am_Enum;

import java.util.Random;

enum WeekDay {
    SUNDAY("sun"),MONDAY("mon"),TUESDAY("tue"),
    WEDNESDAY("wed"),THURSDAY("thu"),
    FRIDAY("fri"),SATURDAY("sat");

    private final String shortName;

    WeekDay(){
        shortName = null;
    }
    WeekDay(String shortName){
        this.shortName = shortName;
    }
}

class Test{
    public static void main(String[] args) {
        WeekDay today;
        Random random = new Random();
        int todayI = random.nextInt(7);
        switch (todayI){
            case 0 -> today = WeekDay.SUNDAY;
            case 1->today = WeekDay.MONDAY;
            case 2->today = WeekDay.THURSDAY;
            case 3->today = WeekDay.WEDNESDAY;
            case 4->today = WeekDay.TUESDAY;
            case 5 -> today = WeekDay.FRIDAY;
            default -> today = WeekDay.SATURDAY;
        }

        System.out.println(today);

        switch (today) {
            case SUNDAY -> System.out.println("it's sunday");
            case MONDAY -> System.out.println("it's monday");
            case FRIDAY -> System.out.println("it's friday");
        }

        WeekDay[] days = WeekDay.values();
        for (WeekDay day : days) {
            System.out.println(day);
        }
    }

}