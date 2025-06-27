public class ValidateBST {
    static class Node {
        int data;
        Node left; 
        Node right;

        public Node ( int data ) {
            this.data = data ;
        }
    }

    // ----------------------------------------------------- Insert In BST ---------------------------------------------------

    public static Node insert ( Node root, int val ) {

        if ( root == null ) {
            root = new Node(val);
            return root;
        }

        if ( root.data > val ) {

            // left side 
           root.left = insert(root.left, val);

        } else {

            // Right Side
           root.right =  insert(root.right, val);
        }

        return root;
    }

    public static boolean checkbstvalidity(Node root, Node min, Node max ) {

        // Case 1

        if ( root == null ) {
            return true;
        }

        // Case 2

        if ( min != null && min.data >= root.data ) {
            return false ;
        }

        // Case 3

        if ( max != null && max.data <= root.data ) {
            return false ;
        }

        // Case 4 

        return checkbstvalidity(root.left, min, root) && checkbstvalidity(root.right, root , max);
    }



    public static void main ( String args[] ) {

        int val[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;

        for ( int i = 0; i < val.length; i++ ) {
            root = insert(root, val[i]);
        }

        if ( checkbstvalidity(root, null, null ) ) {
            System.out.print("Valid");
        } else {
            System.out.println("Not valid");
        }


    }
}
