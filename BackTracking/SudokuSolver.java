
     class SudokuSolver{
    
    public void solveSudoku(int[][] grid){
        if(solve(grid))
         printArray(grid);
    }
    
    public boolean solve(int[][] grid){
         int i=0,j=0;
        for(i=0;i<9;i++)
        {
            for(j=0;j<9;j++)
            if(grid[i][j]==0)
             break;
             
             if(j<9)
             break;
        }
        
          if(i==9)
           return true;
           
           for(int k=1;k<=9;k++){
               if(isSafe(grid,i,j,k)){
                   grid[i][j]=k;
                   
                  if(solve(grid))
                   return true;
                   
                   grid[i][j]=0;
               }
           }
           
           return false;
    }
    
     public boolean isSafe(int[][] grid, int i,int j,int val){
         return(!row(grid,i,val) && !column(grid,j,val) && ! cell(grid,i-(i%3),j-(j%3),val));
     }
     
      public boolean row(int[][] grid,int row,int val){
          for(int col=0; col<9; col++)
           if(grid[row][col]==val)
           return true;
           
           return false;
      }
      
       public boolean column(int[][] grid,int col,int val){
          for(int row=0; row<9; row++)
           if(grid[row][col]==val)
           return true;
           
           return false;
      }
      
      public boolean cell(int[][] grid,int rowcount,int colcount,int val){
          
          for(int row=0; row<3;row++)
            for(int col=0;col<3;col++)
             if(grid[row+rowcount][col+colcount]==val)
               return true;
               
               return false;
      }
    
    public void printArray(int[][] grid){
        for(int i=0;i<9;i++){
         for(int j=0;j<9;j++)
          System.out.print(grid[i][j]+" ");
           System.out.println();
        }
    }
    
    public static void main(String[] args){
        SudokuSolver sl= new SudokuSolver();
         int[][] grid = {  {0, 7, 0, 0, 0, 0, 0, 5, 0},
                           {1, 0, 0, 0, 2, 0, 0, 0, 3},
                           {3, 0, 5, 0, 6, 0, 2, 0, 7},
                           {0, 0, 0, 6, 5, 9, 0, 0, 0},
                           {0, 3, 0, 0, 0, 0, 0, 9, 0},
                           {0, 0, 0, 8, 7, 3, 0, 0, 0},
                           {6, 0, 1, 0, 9, 0, 7, 0, 2},
                           {2, 0, 0, 0, 1, 0, 0, 0, 4},
                           {0, 4, 0, 0, 0, 0, 0, 1, 0}  };
        sl.solveSudoku(grid);
    }
  }
  
  
