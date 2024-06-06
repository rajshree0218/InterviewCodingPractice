package org.example.leetcode.leetcode75.arrayAndString;

//1768. Merge Strings Alternately
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
//
//Return the merged string.
//
//
//
//Example 1:
//
//Input: word1 = "abc", word2 = "pqr"
//Output: "apbqcr"
//Explanation: The merged string will be merged as so:
//word1:  a   b   c
//word2:    p   q   r
//merged: a p b q c r
//Example 2:
//
//Input: word1 = "ab", word2 = "pqrs"
//Output: "apbqrs"
//Explanation: Notice that as word2 is longer, "rs" is appended to the end.
//word1:  a   b
//word2:    p   q   r   s
//merged: a p b q   r   s
//Example 3:
//
//Input: word1 = "abcd", word2 = "pq"
//Output: "apbqcd"
//Explanation: Notice that as word1 is longer, "cd" is appended to the end.
//word1:  a   b   c   d
//word2:    p   q
//merged: a p b q c   d
//
//
//Constraints:
//
//1 <= word1.length, word2.length <= 100
//word1 and word2 consist of lowercase English letters.
public class _01_MergeStringsAlternatively {
    public static void main(String[] args) {

        // Test cases
        String word1 = "abc", word2 = "pqr";
        System.out.println(mergeAlternately(word1, word2)); // Output: "apbqcr"

        word1 = "ab"; word2 = "pqrs";
        System.out.println(mergeAlternately(word1, word2)); // Output: "apbqrs"

        word1 = "abcd"; word2 = "pq";
        System.out.println(mergeAlternately(word1, word2)); // Output: "apbqcd"

    }

    // TC : O(max(n, m)).
    // The program iterates through both strings simultaneously once,
    // appending characters alternately until reaching the end of either string.
    // This process takes O(max(n, m)) time, where n is the length of word1 and m is
    // the length of word2.
    //Appending characters to a StringBuilder takes constant time.
    //Therefore, the overall time complexity of the program is O(max(n, m)).
    // SC : O(max(n, m)). Below details:
    // In the worst case, where both strings have equal length,
    //     the space complexity is O(n + m), where n is the length of word1
    //     and m is the length of word2.
    // In the best case, where one string is much shorter than the other,
    //      the space complexity is O(max(n, m)), where n is the length of the longer string.

    public static String mergeAlternately(String word1, String word2) {
        int i=0;
        int j=0;
        StringBuilder sb = new StringBuilder();
        while(i<word1.length() && j<word2.length()){
            sb.append(word1.charAt(i++)).append(word2.charAt(j++));
        }

        while(i<word1.length()){
            sb.append(word1.charAt(i++));
        }

        while(j< word2.length()){
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}
