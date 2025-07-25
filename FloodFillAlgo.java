// Problem no. 733 ( Leetcode ) = Test this on leet code without main()

public class FloodFillAlgo {

    public void helper ( int image[][] , int sr , int sc , int color, boolean visit[][] , int orgclr ) {

        // Base Case 

        if ( sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visit[sr][sc] || image[sr][sc] != orgclr  ) {
            return ;
        }

        visit[sr][sc] = true ;

        image[sr][sc] = color ;

        //left

        helper(image, sr, sc-1, color, visit, orgclr);

        //right

        helper(image, sr, sc+1, color, visit, orgclr);

        //up

        helper(image, sr-1, sc, color, visit, orgclr);

        //down

        helper(image, sr+1, sc, color, visit, orgclr);
    }

    public int[][] floodFill ( int image[][] , int sr , int sc , int color ) {

        boolean visit[][] = new boolean[image.length][image[0].length] ;
        helper(image , sr , sc , color , visit , image[sr][sc] ) ;
        return image ;
    }
}
