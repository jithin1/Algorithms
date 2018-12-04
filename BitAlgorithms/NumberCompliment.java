/* Leetcode : 476. Number Complement
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
*/

class Solution {
    public int findComplement(int num) {
       int temp = ~0;  // have all ones
        while((num & temp)!=0)  
            temp = temp << 1;  only the positions which we need are 0     
          
        return (~temp) & (~num);  compliment gives the required numbers
    }
}
