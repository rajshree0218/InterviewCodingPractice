package org.example.leetcode.leetcode75.backtracking;

import java.util.ArrayList;
import java.util.List;

//17. Letter Combinations of a Phone Number
//Medium
//Topics
//Companies
//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//
//A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//
//
//
//Example 1:
//
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//Example 2:
//
//Input: digits = ""
//Output: []
//Example 3:
//
//Input: digits = "2"
//Output: ["a","b","c"]
//
//
//Constraints:
//
//0 <= digits.length <= 4
//digits[i] is a digit in the range ['2', '9'].
public class _01_LetterCombinationOfPhoneNumber {

    // Mapping from digit to letters
    private static final String[] KEYPAD = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return combinations;
        backtrack(combinations, digits, new StringBuilder(), 0);
        return combinations;
    }

    private void backtrack(List<String> combinations, String digits, StringBuilder current, int index) {
        if (index == digits.length()) {
            combinations.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = KEYPAD[digit - '0'];
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(combinations, digits, current, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        _01_LetterCombinationOfPhoneNumber solution = new _01_LetterCombinationOfPhoneNumber();

        String digits1 = "23";
        System.out.println(solution.letterCombinations(digits1)); // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

        String digits2 = "";
        System.out.println(solution.letterCombinations(digits2)); // Output: []

        String digits3 = "2";
        System.out.println(solution.letterCombinations(digits3)); // Output: ["a","b","c"]
    }
}

