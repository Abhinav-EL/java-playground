package dsa;
public class AnotherStackQueueTest { 
	public static void main (String[] args) {
        System.out.println("Stacks are LIFO!!!");
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(40);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("Queue are FIFO!!!");
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(40);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
	}

    static class Queue{
        Node head, tail;

        public void enqueue(int val){
            Node newNode = new Node(val);
            if(tail == null){
                head = newNode;
                tail = newNode;
            } else {
                Node currHead = head;
                currHead.next = newNode;
                head = newNode;
            }
        }

        public Integer dequeue(){
            if(tail == null) {
                return null;
            }
            Node currTail = tail;
            tail = tail.next;

            return currTail.val;
        }

        class Node {
            int val;
            Node next;
            
            Node(int newVal){
                this.val = newVal;
            }
        }
    }
  
    static class Stack{
        Node head;
        
        // Push new Node and set prev to Previos head
        public void push(int val){
            Node temp = new Node(val);
            if(head == null) {
                head = temp;
            } else {
                Node currHead = head;
                head = temp;
                temp.prev = currHead;
            }
        }
        
        public Integer pop(){
            if(head == null) return null;
            Node currHead = head;
            head = head.prev;
            return currHead.val;
        }
        
        class Node {
            int val;
            Node prev;
            
            Node(int newVal){
                this.val = newVal;
            }
        }  
    }
}

