/* 474 Ones and Zeroes
  In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only
0s and 1s.

Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

Note:

    The given numbers of 0s and 1s will both not exceed 100
    The size of given string array won't exceed 600.

Example 1:

Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

*/

class Solution {
     int[][][] dp;

    public int findMaxForm(String[] strs, int m, int n) {
          dp = new int[strs.length+1][m+1][n+1];
          int zeroes[] = new int[strs.length];
          int ones[] = new int[strs.length];
          int itr=0;
        
        for(String s: strs){
            
          for(int i=0; i<s.length();i++){
              if(s.charAt(i) == '0')
                 zeroes[itr]++;
              else
                  ones[itr]++;
           }
            itr++;
        }
         
          // using knapsack logic
          for(int i=1; i <=strs.length; i++)
              for(int j=0; j<=m; j++) 
                  for(int k=0;k<=n; k++){
                      if(zeroes[i-1] <=j && ones[i-1] <=k){   checking if wwe can enter in the corresponding cell
                          dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j-zeroes[i-1]][k-ones[i-1]]+1); // we try all the combinations.
                      }
                      else
                          dp[i][j][k] = dp[i-1][j][k]; // go with the bottom layer
                  }
        
        return dp[strs.length][m][n];
    }   
}

   Time complexity is O(str.length*m*n)
   Space Complexity O(str.length*m*n)
   
     // Optimized space
     
       class Solution {
     int[][] dp;

    public int findMaxForm(String[] strs, int m, int n) {
          dp = new int[m+1][n+1];
          int zeroes[] = new int[strs.length];
          int ones[] = new int[strs.length];
          int itr=0;
        
        for(String s: strs){
            
          for(int i=0; i<s.length();i++){
              if(s.charAt(i) == '0')
                 zeroes[itr]++;
              else
                  ones[itr]++;
           }
            itr++;
        }
         
          // using knapsack logic
        
          for(int i=1; i <=strs.length; i++)
              for(int j=m; j >=0; j--) 
                  for(int k=n;k >=0; k--){  // Start from back as to save the previous values
                      if(zeroes[i-1] <=j && ones[i-1] <=k){  
                          dp[j][k] = Math.max(dp[j][k],dp[j-zeroes[i-1]][k-ones[i-1]]+1);
                      }
                  }
        
        return dp[m][n];
    }    
}

    Time complexity is O(str.length*m*n)
   Space Complexity O(m*n)
