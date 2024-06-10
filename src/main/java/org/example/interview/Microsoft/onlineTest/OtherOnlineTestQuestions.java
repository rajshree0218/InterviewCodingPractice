package org.example.interview.Microsoft.onlineTest;

import java.util.*;

public class OtherOnlineTestQuestions {

    /*
    Question1: Given an array A consisting of N integers, returns the maximum sum of two numbers whose digits add up to an equal sum.
    if there are not two numbers whose digits have an equal sum, the function should return -1.
    Constraints: N is integer within the range [1, 200000]
    each element of array A is an integer within the range [1, 1000000000]

    Example1:
    Input:
    A = [51, 71, 17, 42]
    Output: 93
    Explanation: There are two pairs of numbers whose digits add up to an equal sum: (51, 42) and (17, 71), The first pair sums up  to 93

    Example2:
    Input:
    A = [42, 33, 60]
    Output: 102
    Explanation: The digits of all numbers in A add up the same sum, and choosing to add 42 and 60 gives the result 102

    Example3:
    Input:
    A = [51, 32, 43]
    Output: -1
    Explanation: All numbers in A have digits that add up to different, unique sums

*/

    public int MaximumSum(int[] A) {
        // write your code here
        Map<Integer, int[]> map = new HashMap<>();
        for (int a : A) {
            int s = 0, tmp = a;
            while (tmp > 0) {
                s += tmp % 10;
                tmp /= 10;
            }

            map.putIfAbsent(s, new int[2]);
            int[] nums = map.get(s);
            if (a > nums[0]) {
                nums[1] = nums[0];
                nums[0] = a;
            } else if (a > nums[1]) {
                nums[1] = a;
            }
        }

        int res = -1;
        for (int[] nums : map.values()) {
            if (nums[1] == 0) {
                continue;
            }
            res = Math.max(res, nums[0] + nums[1]);
        }

        return res;
    }

    /*-----Question 2------*/
/* Given a string s, find the minimum number of substrings you can create
 * without having the same letters repeating in each substring.
* Example:
 * world -> 1, as the string has no letters that occur more than once.
    dddd -> 4, as you can only create substring of each character.
    abba -> 2, as you can make substrings of ab, ba.
    cycle-> 2, you can create substrings of (cy, cle) or (c, ycle)
*
*/
    public static int subStringsWithNoRepeat(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set set = new HashSet<>();
        int res = 1;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                res++;
                set.clear();
            }
            set.add(c);
        }
        return res;
    }


    /*-----Question 3------*/

/*
You are given a string S, which consists entirely of decimal digits (0−9).
Using digits from S, create a palindromic number with the largest possible decimal value.
You should use at least one digit and you can reorder the digits.

A palindromic number remains the same when its digits are reversed; for instance, "7", "44" or "83238".
Any palindromic number you create should not, however, have any leading zeros, such as in "0990" or "010".
For example, decimal palindromic numbers that can be created from "8199" are:
"1", "8", "9", "99", "919" and "989".

Among them, “989” has the largest value.

Write a function:
class Solution { public String solution(String S); }
that, given a string S of N digits, returns the string representing the palindromic number with the largest value.
Examples:
1. Given "39878", your function should return "898".
2. Given "00900", your function should return "9".
3. Given "0000", your function should return "0".
4. Given "54321", your function should return "5".
Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..100,000];
string S consists only of digits (0−9).

*/
// Couldn't solve this. Can someone share some insight how to solve this?
    public String solution(String s) {
        Deque<Integer> front = new ArrayDeque<>(), back = new ArrayDeque<>();
        int[] cnts = new int[10];
        int n = s.length();
        for(int i=0; i<n; i++) {
            cnts[s.charAt(i)-'0']++;
        }
        for(int i=9; i>=0; i--) {
            if(cnts[i]<2) continue;
            int rep = cnts[i]/2;
            for(int r = 0; r<rep; r++) {
                front.offerLast(i);
                back.offerFirst(i);
                cnts[i]-=2;
            }
        }
        while(!front.isEmpty() && front.peekFirst()==0) {
            front.pollFirst();
            back.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        while(!front.isEmpty()) {
            sb.append(front.pollFirst());
        }
        for(int i=9; i>=0; i--) {
            if(cnts[i]==0) continue;
            sb.append(i);
            break;
        }
        while(!back.isEmpty()) {
            sb.append(back.pollFirst());
        }
        return /*sb.isEmpty()*/sb.length() == 0 ? "0" : sb.toString();
    }
}
