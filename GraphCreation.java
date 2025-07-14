import java.util.* ;

public class GraphCreation {

    static class Edge {

        int src ;
        int dest ;
        int wt ;

        public Edge ( int s , int d , int w ) {

            this.src = s ;
            this.dest = d ;
            this.wt = w ;

        }

    }

    public static void main ( String args[] ) {

        /*                   (5)
                        0 --------- 1 
                                   / \
                            (1)   /   \   (3)
                                 /     \
                                2 ----- 3
                                |  (1)
                            (2) |  
                                |
                                4
         */

        int v = 5 ;

        @SuppressWarnings ("unchecked") 

        ArrayList<Edge>[] graph = new ArrayList[v] ; // null AL

        for ( int i = 0 ; i < v ; i++ ) {       // null AR -> Empty AL
            graph[i] = new ArrayList<>();
        }

        // for 0

        graph[0].add(new Edge ( 0, 1, 5 )) ;

        // for 1 

        graph[1].add(new Edge ( 1, 0, 5 )) ;
        graph[1].add(new Edge ( 1, 2, 1 )) ;
        graph[1].add(new Edge ( 1, 3, 3 )) ;

        // for 2 

        graph[2].add(new Edge ( 2, 1, 1 )) ;
        graph[2].add(new Edge ( 2, 3, 1 )) ;
        graph[2].add(new Edge ( 2, 4, 2 )) ;

        // for 3 

        graph[3].add(new Edge ( 3, 1, 3 )) ;
        graph[3].add(new Edge ( 3, 2, 1 )) ;

        // for 4 

        graph[4].add(new Edge ( 4, 2, 2 )) ;

        // 2's neighbour 

        for ( int i = 0 ; i < graph[2].size() ; i++ ) {

            Edge e = graph[2].get(i) ;                      // ( src , dest , wt )

            System.out.println(e.dest);

        }

    }
    
}
