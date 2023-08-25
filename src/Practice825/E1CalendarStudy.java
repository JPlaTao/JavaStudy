package Practice825;

import java.util.Calendar;

public class E1CalendarStudy {
    public static void main(String[] args) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(1970,1,1);
        int year = calendar.get(Calendar.YEAR);
        System.out.println("年份："+year);//1970
        int month = calendar.get(Calendar.MONTH)+1;
        System.out.println("月份："+month);//1
        
    }
}
