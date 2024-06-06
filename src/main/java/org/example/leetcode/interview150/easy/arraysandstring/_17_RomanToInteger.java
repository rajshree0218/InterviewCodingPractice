package org.example.leetcode.interview150.easy.arraysandstring;

import java.util.HashMap;
import java.util.Map;

//13. Roman to Integer
//Solved
//Easy
//Topics
//Companies
//Hint
//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
//
//Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//I can be placed before V (5) and X (10) to make 4 and 9.
//X can be placed before L (50) and C (100) to make 40 and 90.
//C can be placed before D (500) and M (1000) to make 400 and 900.
//Given a roman numeral, convert it to an integer.
//
//
//
//Example 1:
//
//Input: s = "III"
//Output: 3
//Explanation: III = 3.
//Example 2:
//
//Input: s = "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.
//Example 3:
//
//Input: s = "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
//
//
//Constraints:
//
//1 <= s.length <= 15
//s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
//It is guaranteed that s is a valid roman numeral in the range [1, 3999].
public class _17_RomanToInteger {
    public static void main(String[] args) {

        System.out.println(romanToInt("III")); // Output: 3
        System.out.println(romanToInt("LVIII")); // Output: 58
        System.out.println(romanToInt("MCMXCIV")); // Output: 1994
        System.out.println(romanToInt("DCXXI")); // Output: 621
        System.out.println(romanToInt("MCDLXXVI")); // Output: 1476
        System.out.println(romanToInt("MMCDXXV")); // Output: 2425
        System.out.println(romanToInt("MDCXCV")); // Output: 1695
    }

    // Best solution: Run time : 2ms, memory : 44.56MB
    // TC : O(n),  SC :O(1)
    public static int romanToInt(String s) {
        int[] values = new int[26];
        values['I' - 'A'] = 1;
        values['V' - 'A'] = 5;
        values['X' - 'A'] = 10;
        values['L' - 'A'] = 50;
        values['C' - 'A'] = 100;
        values['D' - 'A'] = 500;
        values['M' - 'A'] = 1000;

        int total = 0;
        int prevValue = values[s.charAt(0) - 'A'];

        for (int i = 1; i < s.length(); i++) {
            int currentValue = values[s.charAt(i) - 'A'];
            if (prevValue < currentValue) {
                total -= prevValue;
            } else {
                total += prevValue;
            }
            prevValue = currentValue;
        }
        total += prevValue;
        return total;
    }

    Map<Character, Integer> map = new HashMap<>();
    {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    // Run time : 5ms, memory : 44.56MB
    // By using map.
    public int romanToInt2(String s) {

        int sum = map.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }

        return sum;
    }

    // Run time : 5ms, memory : 44.56MB
    // By using map.
    public int romanToInt3(String s) {
        int sum = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int currentValue = map.get(s.charAt(i));
            if (i < n - 1 && currentValue < map.get(s.charAt(i + 1))) {
                sum -= currentValue;
            } else {
                sum += currentValue;
            }
        }
        return sum;
    }

    // Run time : 5ms, memory : 44.34MB
    // By using map.
    public int romanToInt4(String s) {

        int sum = 0;
        int n = s.length();

        for (int i = 0; i < n - 1; i++) {
            int currentVal = map.get(s.charAt(i));
            int nextVal = map.get(s.charAt(i + 1));
            if (currentVal < nextVal) {
                sum -= currentVal;
            } else {
                sum += currentVal;
            }
        }

        sum += map.get(s.charAt(n - 1));
        return sum;
    }

    public int romanToInt5(String s) {
        int sum = 0;
        int n = s.length()-1;
        int i=0;
        while(i<n){
            if(s.charAt(i) == 'I' && s.charAt(i+1) != 'I' ){
                sum += map.get(s.charAt(i+1))-map.get(s.charAt(i));
                i+=2;
            } else if(s.charAt(i) == 'X' && s.charAt(i+1) != 'X'
                    && s.charAt(i+1) != 'V' && s.charAt(i+1) != 'I'){
                sum += map.get(s.charAt(i+1))-map.get(s.charAt(i));
                i+=2;
            } else if(s.charAt(i) == 'C' &&
                    (s.charAt(i+1) == 'D' || s.charAt(i+1)=='M')){
                sum += map.get(s.charAt(i+1))-map.get(s.charAt(i));
                i+=2;
            } else {
                sum += map.get(s.charAt(i));
                i++;
            }
        }
        return (i==n) ? sum += map.get(s.charAt(n)): sum;
    }

//    public int romanToInt6(String s) {
//        int number = 0;
//        if (!s.isEmpty() && s.length() < 16) {
//            int prevValue = 0;
//            for (char letter : s.toCharArray()) {
//                int value = 0;
//                switch (letter) {
//                    case 'I' -> value = 1;
//                    case 'V' -> value = 5;
//                    case 'X' -> value = 10;
//                    case 'L' -> value = 50;
//                    case 'C' -> value = 100;
//                    case 'D' -> value = 500;
//                    case 'M' -> value = 1000;
//                }
//                if (value > prevValue) {
//                    number = number - 2 * prevValue + value;
//                } else {
//                    number += value;
//                }
//                prevValue = value;
//            }
//
//            return number;
//        } else return number;
//    }

}