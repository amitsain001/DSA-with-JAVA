public class NQueensProblem {

    public static boolean issafe(char board[][], int row, int col) {

        // Vertically Up

        for(int i = row-1; i>=0; i--  ) {

            if( board[i][col] == 'Q') {
                return false;

            }
        }

        // Diagonally left

        for(int i = row-1, j = col-1; i>=0 && j>=0; i--, j-- ) {

            if( board[i][j] == 'Q') {
                return false;
            }
        }

        // Diagonally Right

        for(int i = row-1, j = col+1; i>=0 && j<board.length; i--, j++) {
            
            if( board[i][j] == 'Q' ) {
                return false;
            }
        }

        return true;
    }

    public static void nqueenplace(char board[][], int row ) {

        // BASE CASE 

        if ( row == board.length ) {
            printboard(board);
            return;
        }

        // KAAM 

        for(int j=0; j<board.length; j++) {

            if( issafe(board, row, j) == true ) {

                board[row][j] = 'Q';
                nqueenplace(board, row+1);                  // Recursion
                board[row][j] = 'x';                        // Backtracking

            }     

        }
    }

    // Function to print chess board 

    public static void printboard(char board[][]) {

        System.out.println("-----------CHESS BOARD-------------");

        for( int i=0; i<board.length; i++) {
            for( int j=0; j<board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main( String args[]) {

        int n = 4;
        char board[][] = new char[n][n];                // Creating chess board 

        // Initialization 

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {

                board[i][j] = 'x';

            }
        }

        nqueenplace(board, 0);

    }
    
}
