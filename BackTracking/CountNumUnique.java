/*
Leetcode: 57. Count Numbers with Unique Digits

Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Input: 2
Output: 91 
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, 
             excluding 11,22,33,44,55,66,77,88,99
*/

 class Solution {
            
    public int countNumbersWithUniqueDigits(int n) {
            boolean[] visited  = new boolean[10];        
          return  countDigit(visited,n,0);
        
    }
    
    public int countDigit(boolean[] visited,int level,int depth){
         int count=1;
        
        if(level == depth)
            return 1;       
    
        for(int i= (depth == 0) ?1:0; i<=9; i++){
            
              if(!visited[i]){
            visited[i] = true;
            count+= countDigit(visited,level,depth+1);
             visited[i] = false;
              }
        }
        
        return count;
    }
}
