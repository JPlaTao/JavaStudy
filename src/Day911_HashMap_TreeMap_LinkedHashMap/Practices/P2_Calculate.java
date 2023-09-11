package Day911_HashMap_TreeMap_LinkedHashMap.Practices;

import java.util.Arrays;
import java.util.stream.IntStream;

public class P2_Calculate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        IntStream stream = Arrays.stream(nums);
//        System.out.println(stream.sum());
//        System.out.println(stream.min().getAsInt());
        System.out.println(stream.max().getAsInt());
    }
}
