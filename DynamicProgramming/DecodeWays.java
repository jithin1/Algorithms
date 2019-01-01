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
      
      //Method 2
      
     // Intuition : staircase problem logic
      
      public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
