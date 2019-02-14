class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0,mask = 0;
        for(int i=31; i>=0; i--){
            mask = mask | (1<<i);   // create a mask ex 1111111 
            
            HashSet<Integer> set = new HashSet();
            for(int num : nums)
                set.add(num & mask);   sets all the possible ones
            
            int temp = max | (1 << i);  set temp as max
            for(int prefix : set)
                if(set.contains(prefix ^ temp))
                {
                    max = temp;   // this will ensure that xor of two elements are done
                    break;
                }
        }
        
        return max;
    }
}


   Example
     00101 - 05
     10000 - 16
     01000 - 08
     
     Solution:
     
     the first set bit is 16, now we have two possibilities
      anyways set max as 10000
      next set bit is 1 hence o8 will be selected; now our max is 11000
      
      since int he next iterations max will start with 11000; 05 can never come in the result.
