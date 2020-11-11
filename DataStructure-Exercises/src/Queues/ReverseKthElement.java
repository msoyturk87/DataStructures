package Queues;

import java.util.Queue;
import java.util.Stack;
public class ReverseKthElement{


    static void reverseQueueFirstKElements(Queue<Integer> queue,int k)
    {
        Stack<Integer> stack = new Stack<>();

        // Push the first K elements to Stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.remove());
        }

        // take from stack to enqueue
        while (!stack.empty()) {
            queue.add(stack.pop());
        }
        // Remove the remaining elements and add them again same queue
        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.remove());
        }
        //Print
        Print(queue);
    }

    static void Print(Queue<Integer> queue)
    {
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }


}