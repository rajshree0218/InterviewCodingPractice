package org.example.leetcode.leetcode75.binarySearch;

//374. Guess Number Higher or Lower
//Solved
//Easy
//Topics
//Companies
//We are playing the Guess Game. The game is as follows:
//
//I pick a number from 1 to n. You have to guess which number I picked.
//
//Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
//
//You call a pre-defined API int guess(int num), which returns three possible results:
//
//-1: Your guess is higher than the number I picked (i.e. num > pick).
//1: Your guess is lower than the number I picked (i.e. num < pick).
//0: your guess is equal to the number I picked (i.e. num == pick).
//Return the number that I picked.
//
//
//
//Example 1:
//
//Input: n = 10, pick = 6
//Output: 6
//Example 2:
//
//Input: n = 1, pick = 1
//Output: 1
//Example 3:
//
//Input: n = 2, pick = 1
//Output: 1
//
//
//Constraints:
//
//1 <= n <= 231 - 1
//1 <= pick <= n

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */
public class _01_GuessNumberHigherOrLower extends GuessGame {
    public _01_GuessNumberHigherOrLower(int pick) {
        super(pick);
    }

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1; // This line should never be reached
    }

    // passed in Leetcode
    public int guessNumber2(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = guess(mid);

            if (result == 0) {
                return mid; // Found the number
            } else if (result == -1) {
                right = mid - 1; // Guess is higher, search in the left half
            } else {
                left = mid + 1; // Guess is lower, search in the right half
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Test case 1
        int n1 = 10, pick1 = 6;
        _01_GuessNumberHigherOrLower sol1 = new _01_GuessNumberHigherOrLower(pick1);
        System.out.println(sol1.guessNumber(n1)); // Output: 6

        // Test case 2
        int n2 = 1, pick2 = 1;
        _01_GuessNumberHigherOrLower sol2 = new _01_GuessNumberHigherOrLower(pick2);
        System.out.println(sol2.guessNumber(n2)); // Output: 1

        // Test case 3
        int n3 = 2, pick3 = 1;
        _01_GuessNumberHigherOrLower sol3 = new _01_GuessNumberHigherOrLower(pick3);
        System.out.println(sol3.guessNumber(n3)); // Output: 1
    }

}
class GuessGame {
    private int pick;

    public GuessGame(int pick) {
        this.pick = pick;
    }

    // Predefined API: this simulates the guess API for testing purposes.
    public int guess(int num) {
        if (num > pick) {
            return -1;
        } else if (num < pick) {
            return 1;
        } else {
            return 0;
        }
    }
}
