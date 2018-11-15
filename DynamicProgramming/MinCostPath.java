/*
   Minimum Path Sum

  You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

*/

    import java.util.*;

  class MinCostPath{
    
    public static void calculate(int[][] t){
        
        for(int i=1; i<4; i++)
          t[0][i]+= t[0][i-1];
          
          for(int i=1; i<3; i++)
           t[i][0]+= t[i-1][0];
           
           for(int i=1; i<3; i++)
             for(int j=1; j<4; j++)   // using dynamic programming concept to calculate the remaining part of thr array
              t[i][j] = Math.min(t[i-1][j] , t[i][j-1]) + t[i][j];
              
              System.out.print(t[2][3]);
    }
    
       
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int t[][] = new int[3][4];
         
         for(int i=0; i<3; i++)
          for(int j=0; j<4; j++)
             t[i][j] = s.nextInt();  // exapmle array
              
        calculate(t);
      }
     
  }

 time Complexity is O(n*n)
 
