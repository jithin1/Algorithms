/*
Leetcode : 526. Beautiful Arrangement

 Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully
 if one of the following is true for the ith position (1 <= i <= N) in this array:

    The number at the ith position is divisible by i.
    i is divisible by the number at the ith position.

Now given N, how many beautiful arrangements can you construct? 

 Input: 2
Output: 2
*/

class Solution {
	    int count = 0;
	    int nums[];
	    public int countArrangement(int N) {
	        nums = new int[N+1];
	        
	            for(int i=1; i<=N; i++)
	                nums[i] = i;
	        
	            permute(1,N);
	            return count;
	    }
	    
	    public void permute(int low, int high){
	        if(low == high){
                
                if( (nums[high] %high !=0) && high %nums[high] !=0) 
                    return;
                
	          count++;
                return;
	        }
	        	            
	            for(int i=low; i <= high;i++)
	            {
	                swap(i,low); 
	                
	                 if( (nums[low] % low != 0) && (low % nums[low] !=0) {  // prunning happens here (No need to go forward)
	                     swap(i,low); 
	                     continue;
	                 }
	                
	                permute(low+1,high);
	                swap(i,low); 
	            }
	        }
	    
	    public void swap(int i,int j){
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	   }
}

// Time Complexity is O(P) where P is the number of allowed permutations
//   Space complexity is O(N)
