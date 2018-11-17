/* LeetCode : 673. Number of Longest Increasing Subsequence

  Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:

Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
*/

class Solution {
    public int findNumberOfLIS(int[] nums) {
        
         if(nums.length == 0)
             return 0;
        
        int []result = new int[nums.length];
         int[] ways = new int[nums.length];
        int length = result.length -1;
        
        Arrays.fill(result,1); // to store the longest subsequences
        Arrays.fill(ways,1); // to store the number of ways to reach a paricular index
        
        for(int i=1; i<result.length;i++)
            for(int j=0;j < i; j++)
                if(nums[i] > nums[j]){

                    if(result[i] < result[j]+1)
                    {
                        result[i] = result[j]+1; 
                        ways[i] = ways[j];  //stores the number of ways to reach a particular number
                    }
                    
                    else if(result[i] == result[j]+1)
                        ways[i] += ways[j];  // if there are multiple ways add the ways found till now
                }
             
              //  System.out.println(Arrays.toString(result)+" "+Arrays.toString(ways));
        
                   int max = result[0];
                int count =1;
        
           for(int i=1; i<length+1; i++){
               if(max < result[i]){
                   max = result[i];
                   count = ways[i]; 
               }
               
               else if(max == result[i])
                   count = count+ways[i];  // to count the total number of ways for all the possible maximun Subsequences
           }

             return count;
    }
}

// Time complexity is O(n*n)
// Space comlexity is O(n).
