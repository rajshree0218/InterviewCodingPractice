package org.example.leetcode.leetcode75.DP_multidimensional;

//714. Best Time to Buy and Sell Stock with Transaction Fee
//Solved
//Medium
//Topics
//Companies
//Hint
//You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
//
//Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
//
//Note:
//
//You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
//The transaction fee is only charged once for each stock purchase and sale.
//
//
//Example 1:
//
//Input: prices = [1,3,2,8,4,9], fee = 2
//Output: 8
//Explanation: The maximum profit can be achieved by:
//- Buying at prices[0] = 1
//- Selling at prices[3] = 8
//- Buying at prices[4] = 4
//- Selling at prices[5] = 9
//The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
//Example 2:
//
//Input: prices = [1,3,7,5,10,3], fee = 3
//Output: 6
//
//
//Constraints:
//
//1 <= prices.length <= 5 * 10^4
//1 <= prices[i] < 5 * 10^4
//0 <= fee < 5 * 10^4
public class _03_BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;

        // Initialize the hold and cash arrays
        int[] hold = new int[n];
        int[] cash = new int[n];

        hold[0] = -prices[0]; // Initial holding cost

        // Calculate the maximum profit for each day
        for (int i = 1; i < n; i++) {
            // If we continue holding the stock or buy it on this day
            hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
            // If we continue to keep cash or sell the stock on this day
            cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i] - fee);
        }

        // Return the maximum profit on the last day
        return cash[n - 1];
    }

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int cash = 0; // Max profit if we do not hold a stock
        int hold = -prices[0]; // Max profit if we hold a stock

        for (int i = 1; i < n; i++) {
            cash = Math.max(cash, hold + prices[i] - fee); // Max profit if we do not hold a stock today
            hold = Math.max(hold, cash - prices[i]); // Max profit if we hold a stock today
        }

        return cash;
    }

    public static void main(String[] args) {
        _03_BestTimeToBuyAndSellStockWithTransactionFee solution = new _03_BestTimeToBuyAndSellStockWithTransactionFee();

        int[] prices1 = {1, 3, 2, 8, 4, 9};
        int fee1 = 2;
        System.out.println(solution.maxProfit(prices1, fee1)); // Output: 8

        int[] prices2 = {1, 3, 7, 5, 10, 3};
        int fee2 = 3;
        System.out.println(solution.maxProfit(prices2, fee2)); // Output: 6
    }
}

