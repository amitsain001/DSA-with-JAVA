import java.util.ArrayList;

public class StackB {

    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        // IsEmpty Function

        public static boolean isempty() {
            return list.size() == 0;
        }

        // Push 

        public static void push(int data) {
            list.add(data);
        }

        // POP 

        public static int pop() {

            if ( isempty() ) {

                System.out.println("Stack is empty");
                return -1;

            }

            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;

        }

        // PEEK 

        public static int peek() {

            if ( isempty() ) {

                System.out.println("Stack is empty");
                return -1;

            }
            
            int top = list.get(list.size()-1);
            return top;
        }
    }

    public static void main ( String args[] ) {
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
