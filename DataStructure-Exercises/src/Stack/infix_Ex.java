package Stack;

public class infix_Ex {

    public static void main(String[] args) {
        MyStack<Character> mystack=new MyStack<Character>();

        // infixToPostFix
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("mystack.infixToPostfix(exp) = " + mystack.infixToPostfix(exp));

        // infixToPreFix
        exp = "(A-B/C)*(A/K-L)";
        System.out.println("mystack.infixToPostfix(exp) = " + mystack.infixToPrefix(exp));
    }
}
