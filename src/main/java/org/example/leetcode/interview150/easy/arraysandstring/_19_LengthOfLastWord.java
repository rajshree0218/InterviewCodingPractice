package org.example.leetcode.interview150.easy.arraysandstring;

public class _19_LengthOfLastWord {
    public static void main(String[] args) {
        String s1 = "   fly me   to   the moon  ";
        int output = 4;

        _19_LengthOfLastWord solution = new _19_LengthOfLastWord();
        System.out.println(solution.lengthOfLastWord("Hello World")); //5
        System.out.println(solution.lengthOfLastWord("   fly me   to   the moon  "));//4
        System.out.println(solution.lengthOfLastWord("luffy is still joyboy"));//6
    }

    // best: runtime: 0MS, memory:41.57MB
    // TC : O(n), and SC : O(1)
    public int lengthOfLastWord(String s) {
        s = s.trim();

        int length = 0;
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    public static int lengthOfLastWord2(String s) {
        s = s.trim();
        int len = 0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i) == ' '){
                len=0;
            } else {
                len++;
            }
        }
        return len;
    }

    public int lengthOfLastWord4(String s) {
        s = s.trim();
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else {
                return length;
            }
        }

        return length;
    }
}
