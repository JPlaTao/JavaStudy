package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exe_Stream {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"一");
        map.put(2,"二");
        map.put(3,"三");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        entries.stream().map(new Function<>() {
            @Override
            public Object apply(Map.Entry<Integer, String> entry) {
                return entry.getKey();
            }
        }).collect(Collectors.toSet()).forEach(System.out::println);
    }
}
