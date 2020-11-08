package Stack;

public class infixToPrefix {
    public static void main(String[] args) {
        MyStack<Character> mystack=new MyStack<Character>();

        String exp = "(A-B/C)*(A/K-L)";
       System.out.println("mystack.infixToPostfix(exp) = " + mystack.infixToPrefix(exp));
    }
}
