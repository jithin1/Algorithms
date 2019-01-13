/*
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.


Note:
You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
Example 1:
Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
*/

class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
          int result = 0;
        
           Comparator<Interval> comp= new Comparator<Interval>(){

             public int compare(Interval a, Interval b){    
                     return a.start - b.start;
             }
         };
        
        Arrays.sort(intervals,comp);
        int len = intervals.length;
        
        int high = 0;
        
        for(int low=1; low < len; low++){
            if(intervals[high].end > intervals[low].start){
                if(intervals[low].end <= intervals[high].end)     //example   [1,4] [2,3]  :- remove [1,4]
                    high = low;
                result++;    // dont increment high as there is a chance that result will remain minimum
            }
            else
                high = low;     // two intervals not overlapping, increment high
               
        }
        
        return result;
    }
}
