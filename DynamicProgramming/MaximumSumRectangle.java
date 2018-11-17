/*Given a two dimensional rectangle array containig both positive and negative numbers
 We have to return the maximum sum of any rectangle sub array
*/

import java.util.*;
  class MaxSumSubArray{
       
          static int cur_sum;
          static int max_sum=Integer.MIN_VALUE;
          static int max_left=0;
          static int max_right=0;
          static int max_up=0;
          static int max_down=0;

    public static void max_sum(int[][] in){

          int r[] = new int[4];

         for(int col=0; col<5; col++){
             
              for(int i=0; i<4; i++)
                 r[i]=in[i][col];
                 
                kadanes(r);
                
                if(max_sum < cur_sum){
                max_sum = cur_sum;
                 max_left = col; // as we are in that particular column
                 max_right = col;  // as we are in that particular column
            }
              
              for(int c=col+1; c<5; c++){
                  
                 for(int i=0;i<4;i++)
                   r[i]= r[i]+in[i][c];
                   
                   kadanes(r);
                   
                if(max_sum < cur_sum){
                max_sum = cur_sum;
                 max_left = col; // as we are in that particular column
                 max_right = c;  // as we are in that particular column
                   } 
              }
         }
         
          System.out.println("left "+max_left+" right "+max_right+" up "+max_up+" down "+max_down+" sum "+max_sum);  
    }  
    
      public static void kadanes(int[] r){
           int top=0;
           int max_tillnow = 0;
           
          for(int i=0;i<r.length; i++){
               max_tillnow += r[i];
               
               if(cur_sum < max_tillnow){
                   
                       max_up = top;  // find the top
                   
                     max_down = i;   
                     cur_sum = max_tillnow;  // update the cur_sum
               }
                 
                 if(max_tillnow < 0){
                      top= i+1;
                    max_tillnow = 0;
                 }
                 
            }

      }
    
    public static void main(String[] args){
        int[][] input= new int[4][5];
             Scanner s= new Scanner(System.in);
             
            for(int i=0; i<4; i++){
              for(int j=0; j<5; j++)
               input[i][j]=s.nextInt();
            }
            
              max_sum(input);
           

       }    
   }

 Time complexity is O(n*n)
 Space complexity is O(n)
