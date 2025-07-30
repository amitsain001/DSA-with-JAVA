// 0-1 Knapsack Prob 

public class KnapsackDP {

    public static int recursiveknapsack ( int val[] , int wt[] , int W , int n ) {

        // Base case 

        if ( W == 0 || n == 0 ) {
            return 0 ;
        }

        if ( wt[n-1] <= W ) {

            //include 

            int ans1 = val[n-1] + recursiveknapsack(val, wt, W-wt[n-1], n-1) ;

            //Exclude 

            int ans2 = recursiveknapsack(val, wt, W, n-1) ;

            return Math.max ( ans1 , ans2 ) ;
        } else {

            // Exclude 
            return recursiveknapsack(val, wt, W, n-1) ;
        }

    }
    
    public static void main ( String args[] ) {

        int val[] = { 15 , 14 , 10 , 45 , 30  } ;
        int wt[] = { 2 , 5 , 1 , 3 , 4 } ;
        int W = 7 ;

        System.out.println ( recursiveknapsack(val, wt, W, val.length ) ) ;

    }
}
