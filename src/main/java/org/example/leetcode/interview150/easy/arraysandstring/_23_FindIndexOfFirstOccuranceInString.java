package org.example.leetcode.interview150.easy.arraysandstring;

//28. Find the Index of the First Occurrence in a String
//Easy
//Topics : two pointer, String, String Matching
//Companies
//Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//
//
//Example 1:
//
//Input: haystack = "sadbutsad", needle = "sad"
//Output: 0
//Explanation: "sad" occurs at index 0 and 6.
//The first occurrence is at index 0, so we return 0.
//Example 2:
//
//Input: haystack = "leetcode", needle = "leeto"
//Output: -1
//Explanation: "leeto" did not occur in "leetcode", so we return -1.
//
//
//Constraints:
//
//1 <= haystack.length, needle.length <= 104
//haystack and needle consist of only lowercase English characters.
public class _23_FindIndexOfFirstOccuranceInString {
    public static void main(String[] args) {

        String haystack = "sadbutsad";
        int output1 = 0;
        String needle = "sad";
        int output2 = -1;
        int index = indexOfFirstOccurrence(haystack, needle);
        System.out.println("Index of first occurrence: " + index);
        System.out.println("Index of first occurrence: " + findIndexOfFirstOccurrence(haystack, needle));
    }

    //TC : O((n - m) * m), where n is the length of the haystack and m is the length of the needle.
    // This is because, in the worst case, we iterate through the haystack string once,
    // and for each starting index in the haystack, we compare up to m characters with the needle.
    // SC : O(1)
    public static int indexOfFirstOccurrence(String haystack, String needle) {
        if (haystack == null || needle == null
                || haystack.length() < needle.length()) {
            return -1;
        }
        int n = haystack.length();
        int m = needle.length();
        for(int i=0; i<=n-m; i++){
            int j;
            for(j=0; j<m; j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
            }
            if(j==m){
                return i;
            }
        }
        return -1;
    }

    public static int findIndexOfFirstOccurrence(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
