package org.example.leetcode.leetcode75.arrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1431. Kids With the Greatest Number of Candies
//Easy
//Topics
//Companies
//Hint
//There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.
//
//Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
//
//Note that multiple kids can have the greatest number of candies.
//
//
//
//Example 1:
//
//Input: candies = [2,3,5,1,3], extraCandies = 3
//Output: [true,true,true,false,true]
//Explanation: If you give all extraCandies to:
//- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
//- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
//- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
//- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
//- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
//Example 2:
//
//Input: candies = [4,2,1,1,2], extraCandies = 1
//Output: [true,false,false,false,false]
//Explanation: There is only 1 extra candy.
//Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.
//Example 3:
//
//Input: candies = [12,1,12], extraCandies = 10
//Output: [true,false,true]
//
//
//Constraints:
//
//n == candies.length
//2 <= n <= 100
//1 <= candies[i] <= 100
//1 <= extraCandies <= 50
public class _03_KidsWithGreatestNumberOfCandies {

    public static void main(String[] args) {
        _03_KidsWithGreatestNumberOfCandies solution = new _03_KidsWithGreatestNumberOfCandies();

        // Example 1
        int[] candies1 = {2, 3, 5, 1, 3};
        int extraCandies1 = 3;
        List<Boolean> result1 = solution.kidsWithCandies(candies1, extraCandies1);
        System.out.println(result1); // Output: [true, true, true, false, true]

        // Example 2
        int[] candies2 = {4, 2, 1, 1, 2};
        int extraCandies2 = 1;
        List<Boolean> result2 = solution.kidsWithCandies(candies2, extraCandies2);
        System.out.println(result2); // Output: [true, false, false, false, false]

        // Example 3
        int[] candies3 = {12, 1, 12};
        int extraCandies3 = 10;
        List<Boolean> result3 = solution.kidsWithCandies(candies3, extraCandies3);
        System.out.println(result3); // Output: [true, false, true]

        // Example 4
        int[] candies4 = {2, 8, 7};
        int extraCandies4 = 1;
        List<Boolean> result4 = solution.kidsWithCandies(candies4, extraCandies4);
        System.out.println(result4); // Output: [false, true, true]
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = candies[0];
        for(int i=0; i<candies.length; i++){
            if(max<candies[i]){
                max = candies[i];
            }
        }

        for(int i=0; i<candies.length; i++){
            if(candies[i] + extraCandies >= max){
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }

    // using java8
    public List<Boolean> kidsWithCandies2(int[] candies, int extraCandies) {
        // Find the maximum number of candies among all kids
        int maxCandies = Arrays.stream(candies).max().getAsInt();

        // Initialize a list to store the result
        List<Boolean> result = new ArrayList<>();

        // Check if each kid can have the greatest number of candies after adding extra candies
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }

    // below is not working for test case 4.
    public List<Boolean> kidsWithCandies3(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = candies[0];

        for(int i=0; i<candies.length; i++){
            if(max < candies[i]){
                max = candies[i];
            }
            if(candies[i] + extraCandies >= max){
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}
