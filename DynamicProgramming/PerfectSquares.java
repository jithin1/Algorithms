/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
*/

class Solution {
    // using number of coins logic
    public int numSquares(int n) {
        int []dp = new int[n+1];  // Array to store all the results of dp
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i=1; i <= Math.sqrt(n); i++){  // we eed to traverse only till sqrt(n)
            int sqr = i*i;
              for(int j=sqr; j<=n; j++)
                dp[j] = Math.min(dp[j],dp[j-sqr]+1);
                 }
        
                return dp[n];
            }            
        }  
