
// https://codeforces.com/problemset/problem/553/A

import java.util.*;
import java.lang.*;
import java.io.*;

  class Codechef
{
     static int mod = 1000000007;
    public static long[][] findCombinations(){
        long[][] dp = new long[1002][1002];
        
        dp[0][0] = 1;
        
        for(int i=1; i<dp.length; i++){
            dp[i][0] = 1;
            for(int j=1; j<=i; j++)
             dp[i][j] = (dp[i-1][j]+dp[i-1][j-1])%mod;
        }
        
        return dp;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		long[][] dp = findCombinations();
		
		long res = 1;
		int total=0;
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++){
		    int temp = Integer.parseInt(br.readLine());
		    res = (res*dp[total+temp-1][temp-1])%mod;
		    total+=temp;
		}
		
     	   out.println(res);
	       out.close(); 
	}
}
