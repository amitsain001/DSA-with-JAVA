import java.util.ArrayList;

public class PairSum2 {

    // 2 POINTER APPROACH - TC = 0(n) 

    public static boolean solvepairsum2(ArrayList<Integer> list, int target) {

        int bp = -1;
        int n = list.size();

        for (int i=0; i< list.size(); i++ ) {

            if ( list.get(i) > list.get(i+1)) {
                bp = i;
                break;
            }
        }

        int lp = bp+1;
        int rp = bp;

        while(lp != rp ) {

            // CASE 1 

            if ( list.get(lp) + list.get(rp) == target ) {
                return true;
            }

            // CASE 2 

            else if ( list.get(lp) + list.get(rp) < target ) {
                lp = (lp+1) % n ;
            }

            // CASE 3 

            else {
                rp = ( n+rp-1 ) % n ;
            }
        }
        return false;
    }

    public static void main ( String args[] ) {
        
        ArrayList<Integer> list = new ArrayList<>();

        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 500;

        System.out.println(solvepairsum2(list, target));

    }
    
}
