 class Cutting{	
    
    public static void cut(int[] length, int[] value){
        int sum = 5;
        int[][] t= new int[5][6];
        
        for(int i=0; i<6; i++){
            t[0][i]=0;
        }
        
        for(int j=0; j<5; j++)
            t[j][0] = 0;
        
        for(int i=1; i<5; i++)
           for(int j=1; j<=5 ; j++){
               
               if(j >= length[i-1])
                   t[i][j] = Math.max(t[i-1][j] ,value[i-1]+t[i][j-length[i-1]]);
               
               else
                t[i][j] = t[i-1][j];
                 
           }
           
           System.out.print(t[4][5]);
    }
    
    public static void main(String[] args){
        int[] length= new int[4];
        int[] value = new int[4];
        
         for(int i=0; i<4; i++)
           length[i] = i+1;
           
          value[0] = 2;
          value[1] = 5;
          value[2] = 7;
          value[3] = 8;
          
          cut(length,value);
     } 
    
 }
