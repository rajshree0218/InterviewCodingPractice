package org.example.leetcode.topinterviewquestions;

//You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
//
//On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
//
//Find and return the maximum profit you can achieve.
//
//
//
//Example 1:
//
//Input: prices = [7,1,5,3,6,4]
//Output: 7
//Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//Total profit is 4 + 3 = 7.
//Example 2:
//
//Input: prices = [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//Total profit is 4.
//Example 3:
//
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
//
//
//Constraints:
//
//1 <= prices.length <= 3 * 104
//0 <= prices[i] <= 104
public class _02_BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4};
        int output1 = 7;

        int[] prices2 = {1,2,3,4,5};
        int output2 = 4;

        int[] prices3 = {7,6,4,3,1};
        int output3 = 0;

        int max1 = maxProfit(prices1);
        int max2 = maxProfit(prices2);
        int max3 = maxProfit(prices3);

        if(max1 == output1 && max2==output2 && max3==output3)
            System.out.println("All Test cases passed");
        else
            System.out.println("There are test failures");


    }

    public static int maxProfit(int[] prices){
        int maxProfit = 0;
        for(int i=1;i< prices.length; i++){
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}
