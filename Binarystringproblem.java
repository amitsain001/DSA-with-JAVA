public class Binarystringproblem {

    public static void printbinarystring(int n, int lastplace, String str) {

        // BASE CASE

        if ( n == 0 ) {
            System.out.println(str);
            return;
        }

        // KAAM 

        printbinarystring(n-1, 0, str+"0");
        if ( lastplace == 0 ) {
            printbinarystring(n-1, 1, str+"1");

        } 

    }
    public static void main(String args[]) {

        printbinarystring(3, 0, "");

    }
}