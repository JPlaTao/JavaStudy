package Practices;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class P1_Concat {
    public static void main(String[] args) {
        String[] str = {"a","b","c"};
        List<String> stringList = Arrays.stream(str).toList();
        Stream<String> stringStream = stringList.stream();

//        Optional optional = stringStream.reduce(new BinaryOperator<String>() {
//            @Override
//            public String apply(String s, String s2) {
//                return s + s2;
//            }
//        });

        Optional optional1 = stringStream.reduce( (s1,s2) -> s1 + s2);
        System.out.println(optional1.get());
    }
}
