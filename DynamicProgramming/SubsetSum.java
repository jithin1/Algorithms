class SubsetSum{
    
     public static void subsetSum(int[] input, int sum){
          int m= input.length;
         boolean[][] temp = new boolean[m+1][sum+1];
         
         temp[0][0] = true;
         
         for(int j=1; j<=m; j++){
          temp[j][0] = true;
          temp[0][j] = false;
         }
         
         for(int i=1; i<=m; i++)
             for(int j=1; j<=sum; j++){
                 
                 if(input[i-1] > j || temp[i-1][j])
                  temp[i][j] = temp[i-1][j];
                           
                 else   
                  temp[i][j] = temp[i-1][j-input[i-1]];
             }
             
             int j= sum;
             int i = m;
             
             // to print the output
             while(j > 0){
                if(temp[i-1][j])
                 {
                     i=i-1;
                 }
                 else{
                     System.out.print(input[i-1]+" ");
                     j= j-input[i-1];
                 }
             }
             
         
     }
     
    public static void main(String[] args){
            int[] input = {5,10,12,13,15,18,9,1,3,22,1};
            int sum = 62;
            subsetSum(input,sum);
    }
}