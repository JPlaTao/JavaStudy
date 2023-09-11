package Day908_Genericity.pm;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class Exe_Map {
    public static void main(String[] args) {
        Map<Integer, String> map = Map.of(1, "壹", 2, "②", 3, "🌂", 4, "亖", 5, "Ⅴ");

//        //第一种遍历方式：获取 map的键集合，在遍历键集时用map.get()方法通过键找值。
//        //使用 Map 接口的 keySet 方法获取键集合
        Set<Integer> keySet = map.keySet();
//        //values方法可以获取到值集合，但没用
        Collection<String> values = map.values();
        System.out.println(values);//无序；且每次输出的值都不同

        //使用迭代器遍历
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            String value = map.get(key);
            System.out.println(key + "-->" + value);
        }
//        //也可以将迭代器改写成增强for循环的形式
        for (Integer key : keySet) {
            String value = map.get(key);
            System.out.println(key + "-->" + value);
        }


//        //第二种遍历方式：使用 Map接口提供的entrySet()方法获取到键值对集合entrySet
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
//        //使用增强 for循环遍历此集合
        for (Map.Entry<Integer, String> entry : entrySet) {
//            //可以直接输出
//            System.out.println(entry);
            //也可以设置一些格式
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }

//        //同样可以用迭代器
        Iterator<Map.Entry<Integer, String>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            System.out.println(entryIterator.next());
//
        }
//        //第三种遍历方式：Map.forEach()方法
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.println(integer + "-->" + "s");
            }
        });

//        //可以写成如下 lambda表达式：
        map.forEach((i, s) -> System.out.println(i + "-->" + s));

//        map.compute()

    }
}
