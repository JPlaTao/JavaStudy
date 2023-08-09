package Practice808;

import java.util.Random;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[10];//声明一个数组arr
        Random random = new Random();//实例化随机数对象
        for (int i = 0; i < arr.length; i++) {//遍历数组arr
            arr[i] = random.nextInt(51)+1;//给arr数组赋随机值
            System.out.print(arr[i] + " ");//一行内输出,每个数后带空格
        }
        System.out.println();//换行
        for (int i = 0; i < arr.length; i++) {//遍历数组arr
            int currentNum = arr[i];//声明一个变量currentNum用来存每次遍历数组时的当前值
            int minIndex = i;//声明一个int变量minIndex用来存最小值下标,并初始化为当前值的下标
            for (int j = i + 1; j < arr.length; j++) {//将数组中的每个数与后面的数一一比较
                minIndex = arr[j] < arr[minIndex]? j:minIndex;//若有一个数比当前最小值更小,则将更小值的下标赋给当前最小值,重复此步,即可找出最小值的下标
            }
            arr[i] = arr[minIndex];//将最小值下标所对应的值赋给数组中的当前值
            arr[minIndex] = currentNum;//将数组中的当前值赋给最小值下标所对换两值 由于应的值 由此交已经有一个存储着数组当前值的变量,因此不需要再声明一个temp变量
        }
        for (int i:arr//foreach遍历输出数组
             ) {
            System.out.print(i + " ");
        }
    }
}
