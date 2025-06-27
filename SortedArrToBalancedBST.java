public class SortedArrToBalancedBST {

    static class Node {

        int data;
        Node left;
        Node right;

        public Node ( int data ) {

            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void preorder(Node root) {

        if ( root == null ) {
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);

    }

    public static Node balancedbst ( int arr[] , int si, int ei ) {

        if ( si > ei ) {
            return null;
        }

        int mid = ( si + ei ) / 2 ;

        Node root = new Node ( arr[mid] );

        Node leftst = balancedbst(arr, si, mid - 1 );
        Node rightst = balancedbst(arr, mid + 1, ei);

        root.left = leftst;
        root.right = rightst;

        return root;
    }

    public static void main ( String args[] ) {

        int arr[] = { 3, 5, 6, 8, 10, 11, 12 } ;

        Node root = balancedbst(arr, 0, arr.length-1);
        preorder(root);


    }
    
}
