 //https://codeforces.com/problemset/problem/711/C
 
    import java.util.*;
    import java.lang.*;
    import java.io.*;
     
     
      public class Solution{
         
         static long inf = 100000000000L;
         
     public static long findMin(int[] a,long[][] color, long[][][] dp){
             int N = dp.length-1;
              int K = dp[0].length-1;
              int M = dp[0][0].length-1;
               
               for(int i=0; i<=N; i++)
                  for(int j=0; j<=K; j++)
                    Arrays.fill(dp[i][j],inf);
             
             dp[0][0][0] = 0;
             
             for(int i=1; i<= N; i++){
                 for(int j=1; j<= K; j++){
                   //  dp[i][j][0] = inf;
                     int[] idx = findSubMin(dp[i-1][j-1]);
                     for(int k=1; k <=M;  k++){
                        dp[i][j][k] = dp[i-1][j][k]+color[i][k];
                        
                        if(idx[0] == k)
                        dp[i][j][k] = Math.min(dp[i-1][j-1][idx[1]] + color[i][k], dp[i][j][k]);
                        else
                         dp[i][j][k] = Math.min(dp[i-1][j-1][idx[0]] + color[i][k], dp[i][j][k]);
                    }
                   
                 }
             }
             
             int ans = findSubMin(dp[N][K])[0];
               
              return (dp[N][K][ans] < inf) ? dp[N][K][ans]: -1;
         }
        
        public static int[] findSubMin(long[] dp){
                 int[] idx = {0,0};
            for(int i=1; i<dp.length; i++){
              if(dp[idx[1]] >= dp[i])
               idx[1] = i;
               if(dp[idx[0]] > dp[idx[1]]){
                   int temp = idx[0];
                   idx[0] = idx[1];
                   idx[1] = temp;
               }
            }
             return idx;  
        }
        
        public static void main(String[] args) throws Exception
        { 
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           PrintWriter out = new PrintWriter(System.out);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            int[] a = new int[n];
            long[][] color = new long[n+1][m+1];
            long[][][] dp = new long[n+1][k+1][m+1];
            
            st = new StringTokenizer(br.readLine());
             for(int i=0; i<n ; i++)
              a[i] = Integer.parseInt(st.nextToken());
              
              for(int i=1; i<=n; i++){
                  st = new StringTokenizer(br.readLine());
                  for(int j=1; j<=m; j++){
                   color[i][j] = Integer.parseInt(st.nextToken());
                    if(a[i-1] > 0)
                       color[i][j] = (a[i-1] == j) ? 0:inf;  
                  }
              }
              
              out.println(findMin(a,color,dp));
                 out.close();
        } 
    }
