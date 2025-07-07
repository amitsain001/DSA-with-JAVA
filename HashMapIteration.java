import java.util.*; 

public class HashMapIteration {

    public static void main ( String args[] ) {

        HashMap< String, Integer > hm = new HashMap<>();

        // Insert Function

        hm.put( "Burger" , 49) ;
        hm.put( "Momos" , 60) ;
        hm.put( "Corn" , 90 ) ;
        hm.put( "Chillipotato" , 120 ) ;
        hm.put( "Pizza" , 200 ) ;

        Set<String> key = hm.keySet();

        // foreach loop 

        for (String k : key) {
            
            System.out.println ( "key = " + k + " ," + " value = " + hm.get(k) ) ;
        }
        System.out.println() ;
    }
    
}
