/*
  Leetcode : 96. Unique Binary Search Trees
  
   Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


*/

    class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        
      dp[1] = 1;
        
    for(int l = 2; l <= n; l++){
              
         for(int k=1; k<=l; k++){
         //    dp[3] = dp[2]+ dp[1]*dp[1] + dp[2]
         
              if(k == 1)  
                dp[l] = dp[l-k];
             
              else if(k == l)
                  dp[l]+= dp[k-1];
              else
                 dp[l]+=dp[k-1]*dp[l-k];
         }      
      }
         
       // System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
