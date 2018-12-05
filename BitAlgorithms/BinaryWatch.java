/*
Leetcode 401. Binary Watch

A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.
*/

class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList();
        for(int h=0; h <= 11; h++)
            for(int min =0; min<=59; min++){
                if(Integer.bitCount(h) + Integer.bitCount(min) == num){
                    result.add(h+ ":"+((min > 9) ? "" :"0")+min);
                }
            }
        return result;
    }
}
