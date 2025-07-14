import java.util.* ;

public class IterationInHashSet {

    public static void main ( String args[] ) {

        HashSet<String> cities = new HashSet<>() ;

        cities.add("Bangalore") ;
        cities.add("Noida") ;
        cities.add("Gurugram") ;
        cities.add("Delhi") ;
        cities.add("Mumbai") ;

        // using Iterators

        System.out.println("Using Iteratior :");
        System.out.println() ;

        Iterator<String> it = cities.iterator() ;

        while ( it.hasNext() ) {

            System.out.println( it.next() ) ;

        }

        System.out.println() ;

        System.out.println("Using Advanced For Loop :");
        System.out.println() ;

        // Using advanced for loop 

        for ( String city : cities ) {

            System.out.println(city);
        }


    }
    
}
