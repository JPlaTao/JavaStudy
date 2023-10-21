package Practice;

import java.util.Arrays;
import java.util.Random;
//编写一个多线程排序程序，将一个大型数组（或者集合）分成若三部分，
//创建三个线程每个线程对其中一部分进行排序，
//然后主线程(main)等待所有线程完成，最后输出这个数组。
public class P3_ThreadSort {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = fillRandNum(1000);
        int len = arr.length;
        SortThread st1 = new SortThread(arr,0,(int) (len*0.3));
        SortThread st2 = new SortThread(arr,(int) (len*0.3),(int) (len*0.6));
        SortThread st3 = new SortThread(arr,(int) (len*0.6),len);

        st1.start();
        st2.start();
        st3.start();

        st1.join();
        st2.join();
        st3.join();

        System.out.println(Arrays.toString(arr));
    }

    private static int[] fillRandNum(int num){
        int[] arr = new int[num];
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            arr[i] = random.nextInt(0,10000);
        }
        return arr;
    }
}

class SortThread extends Thread{
    private int[] arr;
    private int start;
    private int end;
    SortThread(int[] arr,int start,int end){
        this.arr = arr;
        this.start = start;
        this.end = end;
    }
    @Override
    public void run() {
        Arrays.sort(arr,start,end);
    }
}
