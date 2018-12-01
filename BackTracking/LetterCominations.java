/*
LeetCode 17 : Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

class Solution {
     HashMap<Character,String> mapping = new HashMap();
     List<String> result = new ArrayList<String>();
    
    public List<String> letterCombinations(String digits) {
           int length = digits.length();
           if(length == 0)
              return result;
        
             mapping.put('2',"abc");
             mapping.put('3',"def");
             mapping.put('4',"ghi");
             mapping.put('5',"jkl");
             mapping.put('6',"mno");
             mapping.put('7',"pqrs");
             mapping.put('8',"tuv");
             mapping.put('9',"wxyz");
         
        
         findCombinations(digits,0,length,"");
        return result;
        
    }
    
     public void findCombinations(String digits,int level,int length,String sol){
         if(length == level){  // pring thr solution as we reached the length of the digit string
             result.add(sol);
             return;
         }
         
           char n = digits.charAt(level);  // get the character at that particular level
           String s = mapping.get(n); // get the string from the mapping
         
         for(int i=0; i<s.length(); i++){
              findCombinations(digits,level+1,length,sol+s.charAt(i));  // recursive calls to perfom back tracking
         }
          
     }
}
