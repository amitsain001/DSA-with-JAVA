public class RotatedSortedArraySearch {

    public static int rotatedsortedarray(int arr[], int si, int ei, int key){

        //BASE CASE 

            if ( si > ei ) {
                return -1;
            }

        // KAAM 

        int mid = si+(ei-si)/2;                                 // (si+ei)/2

        // CASE FOUND

        if( arr[mid] == key ) {
            return mid;
        }

        // CASE 1 ( MID ON L1 )

        if ( arr[si] <= arr[mid] ) {

            if( arr[si] <= key && key <= arr[mid] ) {           // CASE A ( LEFT )

                return rotatedsortedarray(arr, si, mid-1, key);

            } else {                                            // CASE B ( RIGHT )

                return rotatedsortedarray(arr, mid+1, ei, key);

            }

        } 
        
        // CASE 2 ( MID ON L2 )
        
        else {

                if( arr[mid] <= key && key <= arr[ei]) {                // CASE C ( RIGHT )

                    return rotatedsortedarray(arr, mid+1, ei, key);

                } else {                                                // CASE D (LEFT )

                    return rotatedsortedarray(arr, si, mid-1, key);

                }
            }
    }
        

    public static void main(String args []) {
        int arr[] = { 4,5,6,7,0,1,2 };
        int target_index = rotatedsortedarray(arr, 0, arr.length-1, 5);
        System.out.print(target_index);
    }
    
}
