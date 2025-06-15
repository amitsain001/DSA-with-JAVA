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

    // Iterative Search Method = TC = 0(n)

    public int itrsearch(int key) {

        Node temp = head;
        int i = 0;

        while ( temp != null ) {                    // key found case 
            if(temp.data == key ) {
                return i;
            } else {
                temp = temp.next;
                i++;
            }
        }
        return -1;                                  // if key not found
    }

    // Recursive Search 

    public int rcsearch(int key ) {
        return helper(head, key);
    }

    public int helper(Node head, int key) {

        // Base Case 

        if ( head == null ) {
            return -1;
        }

        // KAAM 

        if ( head.data == key ) {
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1 ) {
            return -1;
        }

        return idx+1;
    }


    // Reversing LinkedList

    public void reverse() {
        Node prev = null;
        Node curr = tail = head ;
        Node next;

        while ( curr != null ) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    // Remove nth node from end

    public void removefromlast(int n) {

        //  Size Defining

        int sz = 0;
        Node temp = head;
        
        while ( temp != null ) {
            temp = temp.next;
            sz++;
        }

        if ( n == sz ) {
            head = head.next;           // Remove First
            return;
        }

        // For size-n

        int i = 1;
        int idxtofind = sz-n;
        Node prev = head;

        while( i < idxtofind ) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;

    }


    // CHECK IF A LINKED LIST IS PALINDROME OR NOT 

    public Node findmid(Node head) {

        Node slow = head;
        Node fast = head;

        while ( fast != null && fast.next != null ) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // slow is our mid
    }

    public boolean checkpalindrome () {

        // Base case 

        if ( head == null && head.next == null ) {
            return false;
        }

        // Step-1 finding mid

        Node midnode = findmid(head);

        // Step-2 Reversing half array

        Node prev = null;
        Node curr = midnode;
        Node next;

        while ( curr != null ) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;      // Right Head
        Node left = head;       // Left Head

        // Step-3 Comparision left and right part

        while ( right != null ) {
            if ( left.data != right.data ) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }


    // MERGE SORT CODE 😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎

    private Node getmid(Node head) {

        Node slow = head;
        Node fast = head.next;

        while ( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;    // mid node 

    }

    private Node merge(Node head1, Node head2) {

        Node mergell = new Node(-1);
        Node temp = mergell;

        while ( head1 != null && head2 != null ) {

            if ( head1.data <= head2.data ) {

                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;

            } else {

                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;

            }

        }

        while (head1 != null) {

            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;

        }

        while ( head2 != null ) {

            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;

        }

        return mergell.next;

    }

    public Node mergesort(Node head) {

        // Base Case

        if ( head == null || head.next == null ) {
            return head;
        }

        // Find Mid

        Node mid = getmid(head);

        // Left and Right LL Comparision

        Node righthead = mid.next;
        mid.next = null;
        Node newleft = mergesort(head);
        Node newright = mergesort(righthead);

        // Merge 

        return merge(newleft, newright);
    }

    //  Zig-Zag Linked List

    public void zigzag() {

        // Find mid

        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        // Reverse 2nd half

        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        Node next;

        while ( curr != null ) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Alternate merge

        Node lefth = head;
        Node righth = prev;
        Node nextl , nextr;

        while ( lefth != null && righth != null ) {
            nextl = lefth.next;
            lefth.next = righth;
            nextr = righth.next;
            righth.next = nextl;

            lefth = nextl;
            righth = nextr;
        }
    }


    public static void main ( String args[] ) {

        LinkedList l1 = new LinkedList();

        l1.addlast(1);
        l1.addlast(2);
        l1.addlast(3);
        l1.addlast(4);
        l1.addlast(5);
        // l1.addmid(2, 10);

        l1.printll();

        // l1.removefirst();
        // l1.printll();

        // System.out.println(l1.rcsearch(3));
        // System.out.println(l1.rcsearch(50));

        // l1.reverse();

        // l1.removefromlast(3);

        // l1.printll();
        // System.out.println(l1.checkpalindrome());

        // l1.head = l1.mergesort(l1.head);
        // l1.printll();

        l1.zigzag();
        l1.printll();

    }
}
