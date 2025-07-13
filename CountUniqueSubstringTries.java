public class CountUniqueSubstringTries {

    static class Node {

        Node children[] = new Node[26] ;
        boolean eow = false ;

        Node () {
            for ( int i = 0 ; i < 26 ; i++ ) {
                children[i] = null ;
            }
        }
    }

    public static Node root = new Node();

    // Insert 

    public static void insert ( String word ) {

        Node curr = root ;

        for ( int level = 0 ; level < word.length() ; level++ ) {

            int idx = word.charAt(level) - 'a' ;

            if ( curr.children[idx] == null ) {

                curr.children[idx] = new Node();

            }

            curr = curr.children[idx];
        }

        curr.eow = true ;
    }

    public static int countuniquesubstring ( Node root ) {

        // Base Case

        if ( root == null ) {
            return 0 ;
        }

        int count = 0 ;
        Node curr = root ;

        for ( int i = 0 ; i < 26 ; i++ ) {

            if ( curr.children[i] != null ) {

                count += countuniquesubstring (curr.children[i]) ;

            }
        }

        return count + 1 ;
    }

    public static void main ( String args[] ) {

        String str = "apple" ;

        for ( int i = 0 ; i < str.length() ; i++ ) {
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println(countuniquesubstring(root));
    }
    
}
