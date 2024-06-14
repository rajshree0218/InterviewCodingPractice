package org.example.interview.Osttra.R1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OsttraL1 {
    public static void main(String[] args) {
        // anagram.
        // i/p: rajshree
        // i/p: eerhsajr

//        String s1 = "rajshree";
//        String s2 = "eerhsaje";
//        boolean flag = true;
//
//        if(s1.length() != s2.length()) flag = false;
//
//        Map<Character, Integer> map = new HashMap<>();
//        for(char ch : s1.toCharArray()){
//            map.put(ch, map.getOrDefault(ch,0)+1);
//        }
//
//        for(char ch : s2.toCharArray()){
//            if(!map.containsKey(ch) || map.get(ch) <= 0){
//                flag = false;
//            }
//            map.put(ch, map.get(ch)-1);
//        }
//
//        if(flag)
//            System.out.println("Both are anagram");
//        else
//            System.out.println("Not anagram");


        // longest sub array :
        int[] arr = {1,2,3,7,8,4,5,6,7,9,4,5,6,7,8,9,1,2,3,5};
        //1,2,3 //7,8 // 4,5,6,7 // 9
        // max length of sub array
//        4,5,6,7 -> 4
        int maxLength = 0;
        Map<List<Integer>, Integer> map1 = new HashMap<>();
        List<Integer> subArray = new ArrayList<>();
        // {1,2,3}, 3    //7,8  2
        for(int i=0; i<arr.length-1; i++){ // 8
            if(arr[i+1] - arr[i] == 1){ //7 T
                subArray.add(arr[i]); // 1 // 2 // 3
                maxLength = maxLength+1;//1 //2 //3
            } else {
                map1.put(subArray, maxLength);
                subArray.add(arr[i]);
                maxLength = 0;
                maxLength = maxLength+1;
            }
        }
        System.out.println(maxLength);

        findMaxLengthOfSubArray();
        printSubArrayWithitsLength();


    }

    public static int findMaxLengthOfSubArray(){
        int[] arr = {1,2,3,7,8,4,5,6,7,9,4,5,6,7,8,9,1,2,3,5};
        int maxLength = 0;
        int currentLength = 1; // Initialize the length of the current consecutive subarray

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == 1) {
                currentLength++; // Increment the length of the current consecutive subarray
            } else {
                maxLength = Math.max(maxLength, currentLength); // Update maxLength if currentLength is greater
                currentLength = 1; // Reset currentLength for the new consecutive subarray
            }
        }

        // Update maxLength if the last consecutive subarray is longer
        maxLength = Math.max(maxLength, currentLength);

        System.out.println("Maximum length of consecutive subarray: " + maxLength);
        return maxLength;
    }

    public static void printSubArrayWithitsLength(){
        int[] arr = {1,2,3,7,8,4,5,6,7,9,4,5,6,7,8,9,1,2,3,5};
        List<List<Integer>> consecutiveSubarrays = new ArrayList<>();
        List<Integer> currentSubarray = new ArrayList<>();
        int currentLength = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == 1) {
                currentSubarray.add(arr[i - 1]);
                currentLength++;
            } else {
                currentSubarray.add(arr[i - 1]);
                consecutiveSubarrays.add(new ArrayList<>(currentSubarray)); // Add the current subarray to the list
                currentSubarray.clear();
                currentLength = 1;
            }
        }

        // Add the last consecutive subarray
        currentSubarray.add(arr[arr.length - 1]);
        consecutiveSubarrays.add(new ArrayList<>(currentSubarray));

        // Find the maximum length among the consecutive subarrays
        int maxLength = 0;
        for (List<Integer> subarray : consecutiveSubarrays) {
            maxLength = Math.max(maxLength, subarray.size());
        }

        System.out.println("Maximum length of consecutive subarrays: " + maxLength);
        System.out.println("Consecutive subarrays with maximum length:");
        for (List<Integer> subarray : consecutiveSubarrays) {
            if (subarray.size() == maxLength) {
                System.out.println(subarray + " (" + subarray.size() + ")");
            }
        }

    }
}
