/* Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)

Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
*/

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

           List<Integer> result = new ArrayList<Integer>();
          
         if(nums.length == 0)
             return result;
        
        int[] temp = new int[nums.length];
        int[] path = new int[nums.length];
         Arrays.fill(path,-1);
         Arrays.fill(temp,1);
        
         Arrays.sort(nums);
        int index = 0;
         int max = -1;
        
         for(int i=1; i<nums.length; i++)
             for(int j=0; j<i; j++)
                 if( (nums[i] %nums[j]) == 0 ){
                     
                      if(temp[i] < temp[j]+1){
                             path[i] = j;
                             temp[i] = temp[j]+1;
                      }
                     
                     if(temp[i] > max){                           
                         max = temp[i];
                         index =i;
                     }
                 }
                
               System.out.println(Arrays.toString(temp));
               System.out.println(Arrays.toString(path));
        
            result.add(nums[index]);
        
           int i = path[index];
        
         while(i!= -1)
         {
             result.add(nums[i]);
             i= path[i];
         }
        return result;
    }
}
