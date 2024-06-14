package org.example.interview.ITCInfotech.R1;

import java.util.HashMap;

public class ITCInfotechL1 {
    public static void main(String[] args) {
        //ahsgeajuolrhhttrewqj
        String target = "rajshree"; //
        //gauolhhttwqj
        // rajshree
        String s = "ahsgeajuolrhhttrewqj";
        String name = "rajshree";
        int[] charCount = new int[26]; // Assuming only lowercase English alphabets are used

        // Count occurrences of each character in the given string
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Initialize variables to keep track of how many characters from the name are used
        int nameLength = name.length();
        int[] usedChars = new int[26]; // Array to keep track of characters already used

        // Initialize count for how many times the name can be formed
        int nameCount = Integer.MAX_VALUE;

        // Check if each character in the name is available and count the minimum occurrence
        for (int i = 0; i < nameLength; i++) {
            char c = name.charAt(i);
            if (charCount[c - 'a'] == 0 || usedChars[c - 'a'] >= charCount[c - 'a']) {
                // If any character in the name is not available or all occurrences are used, name can't be formed
                nameCount = 0;
                break;
            } else {
                // Update count of how many times the name can be formed based on the availability of characters
                nameCount = Math.min(nameCount, charCount[c - 'a'] / (usedChars[c - 'a'] + 1));
                usedChars[c - 'a']++;
            }
        }

        System.out.println("Your name can be formed " + nameCount + " times with each character being used once.");

        // Subclass
        // protected void speak
        //subclass
        // public void speak


        // no lock in mysql
        // java, sb, ms, spring batch, mysql oracle, cloud, ai, devops tool,

        getNameCount();
    }

    public static void getNameCount() {
        String s = "ahsgeajuolrhhttrewqj";
        String name = "rajshree";

        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> nameCharCount = new HashMap<>();
        for (char c : name.toCharArray()) {
            nameCharCount.put(c, nameCharCount.getOrDefault(c, 0) + 1);
        }

        int nameCount = Integer.MAX_VALUE;

        for (char c : nameCharCount.keySet()) {
            int nameCharOccurrences = nameCharCount.get(c);
            if (!charCount.containsKey(c) || charCount.get(c) < nameCharOccurrences) {
                nameCount = 0;
                break;
            } else {
                nameCount = Math.min(nameCount, charCount.get(c) / nameCharOccurrences);
            }
        }

        System.out.println("Your name can be formed " + nameCount + " times with each character being used once.");
    }
    public static int countOccurrence(String input, String name){
        int count =0;
        int index =0;
        while((index = input.indexOf(name, index)) != -1){
            count++;
            index+= name.length();
        }
        return count;
    }
}

class A{
    private void spr(){
        System.out.println("test");
    }
}

class B extends A{
    protected void spr(){
        System.out.println("test");
    }
}
