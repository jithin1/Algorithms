/*
Julia is going to cook a chicken in the kitchen of her dormitory. To save energy, the stove in the kitchen automatically turns off after
k minutes after turning on.

During cooking, Julia goes to the kitchen every d minutes and turns on the stove if it is turned off. While the cooker is turned off, it
stays warm. The stove switches on and off instantly.

It is known that the chicken needs t minutes to be cooked on the stove, if it is turned on, and 2t minutes, if it is turned off. You need
to find out, how much time will Julia have to cook the chicken, if it is considered that the chicken is cooked evenly, with constant 
speed when the stove is turned on and at a constant speed when it is turned off.

Input

The single line contains three integers k, d and t (1 ≤ k, d, t ≤ 1018).
Output

Print a single number, the total time of cooking in minutes. The relative or absolute error must not exceed 10 - 9.
*/

 public class Solution{  
     public static double saveEnergy(long k, long d, long t){
     // time work concept
      double result = 0;
      long time = 2*t;
       if(k > d)
       d = d*((k/d)+1);
       
      long fact = k*2L+(d-k);
      result = d*(time/fact);
      time-=fact*(time/fact);
       if(time > 2L*k){
           time-=2L*k;
           result+=k;
           result+=time;
       }
       else
        result+=time/2.0;
        
        return result;
    }
       
       public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(System.out);
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            long k = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            Long t = Long.parseLong(st.nextToken());
            
            if((k % d) == 0)
             out.println(t);
            else
             out.println(saveEnergy(k,d,t));
               
             out.close();
 
      }
}
