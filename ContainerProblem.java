import java.util.ArrayList;

public class ContainerProblem {

    // Brute Force Method Function

    public static int CalWater(ArrayList<Integer> Height) {

        // Brute Force --- TC = O(n^2)

        int maxwater = 0;

        for ( int i=0; i<Height.size(); i++ ) {
            for ( int j = i+1; j<Height.size(); j++ ) {
                int height = Math.min(Height.get(i), Height.get(j));
                int width = j-i;
                int currwater = height * width;
                maxwater = Math.max(maxwater, currwater);
            }
        }
        return maxwater;
    }


    // 2 Pointer Approach

    public static int storewater( ArrayList<Integer> Height ) {

        int maxwater = 0;
        int lp =0;
        int rp = Height.size()-1;

        while( lp < rp ) {
            int height = Math.min( Height.get(lp), Height.get(rp));
            int width = rp-lp;
            int currwater = height * width ;
            maxwater = Math.max(maxwater, currwater);

            if( Height.get(lp) < Height.get(rp) ) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxwater;

    }

    public static void main( String args[] ) {
        ArrayList<Integer> Height = new ArrayList<>();

        Height.add(1);
        Height.add(8);
        Height.add(6);
        Height.add(2);
        Height.add(5);
        Height.add(4);
        Height.add(8);
        Height.add(3);
        Height.add(7);

       
        System.out.print( storewater(Height) );
        
    }
    
}
