package Queues;

public class MyQueueApp {
    public static void main(String[] args) {

    MyQueue<Integer> q=new MyQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        // it take front values and remove it from queue
        System.out.println("q.dequeue() = " + q.dequeue());
        //size control
        System.out.println("q.size() = " + q.size());
        // it take front values and not remove it from queue
        System.out.println("q.peek() = " + q.peek());
        //size control
        System.out.println("q.size() = " + q.size());


    }}
