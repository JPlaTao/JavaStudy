package pm;

class MyLinked<T> {

    private Node<T> headNode;
    private int size;

    <E> void add(T t){
        Node<T> valueNode = new Node<>();

    }

    class Node<E>{
        E value;
        Node<E> next;

        public Node() {
        }

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
