public class EditDistanceDP {

    public static int editdist ( String s1 , String s2 ) {

        int n = s1.length() ;
        int m = s2.length() ;
        int dp[][] = new int[n+1][m+1] ;

        // Initialization 

        for ( int i = 0 ; i < n+1 ; i++ ) {
            for ( int j = 0 ; j < m+1 ; j++ ) {

                if ( i == 0 ) {
                    dp[i][j] = j ;
                }

                if ( j == 0 ) {
                    dp[i][j] = i ;
                }
            }
        }

        // Filling bottom up 

        for ( int i = 1 ; i < n+1 ; i++ ) {
            for ( int j = 1 ; j < m+1 ; j++ ) {

                // Same 
                if ( s1.charAt(i-1) == s2.charAt(j-1) ) {

                    dp[i][j] = dp[i-1][j-1] ;

                } else { // different 

                    int add = dp[i][j-1] + 1 ;     // add
                    int delete = dp[i-1][j] + 1 ;     // delete
                    int replace = dp[i-1][j-1] + 1 ;   // replace

                    dp[i][j] = Math.min( add, Math.min(delete, replace) ) ;
                }
            }
        }
        return dp[n][m] ;
    }

    public static void main ( String args[] ) {

        String s1 = "intention" ;
        String s2 = "execution" ;

        System.out.println ( editdist(s1, s2) ) ;
    }
    
}
