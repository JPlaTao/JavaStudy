package Day911_HashMap_TreeMap_LinkedHashMap.pm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;

public class Exe_Properties {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("strength","43");
        properties.setProperty("speed","25");
        LinkedList linkedList = new LinkedList<>();
        linkedList.add(1);
        properties.put("attack",66);

        String strength = properties.getProperty("strength");
        String speed = properties.getProperty("speed");

        int att = Integer.parseInt(properties.getProperty("attack"));

        System.out.println("力量：" + strength);
        System.out.println("速度：" + speed);
    }
}
