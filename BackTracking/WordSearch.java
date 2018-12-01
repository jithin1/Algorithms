/*
Leetcode 79. Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically 
neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/

class Solution {
    int[][] visited;
    
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        visited = new int[row][col];
        int length = word.length();
        
          for(int i=0; i<board.length; i++)
              for(int j=0; j< board[0].length; j++){
                  if(board[i][j] == word.charAt(0)){
                       visited[i][j] = 1;
                     if(findWord(board,word,i,j,length,1))
                         return true;
                      visited[i][j] = 0;
                  }
              }
        
         return false;
    }
    
    public boolean findWord(char[][] board,String word,int x, int y,int length, int depth){
        if(length == depth)
            return true;
        
          int moveX[] = {0,0,-1,1};
          int moveY[] = {1,-1,0,0};
        
         for(int i=0; i<moveX.length; i++){
             int new_x = x+moveX[i];
             int new_y = y+moveY[i];
             
             if(isSafe(board,word,new_x, new_y,depth)){
                 visited[new_x][new_y] = 1;
                 
                 if(findWord(board,word,new_x, new_y,length,depth+1))
                      return true;
                 
                 visited[new_x][new_y] = 0;
             }
         }
        
          return false;
    }
    
    public boolean isSafe(char[][] board,String word,int x, int y,int depth){
          if( x <0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] == 1 || board[x][y] != word.charAt(depth))
             return false;
        
          return true;
    }
}
