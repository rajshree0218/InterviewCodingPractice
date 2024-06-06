package org.example.leetcode.leetcode75.binarySearch;

//875. Koko Eating Bananas
//Medium
//Topics
//Companies
//Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
//
//Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
//
//Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
//
//Return the minimum integer k such that she can eat all the bananas within h hours.
//
//
//
//Example 1:
//
//Input: piles = [3,6,7,11], h = 8
//Output: 4
//Example 2:
//
//Input: piles = [30,11,23,4,20], h = 5
//Output: 30
//Example 3:
//
//Input: piles = [30,11,23,4,20], h = 6
//Output: 23
//
//
//Constraints:
//
//1 <= piles.length <= 10^4
//piles.length <= h <= 10^9
//1 <= piles[i] <= 10^9
public class _04_KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // Minimum possible speed
        int right = getMaxPile(piles); // Maximum possible speed

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEatAllBananas(piles, mid, h)) {
                right = mid; // Try a smaller speed
            } else {
                left = mid + 1; // Increase the speed
            }
        }

        return left; // or right, both are same when left == right
    }

    private int getMaxPile(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }
        return max;
    }

    private boolean canEatAllBananas(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k; // Equivalent to Math.ceil(pile / (double) k)
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        _04_KokoEatingBananas solution = new _04_KokoEatingBananas();
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println(solution.minEatingSpeed(piles1, h1)); // Output: 4

        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println(solution.minEatingSpeed(piles2, h2)); // Output: 30

        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;
        System.out.println(solution.minEatingSpeed(piles3, h3)); // Output: 23
    }
}

