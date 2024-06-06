package org.example.leetcode.leetcode75.arrayAndString;

//1071. Greatest Common Divisor of Strings
//Solved
//Easy
//Topics
//Companies
//Hint
//For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
//
//Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
//
//
//
//Example 1:
//
//Input: str1 = "ABCABC", str2 = "ABC"
//Output: "ABC"
//Example 2:
//
//Input: str1 = "ABABAB", str2 = "ABAB"
//Output: "AB"
//Example 3:
//
//Input: str1 = "LEET", str2 = "CODE"
//Output: ""
//
//
//Constraints:
//
//1 <= str1.length, str2.length <= 1000
//str1 and str2 consist of English uppercase letters.
public class _02_GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {

    }

    // time complexity of this program is : O(Math.max(L1,L2))
    // public String gcdOfStrings(String str1, String str2) {
    //     if(str2.length()>str1.length()){
    //         return gcdOfStrings(str2,str1);
    //     }
    //     if(str2.equals(str1)){
    //         return str1;
    //     }
    //     if(str1.startsWith(str2)){
    //         return gcdOfStrings(str1.substring(str2.length()),str2);
    //     }
    //     return "";
    // }


    //Time Complexity:
    //The main operation in the gcdOfStrings method is finding the greatest common divisor (GCD) of the lengths of the two input strings. This operation is done using the gcd helper method, which has a time complexity of O(log(min(len1, len2))) due to the Euclidean algorithm.
    //Checking if substrings of length gcdLength divide both strings (checkDivide method) involves creating a StringBuilder and appending characters to it. This operation takes O(len1 + len2) time, where len1 and len2 are the lengths of the input strings str1 and str2.
    //Therefore, the overall time complexity of the program is O(log(min(len1, len2)) + len1 + len2).
    //Space Complexity:
    //The program uses additional space to store the pattern string (pattern variable) and a StringBuilder (sb variable).
    //The space complexity of storing the pattern string is O(gcdLength), where gcdLength is the length of the pattern.
    //The space complexity of the StringBuilder is O(len1), as it can potentially store the entire input string str1.
    //Therefore, the overall space complexity of the program is O(gcdLength + len1).

    //time complexity of the program is O(log(min(len1, len2)) + len1 + len2),
    //space complexity is O(gcdLength + len1),
    // where len1 and len2 are the lengths of the input strings str1 and str2,
    // respectively, and gcdLength is the length of the pattern.
    public String gcdOfStrings(String str1, String str2){

        int len1 = str1.length();
        int len2 = str2.length();

        // to Find the greatest common divisor of lengths
        int gcdLength = gcd(len1, len2);

        // to Check if substrings of length gcdLength divide both strings
        String pattern = str1.substring(0, gcdLength);
        if (checkDivide(str1, pattern) && checkDivide(str2, pattern)) {
            return pattern;
        } else {
            return "";
        }
    }

    // Helper method to find the greatest common divisor
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Helper method to check if a string can be divided by a pattern
    private static boolean checkDivide(String str, String pattern) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < str.length()) {
            sb.append(pattern);
        }
        return sb.toString().equals(str);
    }
}
