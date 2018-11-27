/*
Leetcode : 46 Permutations

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]


*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
            permute(nums,0,nums.length-1,result);
         return result;
    }
    
    public void permute(int[] nums,int low, int high,List<List<Integer>> result){
        if(low == high){
            List<Integer> temp = new ArrayList<Integer>(); // ArrayList to store the result of current permutation
            
             for(int i:nums)
                 temp.add(i);            
             result.add(temp);
        }
        
        else{
            
            for(int i=low; i <= high;i++)
            {
                swap(i,low,nums); // permutations happens here
                permute(nums,low+1,high,result);
                swap(i,low,nums); // get back the original array
            }
        }
    }
    
    public void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
