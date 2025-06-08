import java.util.ArrayList;

public class ArrayListOperations {

    public static void main ( String args[] ) {

        ArrayList<Integer> List = new ArrayList<>();
        // ArrayList<Boolean> List2 = new ArrayList<>();
        // ArrayList<String> List3 = new ArrayList<>();

        // Add Operation

        List.add(2);
        List.add(5);
        List.add(9);
        List.add(6);
        List.add(8);

        System.out.println(List);

        // // Get Operation

        // System.out.println(List.get(2));  // Index no. in braces

        // // // Remove Operation

        // List.remove(2);
        // System.out.println(List);

        // // Set element at index operation

        // List.set(0, 1);
        // System.out.println(List);

        // Contains Operation

        // System.out.println(List.contains(7));
        // System.out.println(List.contains(1));
        // System.out.println(List.contains(21));

        // .size method

        // System.out.println(List.size());

        // // Reverse of ArrayList

        // for ( int i=List.size()-1; i>=0; i--) {
        //     System.out.print(List.get(i)+ " ");
        // }

        // Maximum in arraylist

        int max = Integer.MIN_VALUE;

        for( int i=0; i<List.size(); i++ ) {
           
            if ( List.get(i) > max ) {
                max = List.get(i);
            }
        }

        System.out.println("Maximum value is " + max);

    }
    
}
