/*
Leetcode 338. Counting Bits

Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary
representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
*/

// Thinking process
000 : Step 0
001 : Step 1
010 : Step 2
011 : Step 3 = step 1 + 1
100 : Step 4
101 : Step 5 = Step 1 +1
110 : Step 6 = Step 2 +1
111 : Step 7 = Step 3 +1
1000 : Step 8

    When a number is a power of 2, we simply assign array[i] = 1
class Solution {
public int[] countBits(int num) {
int[]result = new int[num+1];
result[0] = 0;
int mask=1;
int j=0;

    for(int i=1; i<=num; i++)
    {
        if((mask & i) == i){  // to check the powers of 2
            result[i] =1;
            mask<<=1;  // left shift i to get the next power of 2
            j=1;  // reassigning to step 1
        }
        
        else{
      
            result[i] = result[j]+1;   
                j++;  // increment step
        }
    }
    
    return result;
  }
}
