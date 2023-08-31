package Day830_Lambda_Datastrcture;

import java.util.InputMismatchException;

abstract class Queue {
    /**
     * 将元素插入队尾
     *
     * @param element 要插入的元素
     */
    abstract void enqueue(Object element);

    /**
     * 移除并返回队首元素
     * 删除第一个元素，并返回
     *
     * @return 队首元素, 如果队列为空时，返回 null
     */
    abstract Object dequeue();

    /**
     * 返回队首元素，但不移除
     *
     * @return 队首元素
     */
    abstract Object peek();

    /**
     * 检查队列是否为空
     *
     * @return 如果队列为空则返回true，否则返回false
     */
    abstract boolean isEmpty();

    /**
     * 返回队列中的元素个数
     *
     * @return 队列中元素的个数
     */
    abstract int size();
}

class MyQueue extends Queue {

    private Object[] objs;
    private int capacity;
    private int index = 0;

    MyQueue() {
        capacity = 10;
        objs = new Object[capacity];
    }

    MyQueue(int capacity) throws InputMismatchException {
        if (capacity < 0) {
            throw new InputMismatchException("输入的初始容量值不合法");
        }
        this.capacity = capacity;
        objs = new Object[capacity];
    }

    /**
     * 将元素插入到队尾
     *
     * @param element 要插入的元素
     */
    @Override
    void enqueue(Object element) {
        objs[index++] = element;
        if (index == objs.length - 1) {
            grow();
        }
    }

    /**
     * 数组扩容，每次扩两倍
     */
    void grow() {
        Object[] newObjs = new Object[objs.length >> 1];
        System.arraycopy(objs, 0, newObjs, 0, objs.length);
        objs = newObjs;
    }

    /**
     * 删除队首元素，并返回
     *
     * @return 队首元素
     */
    @Override
    Object dequeue() {
        System.arraycopy(objs, 1, objs, 0, objs.length);
        index--;
        return objs[0];
    }

    /**
     * 返回队尾元素
     *
     * @return 队尾元素
     */
    @Override
    Object peek() {
        return objs[index];
    }


    /**
     * 判断是否为空
     * @return 是否为空
     */
    @Override
    boolean isEmpty() {
        return objs[0] == null;
    }

    /**
     * 返回队列中元素数量
     * @return 元素数量
     */
    @Override
    int size() {
        return index;
    }
}


