Codeforces : https://codeforces.com/contest/1044/problem/A

  // BinarySearch
  
    import java.util.*;
    import java.lang.*;
    import java.io.*;
     
     
     public class Solution{     
      public static int bSearch(int[] a,int val){
              int ans = a.length;
              
               int low = 0;
               int high = a.length-1;
             
               while(low <= high){
                 int mid = (low+high)/2;
                 if(a[mid] >= val){
                     ans = mid;
                     high = mid-1;
                 }
                 else
                 low = mid+1;
              }
                  if(a[ans] == val)
                   ans++;
                  return ans;
         }
     
                public static void main(String[] args)throws Exception {
                  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                  PrintWriter out = new PrintWriter(System.out);
                  StringTokenizer st = new StringTokenizer(br.readLine()); 
                  
                  int n = Integer.parseInt(st.nextToken()); 
                  int m = Integer.parseInt(st.nextToken()); 
        
                  int[] ver = new int[n+1];
                  
                  for(int i=0; i<n; i++){
                    st = new StringTokenizer(br.readLine());
                   ver[i] = Integer.parseInt(st.nextToken());
                  }
                  ver[n] = 1000000000;
                  Arrays.sort(ver);
                  
                  int[]hor = new int[n+1];
                  int cnt=0;
                  int sol = 0;
                  for(int i=0; i<m; i++){
                      st = new StringTokenizer(br.readLine());
                      int x1 = Integer.parseInt(st.nextToken());
                      int x2 = Integer.parseInt(st.nextToken());
        
                      if(x1 > 1)continue;
                      else if(x2 == 1000000000){
                          sol++; continue;}
                          
                      int ind = bSearch(ver,x2);
                      hor[ind]++;
                  }
                    
                   for(int i=n; i>=1; i--)
                    hor[i-1]+= hor[i];
                    
                   int ans = Integer.MAX_VALUE;
                   for(int i=0; i<n; i++)
                        ans = Math.min(hor[i+1]+i,ans);
                      ans = Math.min(ans,n);
                    out.println(ans+sol);
                    out.close();
                }
    }
    
    
    // Two pointer
    
          import java.util.*;
    import java.lang.*;
    import java.io.*;
     
     
     public class Solution{     
                        public static void main(String[] args)throws Exception {
                  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                  PrintWriter out = new PrintWriter(System.out);
                  StringTokenizer st = new StringTokenizer(br.readLine()); 
                  
                  int n = Integer.parseInt(st.nextToken()); 
                  int m = Integer.parseInt(st.nextToken()); 
        
                  int[] ver = new int[n];
                  
                  for(int i=0; i<n; i++){
                    st = new StringTokenizer(br.readLine());
                   ver[i] = Integer.parseInt(st.nextToken());
                  }
               
                  int[]hor = new int[m];
                  int cnt=0;
                  for(int i=0; i<m; i++){
                      st = new StringTokenizer(br.readLine());
                      int x1 = Integer.parseInt(st.nextToken());
                      int x2 = Integer.parseInt(st.nextToken());
        
                      if(x1 > 1)continue;
                      hor[cnt++] = x2;
                  }
                   hor = Arrays.copyOfRange(hor,0,cnt);
                   Arrays.sort(ver);
                   Arrays.sort(hor);
                   
                   int ans = Integer.MAX_VALUE;
                   int j=0;
                   int i=0;
                   for(; i<=n; i++){
                       while(j < cnt && hor[j] < ((i==n) ? 1000000000 :ver[i]))
                        j++;
                        
                        ans = Math.min(cnt-j+i,ans);
                   }
                    out.println(ans);
                    out.close();
                }
    }
