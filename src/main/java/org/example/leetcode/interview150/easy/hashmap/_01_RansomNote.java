package org.example.leetcode.interview150.easy.hashmap;

import java.util.HashMap;
import java.util.Map;

//383. Ransom Note
//Easy
//Topics
//Companies
//Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//
//Each letter in magazine can only be used once in ransomNote.
//
//
//
//Example 1:
//
//Input: ransomNote = "a", magazine = "b"
//Output: false
//Example 2:
//
//Input: ransomNote = "aa", magazine = "ab"
//Output: false
//Example 3:
//
//Input: ransomNote = "aa", magazine = "aab"
//Output: true
//
//
//Constraints:
//
//1 <= ransomNote.length, magazine.length <= 105
//ransomNote and magazine consist of lowercase English letters.
public class _01_RansomNote {

    public static void main(String[] args) {
        _01_RansomNote solution = new _01_RansomNote();

        String ransomNote1 = "a", magazine1 = "b";
        System.out.println("Input: ransomNote = \"" + ransomNote1 + "\", magazine = \"" + magazine1 + "\"");
        System.out.println("Output: " + solution.canConstruct(ransomNote1, magazine1));

        String ransomNote2 = "aa", magazine2 = "ab";
        System.out.println("\nInput: ransomNote = \"" + ransomNote2 + "\", magazine = \"" + magazine2 + "\"");
        System.out.println("Output: " + solution.canConstruct(ransomNote2, magazine2));

        String ransomNote3 = "aa", magazine3 = "aab";
        System.out.println("\nInput: ransomNote = \"" + ransomNote3 + "\", magazine = \"" + magazine3 + "\"");
        System.out.println("Output: " + solution.canConstruct(ransomNote3, magazine3));
    }

    // TC : O(m*n), SC : O(1)
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int i = magazine.indexOf(c, alphabet[c % 26]);
            if (i == -1) {
                return false;
            }
            alphabet[c % 26] = i + 1;
        }
        return true;
    }

    // TC : O(m+n), SC : O(26) or O(1)
    // Function to check if ransomNote can be constructed from magazine
    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] freq = new int[26]; // Array to store frequency of characters
        // Count frequency of characters in magazine
        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }
        // Check if ransomNote can be constructed
        for (char ch : ransomNote.toCharArray()) {
            if (freq[ch - 'a'] == 0) {
                return false; // Character not present in magazine
            }
            freq[ch - 'a']--; // Decrement frequency
        }
        return true;
    }

    // TC : O(m+n), SC : O(26) or O(1)
    // Function to check if ransomNote can be constructed from magazine
    public boolean canConstruct3(String ransomNote, String magazine) {
        // Create a frequency map for characters in magazine
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Iterate through ransomNote and check frequency map
        for (char ch : ransomNote.toCharArray()) {
            if (!freqMap.containsKey(ch) || freqMap.get(ch) <= 0) {
                return false; // Character not present in magazine or frequency exhausted
            }
            freqMap.put(ch, freqMap.get(ch) - 1); // Decrement frequency
        }

        return true;
    }

    public boolean canConstruct4(String ransomNote, String magazine) {
        int m = ransomNote.length();
        int n = magazine.length();

        if(m>n) return false;

        Map<Character, Integer> map = new HashMap<>();
        for(char ch : magazine.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for (char ch : ransomNote.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) <= 0) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }
        // for(int i=0; i<m-1; i++){
        //     if(!map.containsKey(ransomNote.charAt(i)) || map.get(ransomNote.charAt(i)) <=0 )
        //         return false;

        //     map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)-1));
        // }
        return true;
    }
}

