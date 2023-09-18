package pm_LinkedTable;

import java.util.Objects;

public class LinkedTable {
    private Node headNode;
    private int size = 0;

    LinkedTable() {

    }

    LinkedTable(Object element) {
//        o = element;
    }

    /**
     * 获取链表长度
     *
     * @return 返回记录链表增加次数的size
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否是空的
     *
     * @return 返回是否为空的布尔值
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回链表是否包含某个对象
     *
     * @param o 检查值
     * @return 是否包含o;
     */
    public boolean contains(Object o) {
        Node tempNote = headNode;
        for (int i = 0; i < size; i++) {
            if (o.equals(tempNote.value)) {
                return true;
            }
            tempNote = tempNote.next;
        }
        return false;
    }

    /**
     * 删除某个元素
     *
     * @param element 指定要删除的元素
     * @return 是否删除
     */
    public boolean remove(Object element) {
        if (!contains(element)) {
            return false;
        }
        if (element.equals(headNode.value)) {
            headNode = headNode.next;
            return true;
        }
        Node tempNode = headNode.next;
        while (!element.equals(tempNode.next.value)) {
            tempNode = tempNode.next;
        }
        tempNode.next = tempNode.next.next;
        size--;
        return true;
    }


    /**
     * 向链表中存一个值
     *
     * @param value 接收一个参数并存储
     */
    boolean add(Object value) {
        Node valueNode = new Node(value);
        if (headNode == null) {
            headNode = valueNode;
            size++;
            return true;
        }
        Node tempNode = headNode;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = valueNode;
        size++;
        return true;
    }

    /**
     * 返回指定下标位置的值
     * @param index 指定位置的下标
     * @return 指定位置的值
     */
    public Object valueOf(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        Node tempNode = headNode;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode.value;
    }


    /**
     * 返回指定值的下标
     * @param element 指定值
     * @return 指定值的下标
     */
    public int indexOf(Object element) {
        Node tempNode = headNode;
        for (int i = 0; i < size; i++) {
            if (element.equals(tempNode.value)){
                return i;
            }
            tempNode = tempNode.next;
        }
        return -1;
    }

    @Override
    public String toString() {
        String str = "[";
        Node tempNode = headNode;
        while (tempNode.next != null) {
            str += tempNode.toString();
            tempNode = tempNode.next;
            if (tempNode.next != null) {
                str += ", ";
            }
        }
        return str += ", " + tempNode + "]";
    }

    public class Node {
        private Object value;
        private Node next;

        Node() {
        }

        Node(Object value) {
            this.value = value;
            this.next = null;
        }

        Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkedTable that = (LinkedTable) o;
        return size == that.size && Objects.equals(headNode, that.headNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(headNode, size);
    }
}
