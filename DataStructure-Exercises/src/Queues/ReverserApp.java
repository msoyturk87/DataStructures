package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class ReverserApp {

    // Driver code
    public static void main(String args[])
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        int k = 4;
        ReverseKthElement.reverseQueueFirstKElements(queue,k);
    }
}
