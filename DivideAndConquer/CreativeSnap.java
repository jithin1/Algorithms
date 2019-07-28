 // CodeForces : https://codeforces.com/contest/1111/problem/C
 
  import java.util.*;
import java.io.*;
 

 public class Solution{ 
        static long A;
        static long B;
        
        public static int bSearch(int[] a, int low, int high,int val){
            int ans = high+1;
         
         while(low <= high){
             int mid = (low+high)/2;
             if(a[mid] >= val){
                 ans = mid;
                 high = mid-1;
             }
             else
             low = mid+1;
           }
           return ans;
        }
        
        public static long divideAndCon(int[] a, int low, int high, int l, int h){
            if(l > h)
             return A;
             
            else if(low == high)
             return B*(h-l+1);
             
            int mid = (low+high)/2+1;
            int ind = bSearch(a,l,h,mid);
        
            long left = divideAndCon(a,low,mid-1,l,ind-1);
            long right = divideAndCon(a,mid,high,ind,h);

             return Math.min(B*(h-l+1)*(high-low+1),left+right);
        }
        
        public static void main(String[] args)throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          PrintWriter out = new PrintWriter(System.out);
          StringTokenizer st = new StringTokenizer(br.readLine()); 
          
          int n = Integer.parseInt(st.nextToken()); 
          int k = Integer.parseInt(st.nextToken()); 
           A = Long.parseLong(st.nextToken());
           B = Long.parseLong(st.nextToken());
          
          int[] a = new int[k];
          
          st = new StringTokenizer(br.readLine());
          for(int i=0; i<k; i++)
            a[i] = Integer.parseInt(st.nextToken());
           
          Arrays.sort(a);
          
            out.println(divideAndCon(a,1,(1<<n),0,k-1));
            out.close();
        }
}
