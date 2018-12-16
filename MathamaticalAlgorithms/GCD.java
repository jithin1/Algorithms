If both a and b are 0, gcd is zero gcd(0, 0) = 0.
gcd(a, 0) = a and gcd(0, b) = b because everything divides 0.
If a and b are both even, gcd(a, b) = 2*gcd(a/2, b/2) because 2 is a common divisor. Multiplication with 2 can be done with bitwise 
shift operator.
If a is even and b is odd, gcd(a, b) = gcd(a/2, b). Similarly, if a is odd and b is even, then
gcd(a, b) = gcd(a, b/2). It is because 2 is not a common divisor.
If both a and b are odd, then gcd(a, b) = gcd(|a-b|/2, b). Note that difference of two odd numbers is even
Repeat steps 3–5 until a = b, or until a = 0. In either case, the GCD is power(2, k) * b, where power(2, k) is 2 raise to the power of k
and k is the number of common factors of 2 found in step 2.


    class GFG { 
    
   public static int GCD(int a, int b){
       if(a==0 && b==0)
         return 0;
        
        else if(a==0)
          return b;
         
        else if(b == 0)
          return a;
          
        else if( (~a & 1) == 1){
            if( (~b &1) == 1)
              return GCD(a>>1,b>>1)<<1;
              
              else
              return GCD(a>>1,b);
               
          }
          
        else if( (~b &1) == 1){
           return GCD(a,b>>1);
        }  
        
        else{
            if(a >= b)
            return GCD((a-b)/2,b);
             else
            return GCD(a,(b-a)/2);
        }
   }
  
    public static void main(String arg[]) 
    { 
        int a = 27,b =81;
        
        System.out.println(GCD(a,b));
    } 
    
} 
