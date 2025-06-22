public class TreeDiameter {

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

    // ----------------------------------------- APPROACH 1 : TC = O ( N^2 ) ------------------------------------------------- 

    public static int treeheight (Node root) {

        if ( root == null ) {
            return 0;
        }

        int lh = treeheight(root.left);
        int rh = treeheight(root.right);
        return Math.max( lh, rh ) + 1 ;

    }

    public static int treediameter ( Node root ) {

        if ( root == null ) {
            return 0;
        }

        int ld = treediameter(root.left);
        int lh = treeheight(root.left);
        int rd = treediameter(root.right);
        int rh = treeheight(root.right);

        int selfdia = lh + rh + 1;

        return Math.max( selfdia , Math.max( ld , rd ) );

    }


    // ----------------------------------------- APPROACH 2 : TC = O ( N ) ------------------------------------------------- 

    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht ) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter ( Node root ) {
        if ( root == null ) {
            return new Info(0, 0 );
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        // -------------------------------------------------------------|<------ Self diameter 👇 ---->|          

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1 );
        int ht = Math.max( leftInfo.ht , rightInfo.ht ) + 1 ;

        return new Info(diam , ht );
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

        System.out.println("Diameter of tree from approach 1 = "+ treediameter(root));             // Approach 1

        System.out.println("Diameter of tree from approach 2 = "+diameter(root).diam);             // Approach 2

    }
    
}
