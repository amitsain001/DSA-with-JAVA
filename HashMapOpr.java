import java.util.HashMap;

public class HashMapOpr {

    public static void main ( String args[] ) {

        HashMap< String, Integer > hm = new HashMap<>();

        // Insert Function

        hm.put( "Burger" , 49) ;
        hm.put( "Momos" , 60) ;
        hm.put( "Corn" , 90 ) ;

        System.out.println (hm) ;

        // get () 

        int momoprice = hm.get("Momos");
        System.out.println ("Momos price = " + momoprice);

        // Contains ()

        System.out.println( hm.containsKey ("Burger") ) ;
        System.out.println( hm.containsKey ("chillipotata") ) ;

        // remove ()

        hm.remove("Corn");
        System.out.println( hm ) ;

    }
    
}
