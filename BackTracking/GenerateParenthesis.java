/*
Leetcode : 22. Generate Parentheses

 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

*/

class Solution {
    public List<String> generateParenthesis(int n){
        
        List<String> result = new ArrayList<String>();
        parenthesis("",n,result,0,0);
        return result;
    }
    
    public void parenthesis(String s,int n,List<String> result,int open,int close){
           
           if(s.length() == 2*n)
           {
               result.add(s);  
               return;
           }
        
             if(open < n)
                 parenthesis(s+"(",n,result,open+1,close);
        
              if(close < open)  // to maintain balanced paranthesis
                  parenthesis(s+")",n,result,open,close+1);
        
        }
    }
