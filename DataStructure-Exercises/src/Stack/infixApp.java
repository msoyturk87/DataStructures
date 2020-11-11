package Stack;



public class infixApp {

    public static void main(String[] args) {

        // infixToPostFix
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("mystack.infixToPostfix(exp) = " + MyStack.infixToPostfix(exp));

        // infixToPreFix
        exp = "(A-B/C)*(A/K-L)";
        System.out.println("mystack.infixToPrefix(exp) = " + MyStack.infixToPrefix(exp));
    }
}
