import java.util.Arrays;

public class ClimbinghStairs {

    // Using Recursion 

    public static int climbingstairs ( int n ) {

        // Base case 

        if ( n == 0 ) {
            return 1 ; 
        }

        if ( n == -1 ) {
            return 0 ;
        }

        // Kaam 

        return climbingstairs(n-1) + climbingstairs(n-2) ;
    }

    // Using Memoization

    public static int climbstairsmemoization ( int n , int ways[] ) {

        if ( n == 0 ) {
            return 1 ;
        }

        if ( n == -1 ) {
            return 0 ;
        }

        ways[n] = climbstairsmemoization(n-1, ways) + climbstairsmemoization( n-2 , ways ) ;
        return ways[n] ;
    }

    // Tabulation Approach 

    public static int tabuclimb ( int n ) {

        int dp[] = new int[n+1] ;
        dp[0] = 1 ;

        for ( int i = 1 ; i <= n ; i++ ) {

            if ( i == 1 ) {
                dp[i] = dp[i-1] ;
            } else {
                dp[i] = dp[i-1] + dp[i-2] ;
            }

        }

        return dp[n] ;
    }

    public static void main ( String args[] ) {

        int n = 5 ;
        System.out.println ( "Using Recursion : " + climbingstairs(n) + " ----> Time Complexity : O( 2^n ) " ) ;

        int ways[] = new int[n+1] ;
        Arrays.fill(ways, -1);              // to insert -1 at all index of ways
        System.out.println ( "Using Memoization : " + climbstairsmemoization(n, ways) + " ----> Time Complexity : O(n)") ;

        System.out.println ( "Using Tabulation : " + tabuclimb(n) + " ----> Time Complexity : O(n)") ;

    }
    
}
