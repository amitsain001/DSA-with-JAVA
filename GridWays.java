public class GridWays {

    public static int gridways(int i, int j, int row, int col) {

        // BASE CASE 

        if( i == row-1 && j == col-1 ) {
            return 1;
        } else if ( i>row || j>col ) {
            return 0;
        }

        // KAAM 

        int w1 = gridways(i+1, j, row, col);        // DOWN MOVEMENT
        int w2 = gridways(i, j+1, row, col);        // RIGHT MOVEMENT
        return w1+w2;
    }
    

    public static void main(String args[]) {
        int n = 4, m = 4;
        System.out.print(gridways(0,0,n,m));
    }
}
