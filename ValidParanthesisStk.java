import java.util.*;

public class ValidParanthesisStk {

    public static boolean validpar(String str) {

        Stack<Character> s = new Stack<>();

        for ( int i = 0; i < str.length(); i++ ) {

            char ch = str.charAt(i);

            if ( ch == '(' || ch == '{' || ch == '[' ) {
                s.push(ch);
            } else {

                if ( s.isEmpty() ) {
                    return false;
                }

                if ( ( s.peek() == '(' && ch ==')' )
                || ( s.peek() == '{' && ch =='}' )
                || ( s.peek() == '[' && ch ==']' ) ) {

                    s.pop();

                } else {
                    return false;
                }
            }
        }
        if ( s.isEmpty() ) {
            return true;
        } else {
            return false;
        }
    }

    // Duplicate Parenthesis Function 

    public static boolean dulpicate( String str ) {

        Stack<Character> s = new Stack<>();

        for ( int i = 0; i< str.length(); i++ ) {

            char ch = str.charAt(i);

            // 2nd Case 

            if ( ch == ')') {
                int count=0;

                while ( s.peek() != '(') {
                    s.pop();
                    count++;
                }

                if ( count < 1 ) {
                    return true;        // Duplicate 
                } else {
                    s.pop();            // Opening pair
                }  
            }

            // 1st case = opening

            else {
                s.push(ch);
            }

        }
        return false;
    }

    public static void main( String args[] ) {

        String str = "((a+b)+a)";
        // System.out.println(validpar(str));

        System.out.println(dulpicate(str));
    }
    
}
