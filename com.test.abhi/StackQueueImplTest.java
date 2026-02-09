import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueImplTest {
    Stack<Integer> stack = new Stack<Integer>();
    Deque<Integer> stack2 = new ArrayDeque<Integer>(); //Preffered over Stack implementation
    Queue<Integer> queue = new LinkedList<>();

    
    public static void main(String[] args) {
        StackQueueImplTest stackTest = new StackQueueImplTest();
        System.out.println("Stack LIFO");
        stackTest.testPreferredStackByIntegers();
        System.out.println("Queue FIFO");
        stackTest.testQueueByIntegers();
    }

    private void testPreferredStackByIntegers(){
        stack2.push(10);
        stack2.push(20);
        stack2.push(-10);
        stack2.push(100);

        while(!stack2.isEmpty()){
            System.out.println(stack2.pop());
        }
    }

    private void testQueueByIntegers(){
        queue.add(10);
        queue.add(20);
        queue.add(-10);
        queue.add(100);

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

    private void testStackByIntegers(){
        stack.push(10);
        stack.push(20);
        stack.push(-10);
        stack.push(100);

        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }

    private void testStackByMod(){
        int n = 1;
        while (n > 0) {
            System.out.println("On Stack: "+n % 2);
            stack.push(n % 2);
            n = n / 2;
            System.out.println("N now: "+n);
        }

        for (int digit : stack) {
            System.out.println(digit);
        }

        
    }
}
