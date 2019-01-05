/*
861. Score After Flipping Matrix

We have a two dimensional matrix A where each value is 0 or 1.

A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.

After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of 
these numbers.

Return the highest possible score.

 

Example 1:

Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation:
Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
*/

class Solution {
    public int matrixScore(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int result = 0;
        
        for(int i=0; i<rows; i++){
            if(A[i][0] == 0)
                for(int j=0;j<cols; j++)
                    A[i][j] = A[i][j]^1;   // make the most significant bit 1
        }
        
        result+=(1<<(cols-1))*rows;  // add all the significant bits to the result
        
           for(int j=1; j<cols; j++){
               int zeroes = 0;
             for(int i=0; i<rows; i++){
                    if(A[i][j] == 0)
                        zeroes++;
                 }
             result+= Math.max(zeroes,rows-zeroes)*(1 << (cols-1-j));  // see what is max, zeroes or ones and then decide to flip or not
        }
        
        return result;
    }

}
