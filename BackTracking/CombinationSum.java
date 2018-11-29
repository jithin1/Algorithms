/*
 Leetcode : 39. Combination Sum
 
 Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in
 candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

*/

class Solution {
    
      List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        Arrays.sort(candidates);       
        int n = candidates.length - 1;
        List<Integer> temp = new ArrayList<Integer>();
        combinationSum(candidates,target,n,temp);
        
        return result;
    }
    
    public void combinationSum(int[] nums,int sum,int n, List<Integer> temp){
        
         if(sum == 0)
         {    List<Integer> ans = new ArrayList<Integer>();
               for(int i: temp)
                   ans.add(i);
          
             result.add(ans);
             return;
         }
        
        for(int i=n; i>=0; i--){
                  if(nums[i] <= sum){
                      
                      int tempsum = sum;  // to preserve the value of sum so as to use it in later iterations
                      
                   tempsum = tempsum-nums[i];
                    int itr=0;
                      
                   while(tempsum >= 0){
                       itr++;
                    temp.add(nums[i]);  
                       
                   combinationSum(nums,tempsum,i-1,temp); // search from i-1th position (search for a
                       tempsum = tempsum-nums[i];  
                }
                      
                           while(itr>0) { 
	                   temp.remove(temp.size()-1);  // remove all the elements of the array since we are not using these sequences
	                   itr--;
	                     }
             }   
        }
    }
    
}
