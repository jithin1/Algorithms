/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
*/

class Solution {
    List<String> result = new ArrayList<String>();
   
   public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        findIpAddresses(0,s,"",0,n);
       return result;
   }
   
   public void findIpAddresses(int ind,String s,String sol,int level,int length){
       if(level == 4 )
       {
            if(sol.length() < length+4)
                return;
           
           sol = sol.substring(0,sol.length()-1); 
           result.add(sol);
           return;
       }
       
       String str ="";
       
       for(int i=ind; i<length && i <=ind+2; i++){         
           
             if(i != ind && str.charAt(0) == '0') 
                 return;
           
           str+=s.charAt(i);
             int temp = Integer.parseInt(str);
           
            if(temp>255)
                return;
           
              findIpAddresses(i+1,s,sol+str+".",level+1,length);
           
       }
   }
}
