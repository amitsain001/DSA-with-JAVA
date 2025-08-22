public class SegmentTree {

    static int segtree[] ;

    public static void init ( int n ) {
        segtree = new int[ 4*n ] ;
    }

    public static int buildst ( int arr[] , int stidx , int start , int end ) {

        // Base Case 

        if ( start == end ) {
            segtree[stidx] = arr[start] ;
            return arr[start] ;
        }

        int mid = ( start + end ) / 2 ;

        buildst( arr, 2*stidx+1, start, mid ) ;
        buildst(arr, 2*stidx+2, mid+1, end) ;
        segtree[stidx] = segtree[2*stidx+1] + segtree[2*stidx+2] ;

        return segtree[stidx] ;
    }

    // Query Sum Function ( Subset Sum )

    public static int findsumutil ( int stidx , int si , int sj , int qi , int qj ) {

        if ( si >= qj || sj <= qi ) {   // Non Overlapping
            return  0 ;
        }

        else if ( qi <= si && qj >= sj ) {      // Overlapping
            return segtree[stidx] ;
        } 

        else {      // Partial Overlapping

            int mid = ( si+sj ) / 2 ;
            int left = findsumutil( 2*stidx+1, si, mid, qi, qj ) ;
            int right = findsumutil( 2*stidx+2, mid+1, sj, qi, qj ) ;
            return left + right ;

        }

    }

    public static int findsum ( int arr[] , int qi , int qj ) {

        int n = arr.length ;
        return findsumutil(0, 0, n-1, qi, qj) ;

    }

    // Update Operation function 

    public static void updateinst ( int stidx , int si , int sj , int idx ,int diff ) {     // O(logn)

        if ( idx < si || idx > sj ) {
            return ;
        }

        segtree[stidx] += diff ;

        if ( si != sj ) {

            int mid = ( si + sj ) / 2 ;
            updateinst( 2*stidx+1 ,si , mid, idx, diff) ;   // left
            updateinst( 2*stidx+2 ,mid+1 , sj, idx, diff) ; // right

        }
    }

    public static void update ( int arr[] , int newval , int idx ) {

        int n = arr.length ;
        int diff = newval - arr[idx] ;
        arr[idx] = newval ;

        updateinst(0, 0, n-1, idx, diff) ;

    }

    // Main Function

    public static void main ( String args[] ) {
        
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 } ;
        int n = arr.length ;

        init(n);
        buildst(arr, 0, 0, n-1) ;

        // for ( int i = 0 ; i < segtree.length ; i++ ) {

        //     System.out.print(segtree[i] + " ") ;

        // }

        System.out.println () ;
        System.out.println ( "Total sum for given query : " + findsum ( arr, 2, 5 ) ) ;

        update(arr, 2, 2) ;
        System.out.println ( "Total sum for given query after updation : " + findsum ( arr, 2, 5 ) ) ;

    }
    
}
