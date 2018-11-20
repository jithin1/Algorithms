// time complexity O(n*m*sum)
// space complexty O(n*n)


class Dicethrow {
    
    public static void findWays(int n,int m,int sum){
        int dp[][] = new int[n+1][sum+1];
        for(int i=1; i<=m;i++)
         dp[1][i] = 1;
         
         for(int i=2; i<=n; i++)  // for n dices
           for(int j=1; j<= sum; j++)  // j can go till sum
              for(int k =1; k<=m && k<j; k++) // for keeping track of face of previous dice
              {
                  dp[i][j] += dp[i-1][j-k];  //to store the intermediate states, same like stair case logic
              }
              
              System.out.println(dp[n][sum]);
    }
    public static void main(String[] args){
        findWays(3,6,18);  // number of dice,number of faces,total sum
    }
}
