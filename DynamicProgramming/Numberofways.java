/*   
   Number of Ways
    
     You've got array a[1], a[2], ..., a[n], consisting of n integers. Count the number of ways to split all the elements of the array 
     into three contiguous parts so that the sum of elements in each part is the same.

More formally, you need to find the number of such pairs of indices i, j (2 ≤ i ≤ j ≤ n - 1), that .
Input

The first line contains integer n (1 ≤ n ≤ 5·105), showing how many numbers are in the array. The second line contains n integers a[1], 
a[2], ..., a[n] (|a[i]| ≤  109) — the elements of array a.

Output

Print a single integer — the number of ways to split the array into three parts with the same sum.

Examples
Input
5
1 2 3 0 3

 1 2 | 3 | 0 3
 1 2 | 3 0 | 3
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution{
	 
   public static void findSum(int[] a, int n){
		    OutputStream outputStream = System.out;
		   PrintWriter out = new PrintWriter(outputStream);
           long ans = 0;
           long sum=0;
           int[] dp = new int[n+1];
           
            for(int i=0; i<n; i++)
            	sum+= a[i];
          
            if(sum % 3 != 0){
               out.println(ans);
          	   out.close();
          	   return;
            }
            long tar = sum/3;
            sum = 0;
           for(int i=n-1; i>=0; i--){
        	   sum+=a[i];
        	   if(sum == tar)  // number of ways from right
        		   dp[i] = dp[i+1]+1;   
        	   else
        		   dp[i] = dp[i+1];
           }
		   sum = 0;
		   for(int i=0; i<n-1; i++){
			   sum+=a[i];
			   if(sum == tar)   // first line
				   ans+=dp[i+2];
		   }
	   
	   out.println(ans);
	   out.close();
	}
			   		   
   public static void main(String[] args){
		try{
			 BufferedReader br = new BufferedReader( 
                   new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			int a[] = new int[n];
			st = new StringTokenizer(br.readLine());
			int j=0;
			while(st.hasMoreTokens()){
				a[j++]=Integer.parseInt(st.nextToken());
			}
			
			findSum(a,n);
		}
		catch(Exception e){
			System.out.println("input error");
		}
	}
}
