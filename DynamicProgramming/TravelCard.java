/* 
Codeforces : https://codeforces.com/problemset/problem/756/B
*/

import java.io.*;
import java.util.*;

public class Main  {
    public static void main(String[] args)throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class TaskD {
        public void solve(int testNumber, BufferedReader in, PrintWriter out)throws Exception{
            int n = Integer.parseInt(in.readLine());
            int[] t = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                t[i] = Integer.parseInt(in.readLine());
            }
            
            int[] dp = new int[n+1];
            int ninety = 1;
            int day = 1;
        
            for(int i=1; i<=n; i++){
                    
                    while(t[ninety] <= t[i]-90)ninety++;
                    while(t[day] <= t[i]-1440)day++;
 
                   dp[i] = Math.min(dp[i-1]+20,Math.min(dp[ninety-1]+50,dp[day-1]+120));
                   out.println(dp[i]-dp[i-1]);

        }
     }
  }
}
