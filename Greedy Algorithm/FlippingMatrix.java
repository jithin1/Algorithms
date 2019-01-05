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
             result+= Math.max(zeroes,rows-zeroes)*(1 << (cols-1-j));  // see what is max, zeroes or ones and the decide to flip or not
        }
        
        return result;
    }

}