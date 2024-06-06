package org.example.leetcode.interview150.medium.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//3. Longest Substring Without Repeating Characters
//Medium
//Topics
//Companies
//Hint
//Given a string s, find the length of the longest
//substring
// without repeating characters.
//
//
//
//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//
//Constraints:
//
//0 <= s.length <= 5 * 104
//s consists of English letters, digits, symbols and spaces.
public class _02_LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        String s1 = "abcabcbb";
        System.out.println("Output for s1: " + lengthOfLongestSubstring(s1));

        String s2 = "bbbbb";
        System.out.println("Output for s2: " + lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        System.out.println("Output for s3: " + lengthOfLongestSubstring(s3));

        String s4 = " ";
        System.out.println("Output for s4: " + lengthOfLongestSubstring(s4));

        String s5 = "au";
        System.out.println("Output for s5: " + lengthOfLongestSubstring(s5));

        String s6 = "aa";
        System.out.println("Output for s6: " + lengthOfLongestSubstring(s6));

    }

    // TC : O(n) and
    // SC : O(min(n,m) where n is the length of the input string and m is the size of the character set (e.g., ASCII characters or Unicode characters).
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // TC : O(n) and SC: O(min(n,m))
    public static int lengthOfLongestSubstring2(String s){
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLen = 0;

        while (right < n) {
            char c = s.charAt(right);
            // If the character is already in the set, shrink the window from the left until it's not
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            // Add the character to the set and expand the window to the right
            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }


    //brute force
    // TC : O(n^3) and SC:O(min(n,m)
    //Time Complexity:
    //The time complexity of this approach is O(n^3), where n is the length of the input string s.
    //This is because we have two nested loops to consider every possible starting index and ending index for the substring, and for each substring, we call the allUnique method which has a time complexity of O(n) as it checks each character in the substring.
    //Space Complexity:
    //The space complexity is O(min(n, m)), where n is the length of the input string s and m is the size of the character set (in this case, the ASCII character set of size 128).
    //This is because we use a HashSet to store unique characters within each substring, and the size of the HashSet is bounded by the size of the character set.
    public static int lengthOfLongestSubstring3(String s) {

        int maxLength = 0;
        int n = s.length();

        for(int i=0;i<n;i++){
            for(int j=i+1; j<n; j++){
                if(allUnique(s, i, j)){
                    maxLength = Math.max(maxLength, j-i);
                }
            }
        }
        return maxLength;
    }

    private static boolean allUnique(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for(int i=start; i<end;i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
