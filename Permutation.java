public class Permutation {

    public static void printper(String str, String ans) {

        // BASE CASE 

        if ( str.length() == 0 ) {
            System.out.println(ans);
            return;
        }

        // RECURSION 

        for ( int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);
            
            // "abcde" = "ab" + "de" = "abde" ( e is removed simmilarly we will going to remove the stored curr char from the string)

            String newstr = str.substring(0, i) + str.substring(i+1);  // str.substring(i+1, str.length() )

            printper(newstr, ans+curr);
        }
    }
    

    public static void main ( String args[] ) {
        String str = "abc";
        printper(str, " ");
    }
}
