import java.util.* ;
import java.util.LinkedList;

public class BipartiteGraph {

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

        graph[1].add(new Edge ( 1, 0 )) ;
        graph[1].add(new Edge ( 1, 3 )) ;

        graph[2].add(new Edge ( 2, 0 )) ;
        graph[2].add(new Edge ( 2, 4 )) ;

        graph[3].add(new Edge ( 3, 1 )) ;
        graph[3].add(new Edge ( 3, 4 )) ;

        graph[4].add(new Edge ( 4, 2 )) ;
        graph[4].add(new Edge ( 4, 3 )) ;

    }

    public static boolean isbipartite ( ArrayList<Edge> graph[] ) {

        int col[] = new int[graph.length] ;

        Queue<Integer> q = new LinkedList<>() ;

        for ( int i = 0 ; i < graph.length ; i++ ) {
            col[i] = -1 ;
        }

        for ( int i = 0 ; i < graph.length ; i++ ) {

            if ( col[i] == -1 ) {

                q.add(i) ;
                col[i] = 0 ;

                while ( !q.isEmpty() ) {

                    int curr = q.remove() ;

                    for ( int j = 0 ; j < graph[curr].size() ; j++ ) {

                        Edge e = graph[curr].get(j) ;

                        if ( col[e.dest] == -1 ) {

                            int neighcol = col[curr] == 0 ? 1 : 0 ;
                            col[e.dest] = neighcol ;
                            q.add(e.dest) ;
                            

                        } else if ( col[curr] == col[e.dest] ) {
                            return false ;      // Not bipartite
                        }
                    
                    }
                }
            }
        }

        return true ;
    }

    public static void main ( String args [] ) {

        int v = 5 ;

        @SuppressWarnings("unchecked") 

        ArrayList<Edge> graph[] = new ArrayList[v] ;

        creategraph(graph); 

        System.out.println( isbipartite(graph) ) ;
    }
    
}
