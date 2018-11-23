/*
 Leetcode 650. 2 Keys Keyboard
  Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

    Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
    Paste: You can paste the characters which are copied last time.

Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum 
number of steps to get n 'A'.

Example 1:

Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.

*/

 class Solution {
    public int minSteps(int n) {
        if(n == 1)
            return 0;
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,1000);
        dp[1] = 0;
        int j;
        
        for(int i=1; i <= n/2; i++){       // as we can find n in n/2 iterations in the worst case 
                j=i;            
               if(n % i !=0) // because only the multiples of a number can be taken
                   continue;
            
                 while(j <= n){
                  j=i+j;
                if(j > n)
                    break;
                
                dp[j] = Math.min(dp[i]+j/i,dp[j]);  //Store all the multiples of a number
            }              
        }
              
        
         return dp[n];
    }
}

  Time complexity O(n*n) worst case
  Space complexity O(n)
