package Queues;

import java.util.NoSuchElementException;

public class MyQueue<Integer> {

        private class Node {
            private int value;
            private Node next;
            public Node(int value) {
                this.value = value;
            }        }

        private Node front;   // head
        private Node back;    //tail
        private int size;

        //Same with push in Stack
        public void enqueue(int x) {
            Node node = new Node(x);

            if (isEmpty())
                front = back = node;
            else {
                back.next = node;
                back = node;
            }
            size++;
        }

        //Same with Pop in Stack
        public int  dequeue() {
            int x;

            if (front == back)

            {   x=front.value;
                front = back = null;}

            else {
                x=front.value;
                Node second = front.next;
                front.next = null;
                front = second;
            }

            size--;
            return x;
        }

        //Same with Peek in Stack
        public int  peek() { return front.value; }
        private boolean isEmpty() {
            return front == null;
        }
        public int size() {
            return size;
        }



    }


