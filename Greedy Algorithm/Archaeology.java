//Codeforces : https://codeforces.com/contest/1178/problem/E

import java.util.*;
import java.lang.*;
import java.io.*;
 
 public class Solution
{
    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = br.readLine();
		
		int low=0,high=s.length()-1;
		StringBuilder sb = new StringBuilder();
		while(high-low>2){
		    if(s.charAt(low) == s.charAt(high)) {
		        sb.append(s.charAt(low));
		        low++;
		        high--;
		    }
		    else if(s.charAt(low) == s.charAt(high-1)){
		        sb.append(s.charAt(low));
		        low++;
		        high-=2;
		    }
		    else{
		        sb.append(s.charAt(low+1));
		        if(s.charAt(low+1) == s.charAt(high)){
		            low+=2;
		            high--;
		        }
		        else{
		            low+=2;
		            high-=2;
		        }
		    }
		}
		int i=sb.length()-1;
		if(low<=high) sb.append(s.charAt(low));
		while(i>=0)sb.append(sb.charAt(i--));
		
		out.println(sb.toString());
		out.close();
    }
	
}
