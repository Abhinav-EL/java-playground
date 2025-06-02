import java.util.PriorityQueue;

/**
 * PQ tests to see how traversal happens. PQ only keep tracks of the biggest/smallest element at the root.
 * https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html
 */
public class PriorityQueueTest{
    public static void main(String[] args){
        //System.out.println("Hello World!");

        PriorityQueueTest test = new PriorityQueueTest();
        test.testIntegerPQ();
        test.testOrderedClass();
    }

    private void testIntegerPQ(){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.offer(10);
        queue.offer(5);
        queue.offer(6);
        queue.offer(60);

        for(Integer e : queue){
            System.out.println("Value: "+ e);
        }
    }

    /**
     * Eventhough a Comparable is provided, PQ only keeps track of the highest/lowest value.
     * The Iterator does not traverese things in order.
     */
    private void testOrderedClass(){
        PriorityQueue<OrderedClass> queue = new PriorityQueue<OrderedClass>();
        queue.offer(new OrderedClass("b", 10));
        queue.offer(new OrderedClass("z", 30));
        queue.offer(new OrderedClass("a", 50));
        queue.offer(new OrderedClass("c", -1));
        
        for(OrderedClass e : queue){
            System.out.println("Value: "+ e);
        }

        System.out.println("Value should be a : "+ queue.poll());
        System.out.println("Value should be b :  "+ queue.poll());
        System.out.println("Value should be c : "+ queue.poll());
        System.out.println("Value should be z : "+ queue.poll());
    }

    private class OrderedClass implements Comparable<OrderedClass>{
        String key;
        Integer val;

        OrderedClass(String key, Integer val){
            this.key = key;
            this.val = val;
        }

        public int compareTo(OrderedClass otherObj){
            // Confirm that o is type of OrderedClas
            return this.key.compareTo(otherObj.key);
        }

        public String toString(){
            return this.key +" - " + this.val;
        }
    }
}
