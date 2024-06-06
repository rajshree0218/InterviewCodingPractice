package org.example.leetcode.dailyChallenges.may;

//165. Compare Version Numbers
//Medium
//Topics
//Companies
//Given two version numbers, version1 and version2, compare them.
//
//Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.
//
//To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
//
//Return the following:
//
//If version1 < version2, return -1.
//If version1 > version2, return 1.
//Otherwise, return 0.
//
//
//Example 1:
//
//Input: version1 = "1.01", version2 = "1.001"
//Output: 0
//Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
//Example 2:
//
//Input: version1 = "1.0", version2 = "1.0.0"
//Output: 0
//Explanation: version1 does not specify revision 2, which means it is treated as "0".
//Example 3:
//
//Input: version1 = "0.1", version2 = "1.1"
//Output: -1
//Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.
//
//
//Constraints:
//
//1 <= version1.length, version2.length <= 500
//version1 and version2 only contain digits and '.'.
//version1 and version2 are valid version numbers.
//All the given revisions in version1 and version2 can be stored in a 32-bit integer.
public class _03_CompareVersionNumber {
    public static void main(String[] args) {
        String version1 = "1.01";
        String version2 = "1.001";

        int result = compareVersion(version1, version2);
        System.out.println(result);
    }

    // runtime : 1ms, memory : 41.9
    // TC and SC : O(n)
    //This program splits the input version strings by the dot character ('.'). It then iterates over the revisions of both versions, comparing them numerically. If a version string does not have a revision at a certain index, it's considered as zero. If all revisions are equal, the program returns 0. Otherwise, it returns -1 if the first version is smaller and 1 if the first version is larger.
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i=0;
        while(i< version1.length() || i<version2.length()){
            int num1 = i<v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i<v2.length ? Integer.parseInt(v2[i]) : 0;

            if(num1 < num2){
                return -1;
            } else if(num1> num2){
                return 1;
            }
            i++;
        }
        return 0;
    }

    // runtime : 1ms, memory : 41.1
    public int compareVersion2(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i=0;
        while(i< version1.length() || i<version2.length()){
            int num1 = i<v1.length ? convertToInt(v1[i]) : 0;
            int num2 = i<v2.length ? convertToInt(v2[i]) : 0;

            if(num1 < num2){
                return -1;
            } else if(num1> num2){
                return 1;
            }
            i++;
        }
        return 0;
    }

    public int convertToInt(String version){
        int num = 0;
        for(int i=0; i<version.length();i++){
            char c = version.charAt(i);
            num = num * 10 + (c - '0');
        }
        return num;
    }
}
