 15) Minimum number of steps needed to reach the end of an array

  /* Given an array with ceratin distances, find minimum steps needed to reach end of thsi array */
  
  import java.util.Arrays;

    class MinJumps{
    
    public static void calculate(int[] a){
        int []steps = new int[a.length];
        int[] paths = new int[a.length];
        
        for(int i=1; i< a.length; i++){
            steps[i] = Integer.MAX_VALUE; // to store the number of steps
            paths[i] = Integer.MAX_VALUE; // initially assign all the calues to max value
        }
        
        steps[0] = 0;
        paths[0] = -1;
        
         for(int i=0; i< a.length-1; i++){
             int step = a[i];
              
              if(step == 0) // no point in going forward
               continue;
               
               
               for(int j= 1; j<=step; j++){
                   
                   if((i+j) >= a.length)  // boundary condition
                     break;
                     
                    if(steps[i+j] > steps[i]+1){  //better path found
                        steps[i+j]= steps[i]+1;
                        paths[i+j] = i;
                    }
               }
         }
         
         System.out.println("Mininmum number of steps = "+ steps[a.length-1]);          
          
    }
    
    public static void main(String[] args){
       int[] a ={2,3,1,1,2,4,4,0,5,1};
       calculate(a);
    }     
 }
 
  // Time complexity is O(n*n)
