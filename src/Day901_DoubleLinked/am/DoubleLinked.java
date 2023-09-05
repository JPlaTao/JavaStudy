package Day901_DoubleLinked.am;

public class DoubleLinked {

    private int size = 0;
    private Node headNode;


    /**
     * 获取链表长度
     * @return 链表长度
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     * @return 是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }


    public boolean contain(Object element){
        Node tempNode = headNode;
        for (int i = 0; i < size; i++) {
            if (element.equals(tempNode.value)){
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }

    /**
     * 删除指定元素
     * @return 是否成功删除
     */
    public boolean remove(Object element){
        if(!contain(element)){
            return false;
        }
        Node tempNode = headNode;
        while (!element.equals(tempNode.value)){
            tempNode = tempNode.next;
        }
        if (tempNode == headNode){
            headNode = tempNode.next;
            return true;
        }
        tempNode.last.next = tempNode.next;
        return true;
    }

    /**
     * 向链表中存值并返回是否成功
     * @param element 要存入的值
     * @return 是否成功存入
     */
    public boolean add(Object element) {
        Node valueNode = new Node(element);
        if (headNode == null) {
            headNode = valueNode;
            size++;
            return true;
        }
        Node tempNode = headNode;
        Node prev = null;
        while (tempNode.next != null) {
            prev = tempNode;
            tempNode = tempNode.next;
        }
        tempNode.last = prev;
        tempNode.next = valueNode;
        tempNode.next.last = tempNode;
        size++;
        return true;
    }

    /**
     * 获取指定下标位置的值
     * @param index 指定下标
     * @return 指定下标位置的值
     */
    public Object get(int index){
        if (index < 0 || index> size){
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
     * @param element 指定的值
     * @return 指定值的下标
     */
    public int indexOf(Object element){
        Node tempNode = headNode;
        for (int i = 0; i < size; i++) {
            if (element.equals(tempNode.value)){
                return i;
            }
            tempNode = tempNode.next;
        }
        return -1;
    }


    /**
     * 将链表中的数据转换成字符串
     * @return 数据字符串
     */
    @Override
    public String toString() {
        String str = "[";
        Node tempNode = headNode;
        while (tempNode.next != null){
            str += tempNode;
            tempNode = tempNode.next;
            if (tempNode.next != null){
                str += ", ";
            }
        }
        return str += ", " + tempNode + "]";
    }

    class Node {
        private Node last;
        private Object value;
        private Node next;

        private Node() {
            this.next = null;
        }

        public Node(Object value) {
            this.value = value;
            this.next = null;
        }

        public Node(Node last, Object value, Node next) {
            this.last = last;
            this.value = value;
            this.next = next;
        }

        public Node getLast() {
            return last;
        }

        public void setLast(Node last) {
            this.last = last;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
