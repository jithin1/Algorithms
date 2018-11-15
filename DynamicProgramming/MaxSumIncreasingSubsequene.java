/* Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array such that the 
 intgers in the subsequence are sorted in increasing order. For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output should be
 106  */
 
 
 // Use maximum subsequence logic
 
       import java.util.*;

  class MAxSumIncSubSeq{
    
    public static void convert(int[] a){
        int[] min = new int[a.length];
        
         for(int i=0; i<a.length; i++)
           min[i] = a[i];
           
        int[] actual = new int[a.length];  to store the path
        
        for(int i=1; i< a.length; i++)
         for(int j=0; j<i; j++)
              if(a[j] < a[i]){
                    if(min[i] < a[i]+min[j] ){
                        min[i] = a[i]+min[j];
                        actual[i] = j;
                    }
              }
              
           System.out.println(Arrays.toString(min));  array which has all the min sums.
           System.out.println(Arrays.toString(actual));
          
    }
    
    public static void main(String[] args){
       int a[] = {4,6,1,3,8,4,6};
        convert(a);
     }
    
 }
 
  Time complxity is O(n*n).
