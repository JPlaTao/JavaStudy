package Day911_HashMap_TreeMap_LinkedHashMap.Practices;

import java.util.List;

public class P4_AvgSquare {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7);
        Integer integer = nums.stream().map(n -> n * n).reduce((n1, n2) -> n1 + n2).get();
        System.out.println(integer / nums.size());
    }
}