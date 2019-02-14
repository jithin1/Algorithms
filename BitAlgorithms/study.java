
            1)  Get position of first bit  

      class GFG { 
 
  
    public static int getFirstSetBitPos(int n) 
    { 
         return (int)((Math.log10(n & -n)) / Math.log10(2)) + 1; 
   
                      } 
  
    
    

          public static void main(String[] args) 
    { 
     
             int n = 12; 
 
        System.out.println(getFirstSetBitPos(n)); 
    } 

    } 



            2) efficient way to swap numbers

    x = x^y
    y = x^y // effectively it is x^y^y = x
    x = x^y  // effectively it is x^y^x = y


             3) Adding two numbers without using +. -

    class Solution {
    public int getSum(int a, int b) {
      int c; 
      while(b !=0 ) {
        c = (a&b);
        a = a ^ b;
        b = (c)<<1;
      }
      return a;
        
       }
  }

                  4) Missing Number

   Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

   class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        
       for(int i=1; i <=nums.length; i++)
           result ^=i^nums[i-1];   // use xor rule
        
          return result;
      }
 }

              5) Find greatest of two numbers without uising  '>'

    y + ((x - y) & ((x - y) >>(sizeof(int) * CHAR_BIT - 1)))
   This method shifts the subtraction of x and y by 31 (if size of integer is 32). If (x-y) is smaller than 0, then (x -y)>>31 will be 1. If (x-y) is greater than or equal to 0, then (x -y)>>31 will be 0.
   So if x >= y, we get minimum as y + (x-y)&0 which is y.
   If x < y, we get minimum as y + (x-y)&1 which is x.

   Similarly, to find the maximum use

     x - ((x - y) & ((x - y) >> (sizeof(int) * CHAR_BIT - 1)))


               6) Maximum XOR of Two Numbers in an Array

      public class Solution {
      public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;

        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                 }
             }
         }

          return max;
      }
   }

   7)  Find the element that appears once
Given an array where every element occurs three times, except one element which occurs only once. Find the element that occurs once. 
Expected time complexity is O(n) and O(1) extra space.

  class GFG 
{ 
    // Method to find the element that occur only once 
    static int getSingle(int arr[], int n) 
    { 
        int ones = 0, twos = 0; 
        int common_bit_mask; 
          
        for(int i=0; i<n; i++ ) 
        { 
            /*"one & arr[i]" gives the bits that are there in 
            both 'ones' and new element from arr[]. We 
            add these bits to 'twos' using bitwise OR*/
            twos = twos | (ones & arr[i]); 
  
            /*"one & arr[i]" gives the bits that are 
            there in both 'ones' and new element from arr[]. 
            We add these bits to 'twos' using bitwise OR*/
            ones = ones ^ arr[i]; 
  
            /* The common bits are those bits which appear third time 
            So these bits should not be there in both 'ones' and 'twos'. 
            common_bit_mask contains all these bits as 0, so that the bits can  
            be removed from 'ones' and 'twos'*/
            common_bit_mask = ~(ones & twos); 
                          
            /*Remove common bits (the bits that appear third time) from 'ones'*/
            ones &= common_bit_mask; 
                          
            /*Remove common bits (the bits that appear third time) from 'twos'*/
            twos &= common_bit_mask; 
        } 
        return ones; 
    } 
      
    //  Driver method 
    public static void main(String args[]) 
    { 
        int arr[] = {3, 3, 2, 3}; 
        int n = arr.length; 
        System.out.println("The element with single occurrence is " + getSingle(arr, n)); 
    } 


 8) Total Hamming Distance

  The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
  Now your job is to find the total Hamming distance between all pairs of the given numbers.

    class Solution {
	
     int count =0;
     public int totalHammingDistance(int[] nums) {
        int count=0;
        int temp =0;
        int n = nums.length;
        
        for(int i=0; i <32; i++){
            temp = 0;
             for(int j=0; j< n; j++){
                  temp+= ((nums[j] >> i) & 1);
             }
                 count += temp*(n-temp);
        }     
        
        return count;
     }
 }

 9)  Integer Replacement


