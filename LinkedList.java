public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node ( int data ) {

            this.data = data;
            this.next = null;

        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    // ADD New Node At First

    public void addfirst (int data ) {

        Node newnode = new Node(data);  // Step 1 = Creating a new node 
        size++;

        // BASE CASE 

        if ( head == null ) {
            head = tail = newnode;
            return;

        }
        newnode.next = head;            // Step 2 = linking step 
        head = newnode;                 // Step 3 = Assigning head to new node


    }

    // ADD New Node At Last 

    public void addlast ( int data ) {

        Node newnode = new Node(data);          // Step 1 = Creating new node
        size++;
        
        // Base Case 

        if ( head == null ) {
            head = tail = newnode;
            return;
        }

        tail.next = newnode;                    // Step 2 = Linking state
        tail = newnode;

    }

    // ADD IN MIDDLE 

    public void addmid(int idx, int data) {

        // Base Case 

        if ( idx == 0 ) {
            addfirst(data);
            return;
        }

        Node newnode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while ( i < idx-1 ) {
            temp = temp.next;
            i++;
        }

        newnode.next = temp.next;
        temp.next = newnode;
    }

    // Remove first from linked list

    public int removefirst() {

        // Base Case 

        if ( size == 0 ) {
            System.out.println(" Linked list is empty ");
            return Integer.MIN_VALUE;
        } else if ( size == 1 ) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // Method to print linked list

    public void printll () {
        Node temp = head;

        while ( temp != null ) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main ( String args[] ) {

        LinkedList l1 = new LinkedList();
        l1.addfirst(2);
        l1.addfirst(1);
        l1.addlast(3);
        l1.addlast(4);
        l1.addmid(2, 10);
        l1.printll();

        l1.removefirst();
        l1.printll();

    }

    public LinkedList.Node mergesort(LinkedList.Node head2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mergesort'");
    }
}
