/*
Leetcode : 190. Reverse Bits

Reverse bits of a given 32 bits unsigned integer.

Example:

Input: 43261596
Output: 964176192
Explanation: 43261596 represented in binary as 00000010100101000001111010011100, 
             return 964176192 represented in binary as 00111001011110000010100101000000.
*/

public class Solution {

    int result = 0;
    public int reverseBits(int n) {
        int count =0;
        while(count < 32){   // perform for all bits in the unsigned iteger     
            result <<=1;  // left shift
            result += n&1; // add one to the end
            n >>=1; // right shift the number
            count++; 
        }
            return result;
    }
}
