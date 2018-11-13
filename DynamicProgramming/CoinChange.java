/*   
Leetcode 322. Coin Change

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = amount;
        
        int[] temp = new int[m+1];
        int[] value = new int[m+1];
        
        int inf = Integer.MAX_VALUE - 1;
        temp[0] = 0;
        
        for(int i=1; i<=m; i++){
            temp[i] = inf;
        }
        
        for(int i=0; i<coins.length; i++)
            for(int j=1; j<temp.length; j++){                
                if(coins[i] <= j)
                    if(temp[j] > temp[j -coins[i]]+1){
                        temp[j] = temp[j-coins[i]]+1;
                    }
                }
           if(temp[m] == inf)
               return -1;
         else
             return temp[m];
    } 
}
