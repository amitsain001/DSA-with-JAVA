public class MinDistNodes {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node( int data ) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Least Common Ancestor function

    public static Node lca2( Node root, int n1, int n2 ) {

        if ( root == null || root.data == n1 || root.data == n2 ) {
            return root;
        }

        Node leftlca = lca2 ( root.left, n1, n2 );
        Node rightlca = lca2 ( root.right, n1, n2 );

        if ( leftlca == null ) {
            return rightlca;
        }

        if ( rightlca == null ) {
            return leftlca;
        }

        return root;

    }

    public static int caldist(Node root , int n ) {

        if ( root == null ) {
            return -1;
        }

        if ( root.data == n ) {
            return 0;
        }

        int leftdist = caldist(root.left, n);
        int rightdist = caldist(root.right, n);

        if ( leftdist == -1 && rightdist == -1 ) {

            return -1;

        } else if ( leftdist == -1 ) {

            return rightdist+1;

        } else {

            return leftdist+1;
            
        }

    }

    public static int mindist(Node root, int n1, int n2 ) {

        Node lca = lca2(root, n1, n2);      // LCA Calculated for n1 and n2 

        int dist1 = caldist(lca, n1);
        int dist2 = caldist(lca, n2);  

        return dist1 + dist2 ;
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

        int n1 = 4, n2 = 5;

        System.out.println("Min distance between the given nodes = " + mindist(root, n1, n2));


    }
    
}
