/*
Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the 
player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This 
continues until all the scores have been chosen. The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

Example 1:

Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
Hence, player 1 will never be the winner and you need to return False.

*/

// Brute Force Time Complexity(2^n)
  

class Solution {
        
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length ==1)
            return true;
        
        int high = nums.length-1;
        return DFS(nums,0,high,0,0,1);
    }
    
    public boolean DFS(int[] nums, int low, int high,int score1,int score2,int player){
        
        if(low == high){ // when we reach the end of the array
            
            if(player %2 == 0)
                score2 = score2 + nums[low];
            else
                score1 = score1+nums[low];
            
            if(score1 >= score2){
                
                if((player %2) != 0)
                return true;                
                else 
                    return false;
            }
            
            else{
                
                if(player %2 == 0)
                    return true;                
                else 
                    return false;
            }                           
    }
        
        
           if(player %2 == 0) // if player 2
               score2 += nums[low];
        
           else // if player 1
              score1 +=nums[low];
        
        if(!DFS(nums,low+1,high,score1,score2,player+1)){
            return true;
        }
        
        
            if(player%2 == 0){ 
                score2 = score2 - nums[low];
               score2 += nums[high];
            }
                
           else {         // if player 1
              score1 = score1 - nums[low];
              score1 +=nums[high];
           }
        
         if(!DFS(nums,low,high-1,score1,score2,player+1)){             
            return true;
        }
         return false;
    }
}

 // Dynamic problem solution with Time complexity is O(n*n)
  // Space Complexity is O(n*n)

public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        
        for(int i=0; i<nums.length; i++)
            dp[i][i] = nums[i];
        
        for (int s = nums.length-2; s >= 0; s--) {
            for (int e = s + 1; e < nums.length; e++) {
                int a = nums[s] - dp[s + 1][e];
                int b = nums[e] - dp[s][e - 1];
                dp[s][e] = Math.max(a, b);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] nums = {4,9,3,2};
    	System.out.println(s.PredictTheWinner(nums));
    }
}

 /*
  4   0   0   0
      9   0   0
          3   0
              2
              
    4   0   0   0
        9   0   0
            3   (3-2)
                2 
              
      4   0     0     0
          9   (9-3)   0
                3   (3-2)
                      2 
      
       4   0     0     0
          9   (9-3)   9 - (3-2)
                3     (3-2)
                       2
                       
                       ......
 */
