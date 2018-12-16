 class Test 
{ 
    
    static int gcd(int a, int b) 
    { 
        // Everything divides 0  
        if (a == 0 || b == 0) 
           return 0; 
       
        // base case 
        if (a == b) 
            return a; 
       
        // a is greater 
        if (a > b) 
            return gcd(a-b, b);    // a%b works faster because more or less the same thing is happening
        return gcd(a, b-a); 
    } 
      
    // method to return LCM of two numbers 
    static int lcm(int a, int b) 
    { 
        return (a*b)/gcd(a, b); 
    } 
      
    // Driver method 
    public static void main(String[] args)  
    { 
        int a = 15, b = 20; 
        System.out.println("LCM of " + a +" and " + b + " is " + lcm(a, b)); 
    } 
} 
