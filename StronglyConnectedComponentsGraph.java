import java.util.*; 
import java.util.ArrayList; 

public class StronglyConnectedComponentsGraph {

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

        graph[0].add( new Edge(0, 2) ) ;
        graph[0].add( new Edge(0, 3) ) ;

        graph[1].add( new Edge(1, 0) ) ;

        graph[2].add( new Edge(2, 1) ) ;

        graph[3].add( new Edge(3, 4) ) ;

    }

    public static void topsort ( ArrayList<Edge> graph[] , int curr , boolean visit[] , Stack<Integer> stk ) {

        visit[curr] = true ;

        for ( int i = 0 ; i < graph[curr].size() ; i++ ) {

            Edge e = graph[curr].get(i) ;

            if ( !visit[e.dest] ) {
                topsort(graph, e.dest, visit, stk);
            }
        }

        stk.push(curr) ;
    }

    public static void dfs ( ArrayList<Edge> transpose[] , int curr , boolean visit[] ) {

        visit[curr] = true ;
        System.out.print (curr + " ") ;

        for ( int i = 0 ; i < transpose[curr].size() ; i++ ) {

            Edge e = transpose[curr].get(i) ;

            if ( !visit[e.dest] ) {
                dfs(transpose, e.dest, visit );
            }
        }
    }

    public static void kosarajusalgo ( ArrayList<Edge> graph[] , int v ) {

        Stack<Integer> s = new Stack<>() ;
        boolean visit[] = new boolean[v] ;

        // Step 1

        for ( int i = 0 ; i < v ; i++ ) {

            if ( !visit[i] ) {
                topsort( graph , i , visit , s ) ;
            }
        }

        // Step 2 

        @SuppressWarnings("unchecked") 

        ArrayList<Edge> transpose[] = new ArrayList[v] ;

        for ( int i = 0 ; i < graph.length ; i++ )  {

            visit[i] = false ;
            transpose[i] = new ArrayList<>() ;

        }

        for ( int i = 0 ; i < v ; i++ ) {
            
            for ( int j = 0 ; j < graph[i].size() ; j++ ) {

                Edge e = graph[i].get(j) ;
                transpose[e.dest].add( new Edge ( e.dest , e.src ) ) ; // Reverse Process

            }
        }

        // step 3 

        while ( !s.isEmpty() ) {

            int curr = s.pop() ;

            if ( !visit[curr] ) {

                System.out.print("SCC -> ") ;
                dfs ( transpose , curr , visit ) ;
                System.out.println () ;

            }
        }
    }

    public static void main ( String args[] ) {

        int v = 5 ;

        @SuppressWarnings("unchecked") 

        ArrayList<Edge> graph[] = new ArrayList[v] ;
        creategraph(graph);

        kosarajusalgo(graph, v);
    }

}
