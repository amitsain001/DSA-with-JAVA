public class LongestWordWithAllPrefixTries {

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

    public static String ans = "" ;

    public static void longestword ( Node root , StringBuilder temp ) {

        if ( root == null ) {
            return ;
        }

        for ( int i = 0 ; i < 26 ; i++ ) {

            Node curr = root ;

            if ( curr.children[i] != null && curr.children[i].eow == true ) {

                char ch = (char)( i + 'a' ) ;
                temp.append(ch) ;

                if ( temp.length() > ans.length() ) {
                    ans = temp.toString() ;
                }

                longestword(curr.children[i], temp);
                temp.deleteCharAt( temp.length() - 1 ) ;

            }
        }
    }

    public static void main ( String args[] ) {

        String words[] = { "a", "banana" , "ap" , "app" , "apple" , "apply" , "appl" } ;

        for ( int i = 0 ; i < words.length ; i++ ) {
            insert(words[i]);
        }

        longestword(root, new StringBuilder(" "));
        System.out.println ( ans ) ;
 
    }
    
}
