package org.example.leetcode.leetcode75.arrayAndString;

//151. Reverse Words in a String
//Solved
//Medium
//Topics
//Companies
//Given an input string s, reverse the order of the words.
//
//A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
//
//Return a string of the words in reverse order concatenated by a single space.
//
//Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
//
//
//
//Example 1:
//
//Input: s = "the sky is blue"
//Output: "blue is sky the"
//Example 2:
//
//Input: s = "  hello world  "
//Output: "world hello"
//Explanation: Your reversed string should not contain leading or trailing spaces.
//Example 3:
//
//Input: s = "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
//
//
//Constraints:
//
//1 <= s.length <= 104
//s contains English letters (upper-case and lower-case), digits, and spaces ' '.
//There is at least one word in s.
//
//
//Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
public class _06_ReverseWordsInString {

    public String reverseWords(String s) {
        // Split the string by spaces
        String[] words = s.trim().split("\\s+");

        // Reverse the words array
        reverseArray(words);

        // Join the reversed words with a single space
        return String.join(" ", words);
    }

    private void reverseArray(String[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public String reverseWords2(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1; i>=0;i--){
            sb.append(words[i]);
            if(i>0)
                sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _06_ReverseWordsInString solution = new _06_ReverseWordsInString();

        // Example 1
        String s1 = "the sky is blue";
        System.out.println(solution.reverseWords(s1)); // Output: "blue is sky the"

        // Example 2
        String s2 = "  hello world  ";
        System.out.println(solution.reverseWords(s2)); // Output: "world hello"

        // Example 3
        String s3 = "a good   example";
        System.out.println(solution.reverseWords(s3)); // Output: "example good a"
    }
}
