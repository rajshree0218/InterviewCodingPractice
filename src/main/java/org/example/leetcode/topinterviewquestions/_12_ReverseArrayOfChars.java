package org.example.leetcode.topinterviewquestions;

public class _12_ReverseArrayOfChars {

    public void reverseString(char[] s) {
        int start =0;
        int end=s.length-1;
        while(start<end){
            int temp = s[start];
            s[start] = s[end];
            s[end] = (char) temp;
            start++;
            end--;
        }
    }
}
