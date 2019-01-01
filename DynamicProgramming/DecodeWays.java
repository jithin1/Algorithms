/* 
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.
*/

class Solution {
    int ways=0;
    public int numDecodings(String s) {
          HashMap<Integer,Integer> map = new HashMap();
          int len = s.length();
          findNumDecode(s,0,map,len);
        return ways;
    }
    
    public void findNumDecode(String s,int pos,HashMap<Integer,Integer> map,int len){
            if(map.containsKey(pos)){
                ways+=map.get(pos);
                return;
            }
        
        if(pos == len){
            ways++;
            return;
        }
        for(int i=pos; i<len && i<pos+2; i++){
            if(s.charAt(pos) == '0')
                return;
            String temp = s.substring(pos,i+1);
            int dig = Integer.parseInt(temp);
            
            if(dig >26)
                return;
            
            findNumDecode(s,i+1,map,len);
            
        }
            map.put(pos,ways);
    }
    
}

  Space complexity = O(n)
