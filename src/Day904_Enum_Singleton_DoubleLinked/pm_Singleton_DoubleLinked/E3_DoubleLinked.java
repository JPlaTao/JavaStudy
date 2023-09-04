package Day904_Enum_Singleton_DoubleLinked.pm_Singleton_DoubleLinked;

class DoubleLinked {
    private Node headNode;
    private Node tailNode;
    private int size = 0;

    /**
     * 获取双链表长度
     *
     * @return 长度
     */
    public int getSize() {
        return size;
    }


    /**
     * 判断链表是否为空
     *
     * @return 链表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向双链表中添加值。
     *
     * @param element 要添加的值
     * @return 返回是否添加成功
     */
    public boolean add(Object element) {
        Node valueNode = new Node(tailNode, element, null);
        if (headNode == null) {
            headNode = valueNode;
            tailNode = headNode;
            size++;
            return true;
        }
        tailNode.next = valueNode;
        tailNode = valueNode;
        size++;
        return true;
    }

    /**
     * 判断是否包含指定值
     *
     * @param element 指定值
     * @return 是否包含指定值
     */
    public boolean contain(Object element) {
        Node tempNode = headNode;
        for (int i = 0; i < size; i++) {
            if (element.equals(tempNode.value)) {
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }


    /**
     * 移除头节点
     * @return 头节点值
     */
    public Object removeHeadNode(){
        Node tempNode = headNode;
        headNode = headNode.next;
        size--;
        return tempNode.value;
    }

    /**
     * 移除尾节点
     * @return 尾节点值
     */
    public Object removeTailNode(){
        Node tempNode = tailNode;
        tailNode.prev.next = null;
        tailNode = tailNode.prev;
        size--;
        return tempNode.value;
    }

    /**
     * 删除表中指定的值
     *
     * @param element 指定值
     * @return 被删除的值
     */
    public Object remove(Object element) {
        if (!contain(element)) {
            return null;
        }
        if (element.equals(headNode.value)) {
            return removeHeadNode();
        }
        if (element.equals(tailNode.value)) {
            return removeTailNode();
        }
        Node tempNode = headNode.next;
        while (!element.equals(tempNode.value)) {
            tempNode = tempNode.next;
        }
//        if (tempNode.next == null) {
//            tempNode.prev.next = null;
//            tailNode = tempNode.prev;
//            size--;
//            return true;
//        }
        Object removedValue = tempNode.value;
        tempNode.prev.next = tempNode.next;
        tempNode.next.prev = tempNode.prev;
        size--;
        return removedValue;
    }


    /**
     * 获取指定下标位置的值
     *
     * @param index 指定下标位置
     * @return 指定位置的值, 如果小于0或大于链表长度返回-1;
     */
    public Object valueOf(int index) {
        if (index < 0 || index > size) {
            return -1;
        }
        Node tempNode = headNode;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    /**
     * 获取指定值所在下标
     *
     * @param element 指定值
     * @return 指定值所在下标，如果不存在指定值则返回-1;
     */
    public int indexOf(Object element) {
        Node tempNode = headNode;
        for (int i = 0; i < size; i++) {
            if (element.equals(tempNode.value)) {
                return i;
            }
            tempNode = tempNode.next;
        }
        return -1;
    }

    /**
     * toString
     *
     * @return String
     */
    @Override
    public String toString() {
        String str = "{";
        Node tempNode = headNode;
        while (tempNode.next != null) {
            str += tempNode.toString() + ", ";
            tempNode = tempNode.next;
        }
        return str += tempNode.toString() + "}";
    }

    class Node {
        private Node prev;
        private Object value;
        private Node next;

        Node(Node prev, Object value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}


