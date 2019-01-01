/*
Leetcode 63 :  Unique Paths II

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] sol;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        sol = new int[row][col];
        if(obstacleGrid[0][0] == 1)
            return 0;
        sol[0][0] = 1;
        
          for(int i=1; i<col; i++){
             if(obstacleGrid[0][i] == 1)
                 break;
             sol[0][i] = 1;
          }
         for(int i=1; i<row; i++){
             if(obstacleGrid[i][0] == 1)
                 break;
             sol[i][0] = 1;
         }
        
        for(int i=1; i<row; i++)
            for(int j=1; j<col; j++){
                if(obstacleGrid[i][j] == 1)
                    continue;              
                   sol[i][j] += sol[i-1][j]+sol[i][j-1];
                    
            }
         return sol[row-1][col-1];
    }
}
