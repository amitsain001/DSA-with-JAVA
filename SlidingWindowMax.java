import java.util.* ;

public class SlidingWindowMax {

    static class pairs implements Comparable < pairs > {
        
        int val ;
        int idx ;

        public pairs ( int val, int idx ) {
            this.val = val ;
            this.idx = idx ;
        }

        @Override
        public int compareTo ( pairs p2 ) {
            return p2.val - this.val ;                  // Syntax reversed for descending order sort 
        }
    }

    public static void main ( String args[] ) {

        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 } ;
        int k = 3 ;
        int res[] = new int [ arr.length - k + 1 ] ;

        PriorityQueue<pairs> pq = new PriorityQueue<>();

        for ( int i = 0 ; i < k ; i++ ) {
            pq.add(new pairs(arr[i], i) ) ;
        }

        res[0] = pq.peek().val ;

        for ( int i = k ; i < arr.length ; i++ ) {

            while ( pq.size() > 0 && pq.peek().idx <= ( i-k ) ) {

                pq.remove() ;

            }

            pq.add ( new pairs(arr[i], i) ) ;
            res[i-k+1] = pq.peek().val ;

        }

        for ( int i = 0 ; i < res.length ; i++ ) {

            System.out.print (res[i] + " ") ;

        }

        System.out.println() ;
    }
    
}
