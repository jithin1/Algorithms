/* https://codeforces.com/contest/1096/problem/D

H  A  H  A  R  D
   3  8  5  2 16 18

Remove first H and last A */


import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter out = new PrintWriter(System.out);
	    
	    int n = Integer.parseInt(br.readLine());
	    String s = br.readLine();
	    
	    int[] a = new int[n];
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    for(int i=0; i<n; i++)
	     a[i] = Integer.parseInt(st.nextToken());
		       
	     long[] min = new long[4];
	     
	     for(int i=0; i<n; i++){
	         if(s.charAt(i) == 'h')
	          min[0]+=a[i];
	         
	          else if(s.charAt(i) == 'a'){
	          min[1]+=a[i];
	           min[1] = Math.min(min[0],min[1]);
	          }
	          else if (s.charAt(i) == 'r'){
	           min[2]+=a[i];
	           min[2] = Math.min(min[2], min[1]);
	          }
	           
	           else if(s.charAt(i) == 'd'){
	           min[3]+=a[i];
	        	 min[3] = Math.min(min[2], min[3]); 
	           }
	     }
	     out.println(min[3]);
	     out.close();
	}
}
