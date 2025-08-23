public class MaxMinElementQueriesST {

    static int segtree[] ;

    public static void init ( int n ) {
        segtree = new int[4*n] ;
    }

    public static void buildst ( int stidx , int si , int sj , int arr[] ) {

        // Base Case 

        if ( si == sj ) {
            segtree[stidx] = arr[si] ;
            return ;
        }

        // Kaam 

        int mid = ( si+sj ) / 2 ;
        buildst( 2*stidx+1 , si, mid, arr ) ;
        buildst( 2*stidx+2 , mid+1, sj, arr ) ;

        segtree[stidx] = Math.max ( segtree[2*stidx+1] , segtree[2*stidx+2] );
        
    }

    // Query ( finding Max from given range )

    public static int getmax( int arr[] , int qi , int qj ) {

        int n = arr.length ;
        return getmaxutil( 0, 0, n-1, qi, qj ) ;

    }

    public static int getmaxutil ( int stidx , int si , int sj , int qi , int qj ) {

        if ( si > qj || sj < qi ) {     // No overlapping case 
            return Integer.MIN_VALUE ;
        }

        else if ( si >= qi && sj <= qj ) {  // Complete overlapping case 
            return segtree[stidx] ;
        }

        else {  // Partial overlapping case 
            int mid = ( si + sj ) / 2 ;
            int left = getmaxutil( 2*stidx+1 , si, mid, qi, qj ) ;
            int right = getmaxutil( 2*stidx+2 , mid+1, sj, qi, qj ) ;

            return Math.max(left , right) ;
        }

    }

    // Update Operation 

    public static void update ( int arr[] , int idx , int newval ) {    // O(logn) 

        int n = arr.length ; 
        arr[idx] = newval ;
        updateutil(0, 0, n-1, idx, newval);
    }

    public static void updateutil ( int stidx , int si , int sj , int idx , int newval ) {  

        if ( idx < si || idx > sj ) {
            return ;
        }

        segtree[stidx] = Math.max( segtree[idx], newval ) ;

        if ( si != sj ) {

            int mid = ( si + sj ) / 2 ;
            updateutil( 2*stidx+1, si, mid, idx, newval ) ;
            updateutil( 2*stidx+2, mid+1, sj, idx, newval ) ;

        }

    }

    public static void main ( String args[] ) {

        int arr[] = { 6 , 8 , -1 , 2 , 17 , 1 , 3 , 2 , 4 } ;
        int n = arr.length ;
        init(n);
        buildst(0, 0, n-1, arr);

        // for ( int i = 0 ; i < segtree.length ; i++ ) {
        //     System.out.print ( segtree[i] + " ") ;
        // }

        int max = getmax(arr, 2, 5) ;
        System.out.println ( max ) ;

        update(arr, 2, 20);
        max = getmax(arr, 2, 5) ;
        System.out.println ( max ) ;


    }
    
}
