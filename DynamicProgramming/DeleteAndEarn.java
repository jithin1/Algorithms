/*
Leetcode : 740. Delete and Earn
 Given an array nums of integers, you can perform operations on the array.

In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or
nums[i] + 1.

You start with 0 points. Return the maximum number of points you can earn by applying such operations.

Example 1:

Input: nums = [3, 4, 2]
Output: 6
Explanation: 
Delete 4 to earn 4 points, consequently 3 is also deleted.
Then, delete 2 to earn 2 points. 6 total points are earned.

*/

  // Use house robber logic
  
  class Solution {
    public int deleteAndEarn(int[] nums) {
        
         if(nums.length == 0)
             return 0;
         
             if(nums.length == 1)
             return nums[0];
        
        Arrays.sort(nums);
        int sum=nums[0];
        
        int i=0;
         int incl =0;
         int excl =0;
        
        
            while(nums[i+1] == nums[i]){
                sum+=nums[i+1];
                i++;
            }

         incl = sum;       
           i++;
            sum =0;
        int max = Integer.MIN_VALUE;
        
        while(i < nums.length){
            if(nums[i-1] == nums[i]-1)
                sum+=excl; // add non adjacent element
             else
                 sum+= incl; //add adjacent element
            
            sum+=nums[i];
            while(i!=nums.length-1 && nums[i+1] == nums[i]){  // add all the adjacent elemnets in the array if they are equal
                sum+=nums[i+1];
                i++;
            }
             int temp = incl; 
            
            incl = Math.max(sum,incl);
             excl = temp; // get the best excluded element so far
            
             if(incl > max)
                 max= incl;
            
            sum = 0;
            i++; // to increment i
        }

                
        return max;
    }
}
