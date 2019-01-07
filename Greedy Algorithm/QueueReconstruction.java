/*
406. Queue Reconstruction by Height
 
 Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height
 of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to 
 reconstruct the queue.

Note:
The number of people is less than 1,100.

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
*/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
       int nop = people.length;
               
        Comparator<int[]> comp= new Comparator<int[]>(){

             public int compare(int[] a, int[] b){
                   if(a[0] == b[0])
                       return b[1]-a[1];
                 else
                     return a[0]-b[0];
             }

         };  
         
           Arrays.sort(people,comp);  // Sort the array based on height
   
        
         LinkedList<int[]> ans = new LinkedList();
        
        for(int i=nop-1; i>=0; i--)
            ans.add(people[i][1],people[i]);  // insertion based sorting performed her
        

        for(int i=0; i<nop; i++)
            people[i] = ans.get(i);
        
        return people;
    }
}
