public class TillingProblem {

    public static int Tillingways(int n) {

        //BASE CASE

        if( n==0 || n==1 ) {
            return 1;
        }

        // KAAM 

        int fnm1 = Tillingways(n-1);   // Vertical Ways
        int fnm2 = Tillingways(n-2);   // Horizontal ways
        int totalways = fnm1+fnm2;
        return totalways;
        
    }

    public static void main(String args[]) {
        System.out.print(Tillingways(4));
    }
    
}
