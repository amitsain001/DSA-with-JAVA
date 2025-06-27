import java.util.*;

public class RootToLeaf {

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

    public static void roottoleaf( Node root, ArrayList<Integer> path ) {

        // Base Case

        if ( root == null ) {
            return;
        }

        // Kaam

        path.add(root.data);

        if ( root.left == null && root.right == null ) {
            printroottoleaf(path);
        }

        roottoleaf(root.left, path);
        roottoleaf(root.right, path);
        path.remove(path.size()-1);

    }

    public static void printroottoleaf(ArrayList<Integer> path) {

        for ( int i = 0; i< path.size(); i++ ) {

            System.out.print(path.get(i)+"->");

        }

        System.out.println("Null");
    }

    public static void main ( String args[] ) {

        int val[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;

        for ( int i = 0; i < val.length; i++ ) {
            root = insert(root, val[i]);
        }


        roottoleaf(root, new ArrayList<>());


    }
    
}
