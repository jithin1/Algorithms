/*
Given a set of distinct integers, nums, return all possible subsets (the power set)

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
            List<Integer> temp = new ArrayList<Integer>();

        findSubsets(nums,result,0,temp,nums.length);
         
        result.add(new ArrayList<Integer>());
        return result;
        
    }
    
    public void findSubsets(int[] nums,List<List<Integer>> result, int level,List<Integer> temp,int n){
        if(level == n) // depth of the space tree
            return;
        
        for(int i=level; i<n; i++){
            temp.add(nums[i]);
            findSubsets(nums,result,i+1,temp,n);
             List<Integer> sol = new ArrayList(temp);
             result.add(sol);  
             temp.remove(temp.size()-1); // search further combinations
        }            
    }
}
