class Solution {
    
  public boolean isPowerOfTwo(int n) {
 
       
        if( n <=0 || (n & (n-1)) != 0)  // n & (n-1) is used to check whether there is only one power of 2
       
                return false;
        

             return true;
 
         }
   
}
