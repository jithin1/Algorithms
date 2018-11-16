/*

LeetCode : 264. Ugly Number II
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
  
*/
class Solution {
    public int nthUglyNumber(int n) {
      int[] num = new int[n];
        
        num[0] = 1;
        
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        
        int factor2 =2;
        int factor3 =3;
        int factor5 =5;
        
        
        for(int i=1; i<n; i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);  // finding the minimum element here
            num[i] = min;
            
            if(min == factor2)  // for incrementing multiples of 2
                factor2 = 2*num[++index2];
            
            if(min == factor3) // for incrementing multiples of 3
                factor3 = 3*num[++index3];
            
            if(min == factor5) // for incrementing multiples of 5
                factor5 = 5*num[++index5];
            
        }
        
        System.out.println(Arrays.toString(num));
        return num[n-1];
    }
}
