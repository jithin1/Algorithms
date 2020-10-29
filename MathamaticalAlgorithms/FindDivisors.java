private static void computePrimeFactors(){
          for(int i=0;i<primes.length;i++)
            primes[i] = i;
          
          for(int p=2;p*p<max;p++){
               if(primes[p] == p){
                    for(int i=p*2;i<max;i+=p)
                     primes[i] = Math.min(primes[i],p);
               }
          }
     }
     
     private static int findDivisors(int n){
        int divisors = 1;
        while(n > 1){
             int count = 0;
             int fact = primes[n];
             while( n > 1 && n%fact == 0){
                  count++;
                  n/=fact;
             }
             divisors*=(count+1);
        }
        return divisors;
     }
