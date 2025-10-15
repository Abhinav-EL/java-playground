public class StacksAndQueues {
    // Stack is LIFO
    class Stack{
        private Node head;

        public void push(String val){
            Node newNode = new Node(val);
            if(head==null){
                head = newNode;
            } else {
                Node temp = head;
                newNode.prev = temp;
                head = newNode;
            }
        }

        public String pop(){
            if(head==null){
                return null;
            } else {
                String temp = head.val;
                head = head.prev;
                return temp;
            }
        }

    }

    class Node {
        String val;
        Node prev;
        
        Node(String val){
            this.val = val;
        }

        public String toString(){
            return "Value: "+ val;
        }
    }

    // Queue is FIFO
    class Queue{
       private Node head, tail;

       public void enqueue(String val){
            Node newNode = new Node(val);
            if(isEmpty()){
                head = newNode;
                tail = newNode;
            } else {
                Node currentTail = tail;
                currentTail.prev = newNode;
                tail = newNode;
            }
       }

       public String dequeue(){
            if(isEmpty()){
                return null;
            } else {
                String currentHeadVal = head.val;
                head = head.prev;
                return currentHeadVal;
            }
       }

       public boolean isEmpty(){
        return head == null;
       }
    }

    public static void main(String[] args) {
        //Stacks FIFO
        StacksAndQueues sq = new StacksAndQueues();
        Stack stack = sq.new Stack();
        stack.push("A");
        stack.push("D");
        System.out.println("Pop D: "+stack.pop());
        System.out.println("Pop A: "+stack.pop());
        System.out.println("Pop null: "+stack.pop());

        //Queue LIFO
        Queue queue = sq.new Queue();
        queue.enqueue("A");
        queue.enqueue("AA");
        System.out.println("Pop A: "+queue.dequeue());
        System.out.println("Pop AA: "+queue.dequeue());
        System.out.println("Pop null: "+queue.dequeue());
    }
}
