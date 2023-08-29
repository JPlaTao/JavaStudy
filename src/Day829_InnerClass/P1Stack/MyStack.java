package Day829_InnerClass.P1Stack;

import java.util.Arrays;
import java.util.Objects;

public class MyStack extends Stack {
    private Object[] objects;
    private int index = 0;
    private int capacity = 10;

    public MyStack() {
        objects = new Object[capacity];
    }

    public MyStack(int capacity) {
        if (capacity <= 10) {
            this.capacity = 10;
        }
        this.capacity = capacity;
    }

    @Override
    void push(Object element) {
        if (index == objects.length) dilatation(objects);
        objects[index] = element;
        index++;
    }

    private void dilatation(Object[] objects) {
        Object[] newObjects = new Object[objects.length * 2];
        System.arraycopy(objects, 0, newObjects, 0, objects.length);
        this.objects = newObjects;
    }

    @Override
    Object pop() {
        Object removed = objects[index - 1];
        objects[--index] = null;
        return removed;
    }

    @Override
    Object peek() {
        return objects[index - 1];
    }

    @Override
    boolean isEmpty() {
        return objects[0] == null;
    }

    @Override
    int size() {
        return index;
    }


    @Override
    public String toString() {
        String a = "[";
        for (int i = 0; i != objects.length; i++) {
            a += String.valueOf(objects[i]);
            if (objects[i+1] == null) {
                a += "]";
                return a;
            }
            a +=", ";
        }
        return null;
    }


//    @Override
//    public String toString() {
//        return "MyStack{" +
//                "objects=" + Arrays.toString(objects) +
//                ", index=" + index +
//                ", capacity=" + capacity +
//                '}';
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyStack myStack = (MyStack) o;
        return index == myStack.index && capacity == myStack.capacity && Arrays.equals(objects, myStack.objects);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(index, capacity);
        result = 31 * result + Arrays.hashCode(objects);
        return result;
    }
}
