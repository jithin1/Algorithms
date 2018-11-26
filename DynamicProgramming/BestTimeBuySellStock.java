Leetcode 309. Best Time to Buy and Sell Stock with Cooldown
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the 
stock multiple times) with the following restrictions:

    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

   Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]

/*
Input: [1,2,3,0,2]

buy
[0,-1,0,0,0,0] buying price so far is 1
Sell
[0,0,0,0,0,0] nothing sold till now

buy
[0,-1,-1,0,0,0] we dont buy anything as -2+0 < -1 (the least buying price so far is 1. The best we can do so far is to buy stock at price 1)
sell
[0, 0, 1,0,0,0] we sell the stock which we bought (2-1 = 1)

buy
[0,-1,-1,-1,0,0] the best buying price is 1. because if we buy stock of price 3, we will spend more money than buying it at price 1
sell
[0, 0, 1, 2,0,0] // the best deal till now is if we buy stock at price 1 and sell it at price 3 (3-1 = 2)

buy
[0,-1,-1,-1,1,0] we buy stock at price 0 and then we will have a profit of 1(profit by selling stock at price 2).

sell
[0, 0, 1, 2,2,0] // we will get -1 if we sell the stock at price 0 hence retain 2. (Because the best buying price so far is 1. If selling price = 0 then profit so far will be -1 < 2 )

buy
[0,-1,-1,-1,1,0]
sell
[0, 0, 1, 2,2,3] // we sell stock to get an overall profit of 3

                     Buy stock at price 1 and sell it at price 2 to get a profit of 1
                     + 
                     Buy stock at price 0 and sell it at price 2 to get a profit of 2
                     Total profit  = 1+2 = 3

*/

class Solution {
public int maxProfit(int[] prices) {
if(prices.length == 0 || prices.length == 1)
return 0;
int[] buy = new int[prices.length+1];
int[] sell = new int[prices.length+1];

        buy[1] = -prices[0];
    
    for(int i=2; i<=prices.length; i++)
    {
        buy[i] = Math.max(buy[i-1],sell[i-2]-prices[i-1]);
        sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i-1]);
    }
     return sell[prices.length];
  }
}

Time Complexity O(n)
Space complexity O(n)
