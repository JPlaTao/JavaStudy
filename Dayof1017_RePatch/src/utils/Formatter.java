package utils;

import java.text.SimpleDateFormat;

public class Formatter {
    public static long toMB(long bytes) {
        return (long)(bytes / 1024.0);
    }

    public static String formattedDateTime(long timeTemp) {
        SimpleDateFormat sdf = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        return sdf.format(timeTemp);
    }

}
