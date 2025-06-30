import java.util.PriorityQueue;

public class PQueue {

    public static void main ( String args[] ) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(3);          // TC = o(logn)
        pq.add(7);
        pq.add(1);
        pq.add(2);
        pq.add(5);

        while ( !pq.isEmpty() ) {

            System.out.println(pq.peek());      // TC = o(1)
            pq.remove();                        // TC = o(logn)
            
        }

    }
    
}
