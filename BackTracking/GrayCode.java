/*
Leetcode : 89. Gray Code

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence 
must begin with 0.

Example 1:

Input: 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2

*/

 class Solution {
    int sol =0;
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
         
        backTrack(0,n,result);
        return result;
    }
    
      public int backTrack(int l,int n, List<Integer> result){
          if(l == n)
          {
               result.add(sol);
               return sol;
           }
                sol = backTrack(l+1,n,result);  // do nothing
                sol = sol ^ (1 << (n-l-1));  // Left shift 1 and perform xor to invert the bit at that particulat position
                backTrack(l+1,n,result); // go forward
          
          return sol;
      }
}
