public class FibonacciUsingDP {

    // Fibonacci using memoization

    public static int fibonacci ( int n , int f[] ) {

        // Base Case

        if ( n == 0 || n == 1 ) {
            return n ;
        }

        // Kaam

        if ( f[n] != 0 ) {      // Already calculated
            return f[n] ;
        }

        f[n] = fibonacci(n-1, f) + fibonacci(n-2, f) ;
        return f[n] ;
    }

    // Fibonacci using tabulation

    public static int fibbtabulation ( int n ) {

        int dp[] = new int[n+1] ;

        dp[0] = 0 ; 
        dp[1] = 1 ;

        for ( int i = 2 ; i <= n ; i++ ) {
            dp[i] = dp[i-1] + dp[i-2] ;
        }

        return dp[n] ;
    }
    
    public static void main ( String args[] ) {

        int n = 7 ;
        // int f[] = new int[n+1] ;        // By default at all index 0 stored 
        // System.out.println ( fibonacci(n , f) ) ;

        System.out.println ( fibbtabulation(n) ) ;
    }
}
