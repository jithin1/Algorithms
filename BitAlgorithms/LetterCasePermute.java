/*
Leetcode : 784. Letter Case Permutation

Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all
possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

*/

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<String>();
        int n = S.length();
         permute(S,result,"",0,n);
        return result;
    }
    
      public void permute(String S,List<String> result, String sol,int ind,int n){
          if(ind == n){   
              result.add(sol);  // add all the possible results
              return;
          }          
              permute(S,result,sol+S.charAt(ind),ind+1,n);                   
              if((S.charAt(ind) & (char)64) >= (char)64 )   // to check whether it is a character
              {                                      
                      permute(S,result,sol+(char)(S.charAt(ind)^(char)32),ind+1,n);  // to invert the bit and change the case
              }                   
      }
}
