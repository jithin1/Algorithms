/*
 Leetcode: 77. Combinations
 
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 
 Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/
class Solution {

     List<List<Integer>> result = new ArrayList<List<Integer>>();
      int end ;
    
    public List<List<Integer>> combine(int n, int k) {
         end =n;
         List<Integer> temp = new ArrayList<Integer>();
         combinations(1,k,temp);
        return result;
    }
    
    public void combinations(int n, int k, List<Integer> temp){
        
        if(k == 0){            
            List<Integer>sol = new ArrayList<Integer>(temp);  // add all elements in temp
            result.add(sol); // store it in result array
            return;
        }
        
         for(int i=n; i <=end; i++){  
                 temp.add(i);             
                 combinations(i+1,k-1,temp);
                  temp.remove(temp.size()-1);  // remove that element after back tracking
         }        
    }   
}
