public class SubsetsStrings {

    public static void printsubsets(String str, String ans, int i) {

        // BASE CASE 

        if ( i == str.length() ) {
            if ( ans.length() == 0 ) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }

        // Recursion ( KAAM ) 

        // YES CONDITION 

        printsubsets(str, ans+str.charAt(i), i+1);

        // NO CONDITION 

        printsubsets(str, ans, i+1);

    }

    public static void main(String args[]) {
        String str = "abc";
        printsubsets(str, " ",0 );
    }
    
}
