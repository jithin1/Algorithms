/*
 40. Combination Sum II
 
 Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the
 candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

*/

class Solution {
    
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      boolean[] used;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        int n = candidates.length - 1;
        used = new boolean[n+1];
        Arrays.sort(candidates);       
        
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
            
                   if(i!=n && nums[i] == nums[i+1])  // checks duplicates here
                          continue;
            
                  if(nums[i] <= sum && !used[i]){  // to avoid repetition we use used[i]
                            
                      used[i] = true;
                     sum = sum - nums[i];   // to reduce the sum by the given number                  
                    temp.add(nums[i]);  // add the number to the list
                       
                   combinationSum(nums,sum,i-1,temp); 
                sum = sum + nums[i];  // restore the value of sum
                      
	                   temp.remove(temp.size()-1); 
                       used[i] = false;  // finished back tracking so release the used[i] for further computation
             }   
        }
    }
    
}
