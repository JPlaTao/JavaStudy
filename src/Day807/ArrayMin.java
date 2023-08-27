package Day807;

public class ArrayMin {
    public static void main(String[] args) {
        int[] arr = {43,13,23,65,32};
        int min = arr[0];
        for (int num :arr
             ) {
            if(num < min){
                min = num;
            }
        }
        System.out.println("最小值为："+min);
    }
}
