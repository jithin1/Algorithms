/*
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"

    Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.

  Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"

 */

  class Solution {
    int[] factorial;

    ArrayList<Integer> numbers = new ArrayList();
    
    public String getPermutation(int n, int k) {
        factorial = new int[n+1];
        
            factorial[0] = 1;
         for(int i=1; i<=n; i++)
             factorial[i] = i*factorial[i-1];   // calculate factorials and store it in the array
        
        for(int i=1; i<=n; i++)
            numbers.add(i);
        
        k--;
        
        StringBuilder sb = new StringBuilder();

         for(int i=1; i<=n; i++){
  
        int index = k/factorial[n-i];  
        sb.append(String.valueOf(numbers.get(index)));
        numbers.remove(index);
        k-=index*factorial[n-i];
    }
    
    return String.valueOf(sb);
    }
    
}
