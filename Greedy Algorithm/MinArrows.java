//452. Minimum Number of Arrows to Burst Balloons

/*
There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates
of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter 
suffice. Start is always smaller than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot 
at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. 
The problem is to find the minimum number of arrows that must be shot to burst all balloons.

[[10,16], [2,8], [1,6], [7,12]]
Ans : 2
Example:
*/

class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Comparator<int[]> comp= new Comparator<int[]>(){

             public int compare(int[] a, int[] b){
                 if(a[0] == b[0])
                     return a[1]-b[1];
                 else
                     return a[0]-b[0];
             }
         };  
         
           Arrays.sort(points,comp); 
        int count = 0;
        int len = points.length;
        int j=1; 
        int i=0;
        
        while(i < len){
            
            while(j < len && points[i][1] >= points[j][0]){
                if(points[j][1] < points[i][1]){  // to ensure that appropriate ballons are counted
                    i=j;
                    j++;
                }
                 else
                j++;
            }
            
            count++;
              if(j!= i+1) // we reached a particular baloon from the start
              {
                  i=j;
                  j++;
                  continue;
              }
            i++;  increment
            j++;
        }
        
        return count;
    }
}



 // Solution 2:
  
  public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);  // Sort by end index
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }
    
    
    Time complexity O(nlogn)
