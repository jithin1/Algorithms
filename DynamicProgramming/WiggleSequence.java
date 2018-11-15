/* 
  LeetCode 376. Wiggle Subsequence
   A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive 
   and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is 
    trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, 
 [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because 
 its last difference is zero.
  
  */
  
  class Solution {
    public int wiggleMaxLength(int[] nums) {
        
         if(nums.length <2 )
             return nums.length;
        
        int up[] = new int[nums.length];
        int down[] = new int[nums.length];
        
        for(int i=1; i<nums.length; i++)
        {
            for(int j=0; j<i; j++)
                if(nums[i] > nums[j])
                    up[i] = Math.max(up[i],down[j]+1);
            
                else if(nums[i] < nums[j])
                    down[i] = Math.max(down[i],up[j]+1);
               
        }
        
         return 1+Math.max(up[nums.length-1],down[nums.length-1]);
    }
}

// Time complexity is O(n*n)

//  Approach 2
  
     class Solution {
    public int wiggleMaxLength(int[] nums) {
        
         if(nums.length <2 )
             return nums.length;
        
        int up[] = new int[nums.length];  // Max up so far
        int down[] = new int[nums.length]; // Max down so far
        
        for(int i=1; i<nums.length; i++)
        {
           if(nums[i] > nums[i-1])
           {
               up[i] = down[i-1]+1;
               down[i] = down[i-1];
           }
            
            else if(nums[i] < nums[i-1]){
                down[i] = up[i-1] +1;
                up[i] = up[i-1];
            }
            
              else{
                  up[i] = up[i-1];
                  down[i] = down[i-1];
              }              
        }
        
         return 1+Math.max(up[nums.length-1],down[nums.length-1]);
    }
}
   
 // Time complexity is O(n)   
