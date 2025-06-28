import java.util.*;

public class Merge2BST {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node ( int data ) {
            this.data = data;
            this.left = this.right = null ;
        }
    }

    public static void getinorder ( Node root , ArrayList<Integer> arr ) {

        if ( root == null ) {
            return;
        }

        getinorder(root.left, arr);
        arr.add(root.data);
        getinorder(root.right, arr);

    } 

    public static void preorder ( Node root ) {

        if ( root == null ) {
            return ;
        }

        System.out.print( root.data + " " );
        preorder(root.left);
        preorder(root.right);
    }

    public static Node balancedbst ( ArrayList<Integer> finalarr , int si, int ei ) {

        if ( si > ei ) {
            return null ;
        }

        int mid = ( si + ei ) / 2 ;

        Node root = new Node ( finalarr.get(mid) );
        root.left = balancedbst(finalarr, si, mid-1);
        root.right = balancedbst(finalarr, mid+1, ei);

        return root ;

    }

    public static Node merge ( Node root1, Node root2) {

        // Step 1 = inorder of BST 1

        ArrayList<Integer> arr1 = new ArrayList<>();
        getinorder ( root1, arr1 );

        // Step 2 = inorder of BST 2

        ArrayList<Integer> arr2 = new ArrayList<>();
        getinorder ( root2, arr2 );

        // Step 3 = Merge

        int i = 0 , j = 0 ;
        ArrayList<Integer> finalarr = new ArrayList<>();

        while ( i < arr1.size() && j < arr2.size() ) {

            if ( arr1.get(i) <= arr2.get(j) ) {

                finalarr.add( arr1.get(i) );
                i++;

            } else {

                finalarr.add( arr2.get(j) );
                j++;

            }
        }

        while ( i < arr1.size() ) {

                finalarr.add( arr1.get(i) );
                i++;

            }

            while ( j < arr2.size() ) {

                finalarr.add( arr2.get(j) );
                j++;

            }

        // Step 4 = Balance BST 

        return balancedbst ( finalarr, 0, finalarr.size()-1 );

    }

    public static void main ( String args[] ) {

        // BST 1

        Node root1 = new Node ( 2);
        root1.left = new Node(1);
        root1.right = new Node ( 4 );

        // BST 2

        Node root2 = new Node (9);
        root2.left = new Node (3);
        root2.right = new Node ( 12);

        Node root = merge(root1, root2);
        preorder ( root );

    }
}
