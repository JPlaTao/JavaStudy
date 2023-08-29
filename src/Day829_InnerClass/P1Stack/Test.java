package Day829_InnerClass.P1Stack;

public class Test {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println("弹出：");
        System.out.println(stack.pop());


    }


}
