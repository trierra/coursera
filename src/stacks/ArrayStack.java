package stacks;

/**
 * Created by trierra on 7/22/15.
 */
public class ArrayStack {
    int arr[];
    int N = 0;

    public  ArrayStack(int s){
        arr = new int[s];
    }

    public void push(int e){
        arr[N++] = e;
    }

    int pop(){
        return arr[--N];
    }
}
