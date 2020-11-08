package Stack;

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

    // infix to Prefix
    static boolean isOperator(char c)
    {
        return (!(c >= 'a' && c <= 'z') &&
                !(c >= '0' && c <= '9') &&
                !(c >= 'A' && c <= 'Z'));
    }

    // Function to find priority
// of given operator.
    static int getPriority(char C)
    {
        if (C == '-' || C == '+')
            return 1;
        else if (C == '*' || C == '/')
            return 2;
        else if (C == '^')
            return 3;
        return 0;
    }

    // Function that converts infix
// expression to prefix expression.
    static String infixToPrefix(String infix)
    {
        // stack for operators.
        MyStack<Character> operators = new MyStack<Character>();

        // stack for operands.
        MyStack<String> operands = new MyStack<String>();

        for (int i = 0; i < infix.length(); i++)
        {

            // If current character is an
            // opening bracket, then
            // push into the operators stack.
            if (infix.charAt(i) == '(')
            {
                operators.push(infix.charAt(i));
            }

            // If current character is a
            // closing bracket, then pop from
            // both stacks and push result
            // in operands stack until
            // matching opening bracket is
            // not found.
            else if (infix.charAt(i) == ')')
            {
                while (!operators.isEmpty() &&
                        operators.peek() != '(')
                {

                    // operand 1
                    String op1 = operands.peek();
                    operands.pop();

                    // operand 2
                    String op2 = operands.peek();
                    operands.pop();

                    // operator
                    char op = operators.peek();
                    operators.pop();

                    // Add operands and operator
                    // in form operator +
                    // operand1 + operand2.
                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }

                // Pop opening bracket
                // from stack.
                operators.pop();
            }

            // If current character is an
            // operand then push it into
            // operands stack.
            else if (!isOperator(infix.charAt(i)))
            {
                operands.push(infix.charAt(i) + "");
            }

            // If current character is an
            // operator, then push it into
            // operators stack after popping
            // high priority operators from
            // operators stack and pushing
            // result in operands stack.
            else
            {
                while (!operators.isEmpty() &&
                        getPriority(infix.charAt(i)) <=
                                getPriority(operators.peek()))
                {

                    String op1 = operands.peek();
                    operands.pop();

                    String op2 = operands.peek();
                    operands.pop();

                    char op = operators.peek();
                    operators.pop();

                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }

                operators.push(infix.charAt(i));
            }
        }

        // Pop operators from operators
        // stack until it is empty and
        // operation in add result of
        // each pop operands stack.
        while (!operators.isEmpty())
        {
            String op1 = operands.peek();
            operands.pop();

            String op2 = operands.peek();
            operands.pop();

            char op = operators.peek();
            operators.pop();

            String tmp = op + op2 + op1;
            operands.push(tmp);
        }

        // Final prefix expression is
        // present in operands stack.
        return operands.peek();
    }

}


