package org.example.leetcode.interview150.easy.arraysandstring;

//14. Longest Common Prefix
//Easy
//Topics
//Companies
//Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".
//
//
//
//Example 1:
//
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
//Example 2:
//
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
//
//
//Constraints:
//
//1 <= strs.length <= 200
//0 <= strs[i].length <= 200
//strs[i] consists of only lowercase English letters.s
public class _20_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        String output1 = "fl";
        String[] strs2 = {"dog","racecar","car"};
        String output2= "";
        String longestCommonPrefix1 = longestCommonPrefix(strs1);
        String longestCommonPrefix2 = longestCommonPrefix(strs2);

        if(longestCommonPrefix1.equals(output1) && longestCommonPrefix2.equals(output2))
         System.out.println("All test are passed");
        else System.out.println("There are failures");

        System.out.println("Longest common prefix: " + longestCommonPrefix1);
        System.out.println("Longest common prefix: " + longestCommonPrefix2);
    }

    // runtime : 0ms, memory: 41.64MB
    // TC : O(s) , where s is the total number of character in all string in the array.
    // SC : O(1)
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length==0) {
            return "";
        }

        String prefix = strs[0];
        for(int i=1; i<strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }
}
