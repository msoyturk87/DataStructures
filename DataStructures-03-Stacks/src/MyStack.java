import java.util.NoSuchElementException;
public class MyStack<T> {

        private class Node {
            private T value;
            private Node next;

            public T getValue() {
                return value;
            }

            public void setValue(T value) {
                this.value = value;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node(T value) {
                this.value = value;
            }
        }

        private Node bottom;
        private Node top;
        private int size;

        public void push (T item) {
            var node = new Node(item);

            if (isEmpty())
                bottom = top = node;
            else {
                top.next = node;
                top = node;
            }

            size++;
        }



        public boolean isEmpty() {
            return bottom == null;
        }

        public T peek() {
            return top.value;
        }

        public T pop() {
            Node peekNode;
            if (isEmpty())
                throw new NoSuchElementException();

            if (top == bottom)
            {peekNode=bottom;
                bottom = top = null;}
            else {
                peekNode=top;
                var previous = getPrevious(top);
                top= previous;
                top.next = null;
            }

            size--;
            return peekNode.value;
        }

        private Node getPrevious(Node node) {
            var current = bottom;
            while (current != null) {
                if (current.next == node) return current;
                current = current.next;
            }
            return null;
        }

        public int size() {
            return size;
        }

        public char[] toArray() {
            char[] array = new char[size];
            var current = bottom;
            var index = 0;
            while (current != null) {
                array[index++] = (char)current.value;
                current = current.next;
            }

            return array;
        }

    public  int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    // The main method that converts
    // given infix expression
    // to postfix expression.
     String infixToPostfix(String exp)
    {
        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        MyStack<Character> stack = new MyStack<>();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;

                // If the scanned character is an '(',
                // push it to the stack.
            else if (c == '(')
                stack.push(c);

                //  If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() &&
                        stack.peek() != '(')
                    result += stack.pop();

                stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c)
                        <= Prec(stack.peek())){

                    result += stack.pop();
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

}


