public class RecursionBasics1 {

                                    // Print n numbers in decreasing order 

    // public static void printdec(int n) {
    //     if(n == 1) {
    //         System.out.print(n);
    //         return;
    //     } else {
    //         System.out.print(n+" ");
    //         printdec(n-1);
    //     }
    // }

                                    // Print n numbers in increasing order

    //   public static void printinc(int n) {
    //     if(n == 1) {
    //         System.out.print(n+" ");
    //         return;
    //     } else {
    //         printinc(n-1);
    //         System.out.print(n+" ");
    //     }
    // }

                                    // Program of fibonacci series

    // public static int fibonacci(int n) {

    //     // Base Case 

    //     if ( n == 0 || n == 1 ) {
    //         return n;
    //     }

    //     // Normal case 

    //     int fibnm1 = fibonacci(n-1);
    //     int fibnm2 = fibonacci(n-2);
    //     int fibn = fibnm1 + fibnm2;
    //     return fibn;

    // } 

                                        // Array is sorted or not
    
    // public static boolean issorted( int arr[], int i ) {

    //      if ( i == arr.length-1 ) {
    //        return true;
    //     }

    //     if( arr[i] > arr[i+1] ) {
    //         return false;
    //     }
    //     return issorted( arr , i+1 );
    // }

                            // Find the first occurance of a number in an array

    // public static int firstoccur(int arr[], int i, int key) {

    //     if( arr[i] == key ) {
    //         return i;
    //     }
    //     return firstoccur( arr, i+1, 2);

    // }

                        // Find the Last occurance of a number in an array

    // public static int lastoccur(int arr[], int i, int key) {

    //     if( arr[i] == key ) {
    //         return i;
    //     }
    //     return lastoccur( arr, i-1, 6);

    // }

                                            // Print x^n

    // public static int power(int x, int n) {

    //     if(n == 0) {
    //         return 1;
    //     }

    //     return x*power(x, n-1);
    // }

                                        // Optimized print x^n

    public static int optimized(int x, int n) {

        if(n == 0) {
            return 1;
        }

        int halfpower = optimized(x, n/2);
        int halfpowersq = halfpower * halfpower;

        if(n%2 != 0) {
            halfpowersq = x * halfpowersq;
        }
        return halfpowersq;
    }

    public static void main(String args[]) {

        System.out.println(optimized(2,6));

        // System.out.println(power(2,4));

        // int n = 7;

        // int arr[] = { 1,3,4,6,2,2,5,6,7,8 };

        // int i = arr.length-1;

        // System.out.print(lastoccur(arr, i, 6));

        // System.out.print(issorted(arr, 0));

        // printdec(n);

        // printinc(n);

        // System.out.print(fibonacci(n));
        


    }

}