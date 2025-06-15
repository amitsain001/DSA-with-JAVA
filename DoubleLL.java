public class DoubleLL {

    public class Node {

        int data;
        Node next;
        Node prev;

        public Node( int data ) {
            this.data = data;
            this.next = null;
            this.prev = null;
        } 
    }
    public static Node head;
    public static Node tail;
    public static int size;

    // Add First 

    public void addFirst( int data ) {
        Node newnode = new Node(data);
        size++;

        if( head == null ) {
            head = tail = newnode;
            return;
        }

        newnode.next = head;
        head.prev = newnode;
        head = newnode;
    }

    // Print Doubly Linked List

    public void printdll () {

        Node temp = head;

        while ( temp != null ) {
            System.out.print(temp.data +"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Remove First 

    public int removefirst() {

        if( head == null ) {
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        }

        if ( size == 1 ) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;

    }

    // Reverse A DLL 

    public void reverse () {

        Node prev = null;
        Node next;
        Node curr = head;

        while ( curr != null ) {

            next = curr.next;
            curr.next = prev;
            curr.prev = next;           // One step added in DLL 

            prev = curr;
            curr = next;
        }
        
        head = prev;
    }

    // MAIN FUNCTION

    public static void main ( String args[] ) {

        DoubleLL dll = new DoubleLL();

        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);

        // dll.printdll();
        // System.out.println(size);

        // dll.removefirst();
        // dll.printdll();
        // System.out.println(size);

        dll.reverse();
        dll.printdll();

    }
}
