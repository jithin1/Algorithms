// Program to find the minimum number of splits to convert a given string to a palindrome

   
    class PalindromicPartition {
    
      public static void convert(String s){
        int n=s.length();
        int[][] t= new int[n][n];
         
         for(int i=0; i<n; i++)
            t[i][i] = 0;
            
       for(int l = 2; l <= s.length(); l++){
            for(int i = 0; i < s.length()-l + 1; i++){
                int j = i + l - 1;
                
                if(isPalindrome(i,j,s))
                  t[i][j] = 0;
                  
                else{
                    int min = Integer.MAX_VALUE;
                    
                   for(int k=i; k<= j-1; k++)
                     if(min > t[i][k]+t[k+1][j] )
                        min = t[i][k]+t[k+1][j];
                        
                       t[i][j] = 1+min;        
                 }
        
          }        
       }
       
         System.out.println(t[0][s.length()-1]);
 }
    
      public static boolean isPalindrome(int i,int j,String s){

                 while(i < j)
                 {
                     if(s.charAt(i) == s.charAt(j))
                       {
                           i++;
                           j--;
                       }
                       
                       else 
                        return false;
                 }
                 
                 return true;
         
      }
    
	public static void main (String[] args) {
	    String s="ponammachehc";
	     convert(s);
 	} 	
 }
 
   Time complexity is O(n*n) n is the length of the string
   Space complexity is O(n*n)
