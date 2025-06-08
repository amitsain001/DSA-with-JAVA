import java.util.ArrayList;

public class PairSum1 {

    // 2 pointer Approach - TC = 0(n)

    public static boolean pairsum1 ( ArrayList<Integer> List, int target) {

        int lp =0;
        int rp = List.size()-1;

        while ( lp != rp ) {

            // CASE 1   

            if ( List.get(lp) + List.get(rp) == target ) {
                return true;
            } else if ( List.get(lp) + List.get(rp) < target ) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }
    

    public static void main ( String args[] ) {

        ArrayList<Integer> List = new ArrayList<>();

        List.add(1);
        List.add(2);
        List.add(3);
        List.add(4);
        List.add(5);
        List.add(6);

        int target = 50;

        System.out.print( pairsum1(List, target));
    }
}
