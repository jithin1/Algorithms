/*
Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Example 1:

Input: "112358"
Output: true 
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
*/

class Solution {
    public boolean isAdditiveNumber(String num) {
        int length = num.length();
        return backTrack(num,0,length,0,0,0);
    }
    
    public boolean backTrack(String num,int level,int length,int ind,long prev,long sum){
        if(ind == length && level > 2)  // check to ensure all the elements are visited and the minimum numbers are 2
            return true;
        
        String n = "";
        for(int i=ind; i<length; i++){
        	
            if( i!=ind && n.charAt(0) == '0') // to move the numbers that starts with 0
                return false;
            
            n+=num.charAt(i);            
             long  temp = Long.parseLong(n); convert the number
             
            
            if(level ==0 || level == 1){   
                if(n.length() > length - i -1) // pruning happens here
                    return false;
                
             if(backTrack(num,level+1,length,i+1,(level == 0) ? temp : prev,prev+temp))
                return true;
            }
            
            else{                
                if(temp < sum) // add more numbers to the set
                    continue;
                
               else if(temp > sum)  // back track
                      return false;
                
                else
                  if(backTrack(num,level+1,length,i+1,sum-prev,(sum-prev+temp))) // go forward
                return true;  
            }         
        }
        return false;
    }
}
