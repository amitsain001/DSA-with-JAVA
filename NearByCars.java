import java.util.PriorityQueue;

public class NearByCars {

    static class points implements Comparable < points > {
        int x;
        int y;
        int distsqr ;
        int idx ;

        public points ( int x, int y, int distsqr, int idx ) {
            this.x = x;
            this.y = y ;
            this.distsqr = distsqr ;
            this.idx = idx ;
        }

        @Override
        public int compareTo ( points p2 ) {
            return this.distsqr - p2.distsqr ;
        }
    }

    public static void main ( String args[] ) {

        int pts[][] = { {3,3}, {5,-1}, {-2,4} } ;
        int k = 2 ;

        PriorityQueue<points> pq = new PriorityQueue<>();

        for ( int i = 0; i < pts.length ; i++ ) {

            int distsqr = pts[i][0] * pts[i][0] + pts[i][1] ;
            pq.add(new points( pts[i][0] , pts[i][1] , distsqr, i) );
            
        }

        for ( int i = 0; i < k; i++ ) {
            System.out.println ("C" + pq.remove().idx);
        }
    }
    
}
