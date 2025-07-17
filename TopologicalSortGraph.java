import java.util.* ; 

public class TopologicalSortGraph {

    static class Edge {

        int src ;
        int dest ;

        public Edge ( int s , int d ) {

            this.src = s ;
            this.dest = d ;

        }
    }

    public static void creategraph ( ArrayList<Edge> graph[] ) {

        for ( int i = 0 ; i < graph.length ; i++ ) {
            graph[i] = new ArrayList<>() ;
        }

        graph[5].add(new Edge ( 5, 0 )) ;
        graph[5].add(new Edge ( 5, 2 )) ;

        graph[4].add(new Edge ( 4, 0 )) ;
        graph[4].add(new Edge ( 4, 1)) ;

        graph[2].add(new Edge ( 2, 3 )) ;

        graph[3].add(new Edge ( 3, 1 )) ;

    }

    public static void toposort ( ArrayList<Edge> graph[] ) {

        boolean visit[] = new boolean[graph.length] ;

        Stack<Integer> s = new Stack<>() ;

        for ( int i = 0  ; i < graph.length ; i++ ) {

            if ( !visit[i] ) {
                toposortutil ( graph , i , visit , s ) ;
            }
        }

        while ( !s.isEmpty() ) {
            System.out.print(s.pop() + " ") ;
        }
    }

    public static void toposortutil ( ArrayList<Edge> graph[] , int curr , boolean visit[] , Stack<Integer> stk ) {

        visit[curr] = true ;

        for ( int i = 0 ; i < graph[curr].size() ; i++ ) {

            Edge e = graph[curr].get(i) ;

            if ( !visit[e.dest] ) {

                toposortutil(graph, e.dest, visit, stk);

            }
        }

        stk.push(curr) ;

    }

    public static void main ( String args[] ) {

        int v = 6 ;

        @SuppressWarnings("unchecked")

        ArrayList<Edge> graph[] = new ArrayList[v]  ;

        creategraph(graph);

        toposort(graph);


    }
    
}
