   // https://codeforces.com/contest/1073/problem/C
   
   // Use binary search and find if for some subarray, the solution is possible or not
   
   import java.util.*;
      import java.io.*;
         
      public class Solution{
         static int n;
         
       public static boolean findAns(int len,int[] x, int[] y, int dx, int dy){
         for(int i=0; i<=n-len; i++){
             int mx = x[n]-x[len+i]+x[i];
             int my = y[n]-y[len+i]+y[i];
             
             int dif = Math.abs(dx-mx)+Math.abs(dy-my);
             if(dif <= len && (len- dif)%2 == 0)
              return true;
         }
          return false;
       }   
       
       public static void main (String[] args) throws java.lang.Exception
        	{
        	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	    PrintWriter out = new PrintWriter(System.out);
        	     n = Integer.parseInt(br.readLine());
        	    String s = br.readLine();
        	    
        	    StringTokenizer st = new StringTokenizer(br.readLine());
        	    int dx = Integer.parseInt(st.nextToken());
        	    int dy = Integer.parseInt(st.nextToken());
        	    
        	    int[] x = new int[n+1];
        	    int[] y = new int[n+1];
        	    
        	    
        	    for(int i=0; i<n; i++){
        	        x[i+1] = x[i];
        	        y[i+1] = y[i];
        	           if(s.charAt(i) == 'U')
        	             y[i+1]++;
        	           else if(s.charAt(i) == 'D')
        	             y[i+1]--;
         	           else if(s.charAt(i) == 'L')
        	              x[i+1]--;
        	           else
        	             x[i+1]++;
        	    }
        	    
        	    if( x[n] == dx && y[n] == dy){
        	       out.println(0);
        	       out.close();
        	    }
        	    
        	     int dif = Math.abs(x[n]-dx)+Math.abs(y[n]-dy);
               
                if(dif%2 != 0 || Math.abs(dx)+Math.abs(dy) > n) out.println(-1);
                
        	    else{
        	       int ans = 0;
        	       int low = 1,high=n;
        	       while(low <= high){
        	           int mid = (low+high)/2;
        	           
        	           if(findAns(mid,x,y,dx,dy)){
        	               high = mid-1;
        	                ans = mid;
        	           }
        	           else 
        	            low = mid+1;
        	       }
        	       out.println(ans);
        	    } 
   
        	   out.close();
        }
}
