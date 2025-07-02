import java.util.* ; 

public class Heap {

    static class heap {

        ArrayList<Integer> arr = new ArrayList<>();

        // ----------------------------------------------- Insert In Heap ---------------------------------------

        public void add ( int data ) {

            arr.add(data);

            int childidx = arr.size() - 1 ;
            int paridx = ( childidx - 1 ) / 2 ;

            while ( arr.get ( paridx ) > arr.get ( childidx ) )  {

                int temp = arr.get(childidx);
                arr.set ( childidx , arr.get(paridx) );
                arr.set ( paridx , temp ) ;

                childidx = paridx ;
                paridx = ( childidx - 1 ) / 2 ;

            }
        }

        // ------------------------------------------------ PEEK In Heap -----------------------------------------

        public int peek () {
            return arr.get(0);
        }

        // ------------------------------------------------ Remove In Heap ---------------------------------------

        // ---------- Function To Fix Heap -------------------

        private void heapify ( int i ) {

            int leftidx = 2 * i + 1 ;
            int rightidx = 2 * i + 2 ;
            int minidx = i ;

            if ( leftidx < arr.size() && arr.get ( minidx ) > arr.get ( leftidx ) ) {
                minidx = leftidx ;
            }

            if ( rightidx < arr.size() && arr.get ( minidx ) > arr.get ( rightidx ) ) {
                minidx = rightidx ;
            }

            if ( minidx != i ) {

                int temp = arr.get ( i ) ;
                arr.set ( i, arr.get ( minidx ));
                arr.set ( minidx , temp ) ;

                heapify(minidx);
            }
        }

        // ------------------ Function To Remove ---------------------------

        public int remove () {

            int data = arr.get(0);

            // Step -1 : swapping 

            int temp = arr.get ( 0 ) ;
            arr.set ( 0 , arr.get ( arr.size() - 1 ) ) ;
            arr.set ( arr.size() - 1 , temp ) ;

            // Step - 2 : delete last idx 

            arr.remove ( arr.size() - 1 ) ;

            // Step 3 : Fix Heap

            heapify ( 0 ) ;
            return data ; 

        }

        //-------------------------------- Empty Function -----------------------------

        public boolean isEmpty () {
            return arr.size() == 0  ;
        }
    }

    public static void main ( String args[] ) {

        heap h = new heap();

        h.add(3);
        h.add(5);
        h.add(1);
        h.add(7);
        h.add(6);

        while ( !h.isEmpty() ) {
            System.out.println( h.peek() ) ;
            h.remove();

        }
    
    }
}
