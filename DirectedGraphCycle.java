import java.util.* ;

public class DirectedGraphCycle {

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

        graph[0].add(new Edge ( 0, 1 )) ;

        graph[0].add(new Edge ( 0, 2 )) ;

        graph[2].add(new Edge ( 2, 3 )) ;

        graph[1].add(new Edge ( 1, 3 )) ;

    }

    public static boolean iscycle ( ArrayList<Edge> graph[] ) {

        boolean visit[] = new boolean[graph.length] ;
        boolean stack[] = new boolean[graph.length] ;

        for ( int i = 0 ; i < graph.length ; i++ ) {
            if ( !visit[i] ) {
                if ( iscycleutil( graph , i , visit , stack ) ) {
                    return true ;
                }
            }
        }

        return false ;
    }

    public static boolean iscycleutil ( ArrayList<Edge> graph[] , int curr , boolean visit[] , boolean stk[] ) {

        visit[curr] = true ;
        stk[curr] = true ;

        for ( int i = 0 ; i < graph[curr].size(); i++ ) {
            Edge e  = graph[curr].get(i) ;

            if ( stk[e.dest] ) {
                return true ;
            }

            if ( !visit[e.dest] && iscycleutil (graph, e.dest, visit, stk) ) {
                return true ;
            }
        }

        stk[curr] = false ;
        return false ;
        
    }

    public static void main ( String args[] ) {

        int v = 4 ;

        @SuppressWarnings("unchecked") 

        ArrayList<Edge> graph[] = new ArrayList[v] ;

        creategraph(graph);

        System.out.println(iscycle(graph)) ;
    }
    
}
