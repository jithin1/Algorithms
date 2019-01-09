/*
Leetcode : 891 
The i-th person has weight people[i], and each boat can carry a maximum weight of limit.

Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.)

 

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)

*/
// Intuition : 
Use two pointer approach

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int len = people.length;
        int not = 0;
        int high = len-1;
        int low = 0;
        int nop=0;
        for(; low < high; low++){
            while(high > low && people[low]+people[high] > limit)
                high--;
            if(high !=low)  // to ensure that the same person is not counted
                nop++;
            not++;  // increment the number of trips
            nop++; // increment the number of people
            high--;  // decrement high
        }
        return not+ len- nop;
    }

}
