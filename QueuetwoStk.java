import java.util.Stack;
public class QueuetwoStk {

    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        // isEmpty function

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // Add = TC : 0(n)

        public static void add(int data) {

            while ( !s1.isEmpty() ) {

                s2.push(s1.pop());          // pushing s1----->>s2

            }

            s1.push(data);  

            while ( !s2.isEmpty() ){

                s1.push(s2.pop());              // pushing s2 --->> s1

            }
        }

        // Remove = TC : 0(1)

        public static int remove() {

            if ( isEmpty() ) {

                System.out.println("Stack is empty");
                return -1;
                
            }
            return s1.pop();
        }

        // Peek = TC : 0(1)

        public static int peek() {

            if ( isEmpty() ) {

                System.out.println("Stack is empty");
                return -1;
                
            }
            return s1.peek();

        }
    }

    public static void main ( String args[] ) {

        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {

            System.out.println(q.peek());
            q.remove();

        }

    }
}