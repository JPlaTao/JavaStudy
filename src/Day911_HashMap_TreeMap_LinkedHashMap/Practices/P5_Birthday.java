package Day911_HashMap_TreeMap_LinkedHashMap.Practices;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P5_Birthday {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        Map<String,LocalDate> birthdays = new HashMap<>();

        birthdays.put("Chopin", LocalDate.of(1810,2,22));
        birthdays.put("Bach", LocalDate.of(1685,3,21));
        birthdays.put("Mozart", LocalDate.of(1756,1,27));
        birthdays.put("Beethoven", LocalDate.of(1770,12,16));

        Set<Map.Entry<String, LocalDate>> collect = birthdays.entrySet().stream().filter(new Predicate<Map.Entry<String, LocalDate>>() {
            @Override
            public boolean test(Map.Entry<String, LocalDate> Entry) {
                //LocalDate toDay = LocalDate.now();
                LocalDate toDay = LocalDate.of(1999,2,22);
                return Entry.getValue().getMonthValue() == toDay.getMonthValue()
                        && Entry.getValue().getDayOfMonth() == toDay.getDayOfMonth();
            }
        }).collect(Collectors.toSet());
        collect.forEach(System.out::println);

        Set<Map.Entry<String, LocalDate>> collect1 = birthdays.entrySet().stream().filter(new Predicate<Map.Entry<String, LocalDate>>() {
            @Override
            public boolean test(Map.Entry<String, LocalDate> Entry) {
                //LocalDate toDay = LocalDate.of(2000,LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
                LocalDate toDay = LocalDate.of(2000,1,21);
                LocalDate birthday = LocalDate.of(2000,Entry.getValue().getMonthValue(),Entry.getValue().getDayOfMonth());
//                LocalDate cellingDay =
//                        LocalDate.of(2000,Entry.getValue().getMonthValue(),Entry.getValue().getDayOfMonth()).plusDays(7);
//                LocalDate floorDay =
//                        LocalDate.of(2000,Entry.getValue().getMonthValue(),Entry.getValue().getDayOfMonth()).minusDays(7);
                return birthday.isBefore(toDay.plusDays(7))&&birthday.isAfter(toDay.minusDays(7));
            }
        }).collect(Collectors.toSet());

        collect1.forEach(System.out::println);
    }

}

