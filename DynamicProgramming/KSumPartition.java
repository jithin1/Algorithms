/* Leetcode : 698. Partition to K Equal Sum Subsets
Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose 
 sums are all equal.
 
Example 1:
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
*/

class Solution {
    boolean visited[];
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k)
            return false;
        
          visited = new boolean[nums.length]; // an array to keep track of all the vertex that are visited, to avoid visiting them again
          int sum =0;
         
        Arrays.sort(nums);  // sort the array.
        
        for(int i=0; i<nums.length; i++)
           sum += nums[i];  // find total sum
        
        String s= sum+"";       
        try{
           sum =  Integer.parseInt(s)/k;
        }
        catch(NumberFormatException e){  // if we have a floating value then equal partition cannot be made
            return false;
        }
        
        if(sum < nums[nums.length-1])  // since the last element is greater than the total sum of each partition we cannot make any          //partitions
            return false;
        
        while(k > 0){  // till we find all the partitions run the while loop
            if(sumOfSubsets(nums,sum,nums.length-1))
            k--;  
            
            else
                return false; // cannot make the required partitons
         }
         return true; // found all the partitions
    }
    
     public boolean sumOfSubsets(int[] nums, int sum,int high){
                          
         if(sum == 0)  // we have found one partition here
             return true;
          
          for(int ind = high; ind>=0; ind--){
              if(!visited[ind] && nums[ind] <= sum){  // pruning takes place here. Since the array is sorted, if nums[ind] > sum 
                                                           // we need not go inside the loop as sum will be negative
                  
                  visited[ind] = true;
                      
            if(sumOfSubsets(nums,sum-nums[ind],ind-1))  // search for the next element of the partiton 
               return true;
               
                 visited[ind] = false;  // could not find the required sum with this index, hence set it to false
             }
          }
       return false;  
     }   
}

Time complexity : O(2^n) in worst case.
