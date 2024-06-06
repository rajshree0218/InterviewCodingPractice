package org.example.leetcode.topinterviewquestions;

//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//
//
//Example 1:
//
//Input: s = "anagram", t = "nagaram"
//Output: true
//Example 2:
//
//Input: s = "rat", t = "car"
//Output: false
//
//
//Constraints:
//
//1 <= s.length, t.length <= 5 * 104
//s and t consist of lowercase English letters.
public class _15_ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        // If lengths of s and t are not the same, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Create an array to count the frequency of each character in s and t
        int[] charCount = new int[26];

        // Count the frequency of each character in s
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Decrease the count for each character in t
        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
        }

        // Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        // If all counts are zero, s and t are anagrams
        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        String s2 = "rat";
        String t2 = "car";

        System.out.println("Are \"" + s1 + "\" and \"" + t1 + "\" anagrams? " + isAnagram(s1, t1)); // Output: true
        System.out.println("Are \"" + s2 + "\" and \"" + t2 + "\" anagrams? " + isAnagram(s2, t2)); // Output: false
    }

    // another approach using sorting
    public static boolean isAnagram2(String s, String t) {
        // If lengths of s and t are not the same, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Convert both strings to character arrays
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        // Sort the character arrays using bubble sort
        bubbleSort(sArray);
        bubbleSort(tArray);

        // Compare the sorted arrays
        return arraysEqual(sArray, tArray);
    }

    private static void bubbleSort(char[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    char temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static boolean arraysEqual(char[] array1, char[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
}
