import java.util.* ;

public class DetectCycleUsingDFS {

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
        graph[0].add(new Edge ( 0, 3 )) ;
        graph[0].add(new Edge ( 0, 2 )) ;

        graph[1].add(new Edge ( 1, 0 )) ;
        graph[1].add(new Edge ( 1, 2 )) ;

        graph[2].add(new Edge ( 2, 0 )) ;
        graph[2].add(new Edge ( 2, 1 )) ;
        graph[2].add(new Edge ( 2, 4 )) ;

        graph[3].add(new Edge ( 3, 0 )) ;

        graph[4].add(new Edge ( 4, 2 )) ;
    }

    public static boolean detectcycle ( ArrayList<Edge> graph[] ) {

        boolean visit[] = new boolean[graph.length] ;

        for ( int i = 0 ; i < graph.length ; i++ ) {
            if ( !visit[i] ) {
                if ( detectcycleutil ( graph , i , visit , -1 ) ) {
                    return true ;
                }
            }
        }

        return false ;
    }

    public static boolean detectcycleutil ( ArrayList<Edge> graph[] , int curr , boolean visit[] , int par ) {

        visit[curr] = true  ;

        for ( int i = 0 ; i < graph[curr].size() ; i++ ) {

            Edge e = graph[curr].get(i) ;

            // Case 3 

            if ( !visit[e.dest] ) {

                if ( detectcycleutil(graph , e.dest , visit , curr ) ) {
                    return true ;
                }

            }

            // case 1

            else if ( visit[e.dest] && e.dest != par ) {
                return true ;
            } 

            // case 2
        }

        return false ;

    }

    public static void main ( String args[] ) {

        int v =  5 ;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v] ;

        creategraph(graph);

        System.out.println( detectcycle(graph) );
    }
    
}
