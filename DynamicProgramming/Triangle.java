/* 
 Leetcode 120. Triangle
 
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).   
   
   */
   
   // Bottom up dynamic programming // pretty fast.
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       int n = triangle.size();
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if(i == n - 1)
                     dp[j] = triangle.get(i).get(j);  // fill all the bottom layer
                    else
           // take the best from bottom layer and add it to the current top layer             
                       dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j); 
            }
        }
        return dp[0];
    }
}
    
 // Top down dynamic programming (Time consuming). We can find all the path distances using this approach
  class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    if(triangle.size() == 0)
        return 0;
        
     else if(triangle.size() == 1)
         return  triangle.get(0).get(0);
        
   int sum[] = new int[triangle.size()];
         sum[0] = triangle.get(0).get(0)+triangle.get(1).get(0);
         sum[1] = triangle.get(0).get(0)+triangle.get(1).get(1);
        
        for(int i=1; i<triangle.size() -1; i++){
                          int temp1 = sum[0];
                          int temp2 = sum[1];
            
             for(int j=0; j<triangle.get(i).size(); j++){                  
                 if(j ==0)
                     sum[j] += triangle.get(i+1).get(j);
                 
                 else
                     sum[j] = Math.min(triangle.get(i+1).get(j)+temp2,sum[j]);
                     
                                                         
                  if(j+1 == triangle.get(i+1).size() -1){                       
                      int ind = triangle.get(i+1).size()-1;
                         sum[j+1] = triangle.get(i+1).get(ind)+temp1;  
                           continue;
                      }
                            temp2 = sum[j+1]; // to store the currrent next value

                         sum[j+1]= triangle.get(i+1).get(j+1)+temp1;
                          temp1 = temp2;  update temp1

                }
                                
            }
                  
            int temp= Integer.MAX_VALUE;
           // find the max value
           
             for(int val: sum)
                 if(temp > val)
                     temp = val;
        
          return temp;
    }
}
