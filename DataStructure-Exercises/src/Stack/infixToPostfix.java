package Stack;

public class infixToPostfix {

    public static void main(String[] args) {
        MyStack<Character> mystack=new MyStack<Character>();

        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("mystack.infixToPostfix(exp) = " + mystack.infixToPostfix(exp));
    }
}
