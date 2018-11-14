 class PalindromicSubsequence{
     
     public void palindromicSubsequence(String s){
         
         int temp[][] = new int[s.length()][s.length()];
         
         for(int i=0; i<s.length(); i++)
           for(int j=0; j<s.length(); j++)
             temp[i][i] = 1;
             
         for(int l=2; l <= s.length(); l++)
          for(int j=0; j < s.length()-l; j++){
              int k = j+l-1;
              
              if( (s.charAt[j] == s.charAt[k]) && l==2)
                 temp[j][k] = 2;
                 
              else if(s.charAt(j) == s.charAt(k))
                  temp[j][k] = temp[j+1][k-1]+2;
                  
              else
                 temp[j][k] = Math.max(temp[j+1][k],temp[j][k-1]);
              
          }
          
          System.out.println(temp[0][s.length()-1]);
     }
     
     public static void main(String[] args){
         String s = "abcdaaefbab";
         palindromicSubsequence(s);
     }
 }
 
 //Time complexity is O(n*n)
   // Space complexity is O(n*n)
