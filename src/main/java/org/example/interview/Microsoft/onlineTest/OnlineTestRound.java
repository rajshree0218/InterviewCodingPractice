package org.example.interview.Microsoft.onlineTest;

import java.util.HashSet;
import java.util.Set;

/*
* Microsoft Interview Exp
* 1st round -> 2 Que given, time 60 mins.
* codility round.
*
**/
public class OnlineTestRound {

    /*
    * Q1.You are given a record of the historical prices of an investment asset from the last N days. Analyze the record in order to calculate what could have been your maximum income. Assume you started with one asset of this type and could hold at most one at a time. You could choose to sell the asset whenever you held one. If you did not hold an asset at some moment, you could always afford to buy an asset (assume you had infinite money available).

        What is the maximum income you could make?

        Write a function:

        class Solution { public int solution(int[] A); }

        that, given an array A of length N representing a record of prices over the last N days, returns the maximum income you could make. As the result may be large, return its last nine digits without leading zeros (return the result modulo 1,000,000,000).

        Examples:

        1. Given A = [4, 1, 2, 3], the function should return 6. You could sell the product on the first day (for 4), buy it on the second (for 1) and sell it again on the last day (for 3). The income would be equal 4-1+3=6.

        2. Given A = [1, 2, 3, 3, 2, 1, 5], the function should return 7. You could sell the product when its value was 3, buy it when it changed to 1, and sell it again when it was worth 5.

        3. Given A = [1000000000, 1, 2, 2, 1000000000, 1, 1000000000], the function should return 999999998. The maximum possible income is 2999999998, whose last 9 digits are 999999998.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..200,000];

        each element of array A is an integer within the range [0..1,000,000,000)
    * */
    public int solution1(int[] a){
        int max = a[0];
//        int buy = Integer.MAX_VALUE;
        int buy = Integer.MAX_VALUE;
        for(int price: a){
            buy = Math.min(buy, price);
            max = Math.max(max, price-buy);
        }
        return max % 1_000_000_000;
    }

    // Solution of Que 1 starting from here
    private Set<Long> maxProfits = new HashSet<>();
    private boolean selling = true;

    private long sell(long profit, long price) {
        selling = false;
        return profit + price;
    }

    private long buy(long profit, long price) {
        selling = true;
        return profit - price;
    }

    private void dp(long profit, int i, int[] arr) {
        if (profit < 0) {
            return;
        }
        if (i >= arr.length) {
            maxProfits.add(profit);
            return;
        }

        if (selling) {
            dp(sell(profit, arr[i]), i + 1, arr);
            dp(buy(profit, 0), i + 1, arr);
        } else {
            dp(buy(profit, arr[i]), i + 1, arr);
            dp(sell(profit, 0), i + 1, arr);
        }
    }

    public int solution(int[] A) {
        dp(0, 0, A);
        long maxIncome = maxProfits.stream().mapToLong(v -> v).max().orElse(0);
        return (int) (maxIncome % 1000000000);
    }
    // Solution of Que 1 ended here.


    /*
    * Q2.
    *
    *
    * */

    public static void main(String[] args) {
        OnlineTestRound obj = new OnlineTestRound();
        // Q1 Sol:
        int[] a1 = {4,1,2,3};
        int output1 = obj.solution(a1);

        int[] a2 = {1,2,3,3,2,1,5};
        int output2 = obj.solution(a2);

        int[] a3 = {1000000000, 1, 2, 2, 1000000000, 1, 1000000000};
        int output3 = obj.solution(a3);

        if(output1 == 6
            && output2 == 7
            && output3 == 999999998){

            System.out.println("All Test are passing !!");
        } else {
            System.out.println("There are test failures !!");
            System.out.println("Test Case 1: "+output1+ " Test Case 2: " +output2+" Test Case 3: "+output3);
        }

        // Q2 Sol:

    }
}

// Brute Force Approach
class Solution {
    private long maxIncome;

    private void calculateMaxProfit(int[] A, int index, boolean canBuy, long currentProfit) {
        if (index == A.length) {
            // Update maxIncome if the currentProfit is greater
            maxIncome = Math.max(maxIncome, currentProfit);
            return;
        }

        // Do nothing on this day
        calculateMaxProfit(A, index + 1, canBuy, currentProfit);

        if (canBuy) {
            // Try buying the asset on this day
            calculateMaxProfit(A, index + 1, false, currentProfit - A[index]);
        } else {
            // Try selling the asset on this day
            calculateMaxProfit(A, index + 1, true, currentProfit + A[index]);
        }
    }

    public int solution(int[] A) {
        maxIncome = 0;
        calculateMaxProfit(A, 0, true, 0);
        return (int) (maxIncome % 1000000000);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] A1 = {4, 1, 2, 3};
        System.out.println("Test Case 1: " + sol.solution(A1)); // Expected output: 6

        int[] A2 = {1, 2, 3, 3, 2, 1, 5};
        System.out.println("Test Case 2: " + sol.solution(A2)); // Expected output: 7

        int[] A3 = {1000000000, 1, 2, 2, 1000000000, 1, 1000000000};
        System.out.println("Test Case 3: " + sol.solution(A3)); // Expected output: 999999998
    }
}
