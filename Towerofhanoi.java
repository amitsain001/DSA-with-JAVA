public class Towerofhanoi {

    public static void TOH(int n, String src, String helper, String dest) {

        // BASE CASE 

        if ( n == 1 ) {
            System.out.println("Transfer disk "+ n + " from "+ src +" to " + dest);
            return;
        }

        // KAAM 

        TOH(n-1, src, dest, helper);
        System.out.println("Transfer disk "+ n + " from "+ src +" to " + dest);
        TOH(n-1, helper, src, dest);   
    }

    public static void main(String args[]) {
        int n=2;
        TOH(n, "S", "H", "D");
    }
    
}
