import java.util.ArrayList;
import java.util.Collections;

public class SwapArrayList {

    public static void swap(ArrayList<Integer> List, int idx1, int idx2) {

        int temp = List.get(idx1);
        List.set(idx1, List.get(idx2));
        List.set(idx2, temp);

    }

    public static void main ( String args[] ) {

        ArrayList<Integer> List = new ArrayList<>();
    
        // Add Operation

        List.add(2);
        List.add(5);
        List.add(9);
        List.add(6);
        List.add(8);

        // int idx1 = 1, idx2 = 3;

        System.out.println(List);
        // swap(List, idx1, idx2);
        // System.out.print(List);

        // Sorting in Ascending Order

        Collections.sort(List);
        System.out.println(List);

        
        // Sorting in Descending Order

        Collections.sort(List, Collections.reverseOrder());
        System.out.print(List);


    }

}
