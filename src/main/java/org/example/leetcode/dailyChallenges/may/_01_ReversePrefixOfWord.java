package org.example.leetcode.dailyChallenges.may;

//Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.
//
//For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
//Return the resulting string.
//
//
//
//Example 1:
//
//Input: word = "abcdefd", ch = "d"
//Output: "dcbaefd"
//Explanation: The first occurrence of "d" is at index 3.
//Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
//Example 2:
//
//Input: word = "xyxzxe", ch = "z"
//Output: "zxyxxe"
//Explanation: The first and only occurrence of "z" is at index 3.
//Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
//Example 3:
//
//Input: word = "abcd", ch = "z"
//Output: "abcd"
//Explanation: "z" does not exist in word.
//You should not do any reverse operation, the resulting string is "abcd".
//
//
//Constraints:
//
//1 <= word.length <= 250
//word consists of lowercase English letters.
//ch is a lowercase English letter.
public class _01_ReversePrefixOfWord {
    public static void main(String[] args) {
        // Test cases
        System.out.println(reversePrefix("abcdefd", 'd')); // Output: "dcbaefd"
        System.out.println(reversePrefix("xyxzxe", 'z')); // Output: "zxyxxe"
        System.out.println(reversePrefix("abcd", 'z')); // Output: "abcd"

        //another way using predefined methods
        System.out.println(reversePrefix2("abcdefd", 'd')); // Output: "dcbaefd"
        System.out.println(reversePrefix2("xyxzxe", 'z')); // Output: "zxyxxe"
        System.out.println(reversePrefix2("abcd", 'z')); // Output: "abcd"
    }

    public static String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray();
        int left =0;
        int right = word.indexOf(ch);
        if(right ==-1){
            return word;
        }

        while(left<right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static String reversePrefix2(String word, char ch) {
        int index = word.indexOf(ch);
        if(index == -1){
            return word;
        }
        StringBuilder sb = new StringBuilder(word.substring(0, index+1));
        return sb.reverse().toString() + word.substring(index+1);
    }
}
