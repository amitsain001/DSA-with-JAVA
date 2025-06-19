import java.util.*;

public class FractionalKnapsack {

    public static void main( String args[] ) {
        int weight[] = {10, 20, 30 };
        int value[] = {60, 100, 120 };
        int w = 50;

        double ratio[][] = new double[weight.length][2];

        for ( int i = 0; i<weight.length; i++ ) {
            ratio[i][0] = i;                                        // storing index in 2D array 0th column
            ratio[i][1] = ( value[i]/(double)weight[i] ) ;      // Storing Ratio in 2D array 1st column
        }

        // Sorting ratio column in Ascending Order 

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = w;
        int finalval = 0;

        // Taking loop in reverse order coz by default sorting ratio is in ascending order but we need in desc. order

        for ( int i = ratio.length-1; i >= 0; i-- ) {

            int idx = (int)ratio[i][0];

            if ( capacity >= weight[idx] ) {    // includes full item

                capacity -= weight[idx];
                finalval += value[idx];

            } else {
                finalval += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Final Value = " + finalval );
    }
    
}
