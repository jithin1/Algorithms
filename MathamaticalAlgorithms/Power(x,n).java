 class Solution {

    public double myPow(double x, int n) {
         if(n == 0)
             return 1;
        
        int temp = Math.abs(n);
        
        if(temp == 1){          
            if( n>0)
            return x;
            
            else{
                return 1/x;
            }

        }
        
        if( (temp &1) == 0)
        {
                return myPow(x*x,n/2);
        }
        
        else{
            if(n > 0)
                return x*myPow(x*x,n/2);
                
            else
                return 1/x*myPow(x*x,n/2);
        }
        
    }
}
