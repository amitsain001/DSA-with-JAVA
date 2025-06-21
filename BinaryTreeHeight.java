public class BinaryTreeHeight {

    static class Node {
        int data;
        Node left;
        Node right;

        Node ( int data ) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int treeheight (Node root) {

        if ( root == null ) {
            return 0;
        }

        int lh = treeheight(root.left);
        int rh = treeheight(root.right);
        return Math.max( lh, rh ) + 1 ;

    }

    // Node Count Function

    public static int nodecount(Node root) {
        if( root == null ) {
            return 0;
        }

        int leftcount = nodecount(root.left);
        int rightcount = nodecount(root.right);
        return leftcount + rightcount + 1 ;
    }

    // Sum of Nodes Function

    public static int nodesum ( Node root ) {
        if ( root == null ) {
            return 0;
        }

        int lsum = nodesum(root.left);
        int rsum = nodesum(root.right);
        return lsum + rsum + root.data;
    }
    
    public static void main ( String args[] ) {

        /*               1
                       /   \
                      2     3
                     / \   / \
                    4   5  6  7

        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(treeheight(root));

        System.out.println("Total Nodes in the given tree = "+ nodecount(root));

        System.out.println("Total sum of nodes = "+ nodesum(root));

    }
    
}
