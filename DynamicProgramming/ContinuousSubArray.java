 /* Leetcode : 523. Continuous Subarray Sum

  Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of
  size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

Example 1:

Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 */
         class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
         LinkedList<Integer> queue = new LinkedList<Integer>();
          k =Math.abs(k);
          int n= nums.length;
        
           for(int i=0; i<n-1; i++){
                int sum = nums[i]+nums[i+1];
        
            if(k ==0 && sum == 0)
                return true;
        
            else if(k!=0 && sum%k ==0)
                return true;  
               
            queue.add(sum);
           }
        
          if(k ==0)
              return false;
        
         for(int l=2; l<nums.length; l++)
         {  
             LinkedList<Integer> temp = new LinkedList<Integer>();
             
             for(int i=0; i<queue.size()-1;i++){
                 
                 int j=i+l;
              int sum = queue.peek()+nums[j];
                 
               if(sum % k ==0)
                    return true;
                 
              temp.add(sum);
             
         }
             queue = temp;
     }  
           return false;
       
    }
        
}
                
  Time Complexity O(n*n)
