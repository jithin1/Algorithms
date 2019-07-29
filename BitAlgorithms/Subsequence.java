  /* Codeforces : https://codeforces.com/contest/960/problem/C

      Hint : 1112  = number of non empty subsequences = 8
  */
    import java.util.*;
    import java.io.*;
     
     
     public class Solution{ 
     public static void main(String[] args)throws Exception {
              BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
              PrintWriter out = new PrintWriter(System.out);
              StringTokenizer st = new StringTokenizer(br.readLine()); 
              
              int n = Integer.parseInt(st.nextToken()); 
              int k = Integer.parseInt(st.nextToken()); 
               
              StringBuilder sb = new StringBuilder();
              
              int val=0;
              long prev = 1;
              int ans = 0;
               
                while(n > 0){
                    
                    int last = (n&1);
                    if(last == 1){
                        int i=0;
                        while(i<val){
                            sb.append(prev+" ");
                            i++;
                            ans++;
                        }
                       prev+=k;
                       sb.append(prev+" ");
                       ans++;
                       prev+=k;
                    }
                    n>>=1;
                    val++;
                }
                out.println(ans);
                out.println(sb);
                out.close();
            }
   }
