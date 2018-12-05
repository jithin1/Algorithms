/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1

*/

class Solution {
    public int singleNumber(int[] nums) {
        int value=0;
        
        for(int i=0; i<nums.length; i++)  // a^a = 0
            value^=nums[i];
        
        return value;
    }
}
