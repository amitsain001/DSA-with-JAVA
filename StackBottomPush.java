import java.util.*;

public class StackBottomPush {

    // Push at Bottom FUNCTION

    public static void pushatbottom(Stack<Integer> stk, int data) {

        // Base Case 

        if ( stk.isEmpty() ) {
            stk.push(data);
            return;
        }

        // Kaam

        int top = stk.pop();
        pushatbottom(stk, data);
        stk.push(top);
    }

    // Reverse of a String In stack

    public static String reverse(String str) {

        Stack<Character> s = new Stack<>();
        int idx = 0;

        while ( idx < str.length() ) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder("");
        
        while ( !s.isEmpty() ) {
            char curr = s.pop();
            result.append(curr);
        }

        return result.toString();               // toString() is used to convert StringBuilder to string 
    }

    // Reverse Of A STACK 

    public static void stkreverse(Stack<Integer> s) {

        // Base Case 

        if ( s.isEmpty() ) {
            return;
        }

        int top = s.pop();
        stkreverse(s);
        pushatbottom(s, top);

    }

    public static void printstk(Stack<Integer> s) {
        while ( !s.isEmpty() ) {
            System.out.println(s.pop());
        }
    }



    public static void main ( String args[] ) {

        Stack<Integer> stk = new Stack<>();

        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);

        stkreverse(stk);
        printstk(stk);

        // pushatbottom(stk, 5);

        // while ( !stk.isEmpty() ) {
        //     System.out.println(stk.pop());
        // }

        // String s = "abc";

        // String result = reverse(s);
        // System.out.println(result);


    }
    
}
