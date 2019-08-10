     // https://codeforces.com/contest/981/problem/D
     
     import java.util.*;
        import java.io.*;
         
        public class Solution
        {
             static int k;
             static int n;
             static long[] s;
             public static boolean Find(long mask){
                 boolean[][] dp = new boolean[n+1][k+1];
                 dp[0][0] = true;
                 
                 for(int i=1; i<=n; i++){
                     for(int j=0; j<i; j++){
                         if( (s[i]-s[j] & mask) == mask){
                             for(int x=0;x<k; x++)
                                 if(dp[j][x]) dp[i][x+1] = true;
                             
                         }
                     }
                 }
                 return dp[n][k];
             }
             
        	public static void main (String[] args) throws java.lang.Exception
        	{
        	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	    PrintWriter out = new PrintWriter(System.out);
        	    StringTokenizer st = new StringTokenizer(br.readLine());
        	    
        	     n = Integer.parseInt(st.nextToken());
        	     k = Integer.parseInt(st.nextToken());
        	    
        	    long[] a = new long[n];
        	    s = new long[n+1];
        	    
        	    st = new StringTokenizer(br.readLine());
        	    for(int i=0; i<n; i++){
        	     a[i] = Long.parseLong(st.nextToken());
        	     s[i+1] = s[i]+a[i];
        	    }
        	     
        	     long ans = 0;
        	     for(long i=56; i>=0; i--)
        	     if(Find(ans|1L<<i)) ans|=(1L <<i);
        	     
        	     out.println(ans);
        	     out.close();
        	}
        }
