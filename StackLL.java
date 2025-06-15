public class StackLL {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head = null;

        // ISEMPTY

        public static boolean isempty() {
            return head == null;
        }

        // PUSH

        public static void push(int data) {

            Node newnode = new Node(data);

            if( isempty() ) {
                head = newnode;
                return;
            }

            newnode.next = head;
            head = newnode;
            
        }

        // POP 

        public static int pop () {

             if( isempty() ) {
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;

        }

        // PEEK 

        public static int peek() {

            if( isempty() ) {
                return -1;
            }

            return head.data;

        }
    }
    
    public static void main( String args[] ) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        while ( !s.isempty() ) {

            System.out.println(s.peek());
            s.pop();

        }
    }
}
