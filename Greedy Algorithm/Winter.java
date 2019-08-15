// Codeforces : https://codeforces.com/problemset/problem/747/D

  
import java.util.*;
import java.lang.*;
import java.io.*;

   public class Solution
{
		public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] a = new int[n];
		int ptr = 0;
		int[] cnt = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++){
		 a[i] = Integer.parseInt(st.nextToken());
		  if(a[i] < 0)
		   cnt[ptr++] = i;
		}
		if(ptr > k) out.println("-1");
		else if(ptr == 0) out.println("0");
		  else{	
		      int ans = ptr*2;
		      k-=ptr;
		      int[] list = new int[ptr-1];
		      int j = 0;
		      
		      for(int i=1;i<ptr; i++)
		       list[j++] = cnt[i]-cnt[i-1]-1;
		    
		    Arrays.sort(list);
		    for(int l:list){
		        if(l > k)
		         break;
		      k-=l;
		      ans-=2;
		    }
		    
		    if(n-cnt[ptr-1]-1 <=k)ans--;
		     out.println(ans);
		 }
		 out.close();
	}
}
