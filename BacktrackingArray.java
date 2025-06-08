public class BacktrackingArray {

    public static void newarray(int arr[], int i, int val) {

        // BASE CASE 

        if ( i == arr.length) {
            printArr(arr);
            return;
        }

        // Recursion ( KAAM ) 

        arr[i] = val;
        newarray(arr, i+1, val+1);
        arr[i] = val-2;

    }

    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = new int[5];
        newarray(arr, 0, 1);
        printArr(arr);

    }
    
}
