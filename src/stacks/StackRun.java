package stacks;

/**
 * Created by trierra on 7/22/15.
 */
public class StackRun {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
