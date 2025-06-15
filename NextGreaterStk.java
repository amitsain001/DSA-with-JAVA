import java.util.*;

public class NextGreaterStk {

    public static void main( String args[] ) {

        int arr[] = { 6, 8, 0, 1, 3 };
        Stack<Integer> s = new Stack<>();
        int nxtgreater[] = new int [ arr.length];

        for ( int i = arr.length-1; i>=0; i-- ) {

            // 1 = while loop 

            while ( !s.isEmpty() && arr[s.peek()] <= arr[i] ) {
                s.pop();
            }

            // 2 = if else 

            if ( s.isEmpty() ) {
                nxtgreater[i] = -1;
            } else {
                nxtgreater[i] = arr[s.peek()];
            }
            // 3 = push in stk

            s.push(i);
        }

        for ( int i = 0; i<nxtgreater.length; i++ ) {
            System.out.println(nxtgreater[i]+ " ");
        }
        System.out.println();
    }
    
}
