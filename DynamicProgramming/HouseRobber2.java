/*
Leetcode : 213. House Robber II
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this 
place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security 
system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob
tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.

*/

 class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
          
        if(nums.length == 1)
            return nums[0];
        
        if(nums.length == 2)
            return Math.max(nums[0],nums[1]);
   
        int incl = nums[0];
        int excl = 0;
        
        for(int i=1; i<nums.length-1; i++){  // breaking the cycle b excluding the last element
            int temp = incl;
            incl = Math.max(incl,nums[i]+excl);
            excl = temp;
        }
         int sol1 = incl;
        
         incl = nums[1];
         excl = 0;
        
          for(int i=2; i<nums.length; i++){  // now excluding first element and finding the max
            int temp = incl;
            incl = Math.max(incl,nums[i]+excl);
            excl = temp;
        }
        
        return Math.max(incl,sol1); // find the max element
    }
}
