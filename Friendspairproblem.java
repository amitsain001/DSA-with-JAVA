public class Friendspairproblem {

    public static int friendspairprobways(int n) {

        // BASE CASE 

        if ( n == 1 || n == 2 ) {
            return n;
        }

        // KAAM 

        int totalways = friendspairprobways(n-1) + (n-1) * friendspairprobways(n-2);
        return totalways;
    }

    public static void main(String args[]) {
        System.out.print(friendspairprobways(4));
    }
    
}
