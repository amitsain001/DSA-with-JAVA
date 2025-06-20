import java.util.*;

public class ChocolaProbGreedy {
    
    public static void main ( String args[] ) {

        // int n = 4, m = 6 ;      //  Rows and Columns Respectively
        Integer hcost[] = { 4, 1, 2 };          // Integer Class is taken coz it makes easy to sort in descending order
        Integer vcost[] = { 2, 1, 3, 1, 4 };


        // Desc. order Sort
        Arrays.sort(hcost, Comparator.reverseOrder());
        Arrays.sort(vcost, Comparator.reverseOrder());

        int hp = 1 , vp = 1;        // hor. and ver. pieces respectively 
        int h = 0, v = 0;           // Hor. and Ver. Pointers respectively
        int cost = 0;

        while ( h < hcost.length && v < vcost.length ) {

            if ( vcost[v] <= hcost[h] ) {
                cost += ( vp * hcost[h] );
                hp++;
                h++;
            } else {
                cost += ( hp * vcost[v] );
                vp++;
                v++;
            }
        }

        // If any cut remains 

        while ( h < hcost.length ) {
            cost += ( vp * hcost[h] );
            hp++;
            h++;
        }

        while ( v < vcost.length ) {
            cost += ( hp * vcost[v] );
            vp++;
            v++;
        }

        System.out.println("Min cost = "+cost);

    }
}
