import java.util.Stack;

public class StackTest {
    
    public static void main(String[] args) {
        int n = 1;

        Stack<Integer> stack = new Stack<Integer>();
        while (n > 0) {
            System.out.println("On Stack: "+n % 2);
            stack.push(n % 2);
            n = n / 2;
            System.out.println("N now: "+n);
        }

        for (int digit : stack) {
            System.out.println(digit);
        }

        System.out.println();
    }
}
