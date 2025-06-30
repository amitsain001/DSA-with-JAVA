import java.util.PriorityQueue;

public class PQforObj {

    static class Students implements Comparable<Students> {
        
        String name;
        int rank;

        public Students ( String name, int rank ) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Students s2) {
            return this.rank - s2.rank ;
        }
    }

    public static void main ( String args[] ) {

        PriorityQueue<Students> pq = new PriorityQueue<>();

        pq.add ( new Students("Karan", 5)) ;
        pq.add ( new Students("Amit", 1)) ;
        pq.add ( new Students("Mohit", 3)) ;
        pq.add ( new Students("Humu", 2)) ;
        pq.add ( new Students("Deepu", 10)) ;

        while ( !pq.isEmpty() ) {
            System.out.println ( pq.peek().name + " -> " + pq.peek().rank);
            pq.remove();
        }

    }
    
}
