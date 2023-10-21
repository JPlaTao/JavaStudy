package Util;

public class List {

    private Object[] arr;

    private int arrCnt = 0;

    private int capacity;

    public List() {
        this(10);
    }

    public List(int capacity) {
        this.capacity = capacity;
        arr = new Object[capacity];
    }

    public void add(Object o) {
        grow();
        arr[arrCnt++] = o;
    }

    /**
     * 根据下标删除数组中的值
     *
     * @param index 接收下标
     */
    public void delete(int index) {
        if (index<0|| index> arr.length) return;
        arr[index] = null;
        arrCnt--;
        if (arrCnt - index >= 0)
            System.arraycopy(arr, index + 1, arr, index, arrCnt - index);
    }

    public Object get(int index) {
        return arr[index];
    }

    public String toString() {
        String str = "List:[";
        for (int i = 0; i < arrCnt; i++) {
            if (i == arrCnt-1){

            }
            str += arr[i].toString();
            str += "\n";
        }
        return str;
    }


    public void grow() {
        if (arrCnt == arr.length) {
            Object[] newArr = new Object[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
    }

    public int length() {
        return arr.length;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
