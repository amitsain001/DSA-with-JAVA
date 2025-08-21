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

    public static void main ( String args[] ) {
        
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 } ;
        int n = arr.length ;

        init(n);
        buildst(arr, 0, 0, n-1) ;

        for ( int i = 0 ; i < segtree.length ; i++ ) {

            System.out.print(segtree[i] + " ") ;

        }

    }
    
}
