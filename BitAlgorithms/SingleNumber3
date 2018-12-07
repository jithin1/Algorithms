/*
Leetcode : 260. Single Number III


Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the
two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
*/

class Solution {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
         int n[] = new int[2];
        
        for(int i=0; i<nums.length; i++)
            sum ^=nums[i];
            
        int pos = sum & -sum;  
         int  p=0, q=0;
        
        for(int i=0; i<nums.length; i++){
            if( (nums[i] & pos) == 0)
                n[1] ^=nums[i];
             else
                n[0] ^=nums[i];
        }
        return n;
    }
}
