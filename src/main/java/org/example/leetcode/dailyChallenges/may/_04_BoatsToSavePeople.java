package org.example.leetcode.dailyChallenges.may;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//881. Boats to Save People
//Medium
//Topics
//Companies
//You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
//
//Return the minimum number of boats to carry every given person.
//
//
//
//Example 1:
//
//Input: people = [1,2], limit = 3
//Output: 1
//Explanation: 1 boat (1, 2)
//Example 2:
//
//Input: people = [3,2,2,1], limit = 3
//Output: 3
//Explanation: 3 boats (1, 2), (2) and (3)
//Example 3:
//
//Input: people = [3,5,3,4], limit = 5
//Output: 4
//Explanation: 4 boats (3), (3), (4), (5)
//
//
//Constraints:
//
//1 <= people.length <= 5 * 104
//1 <= people[i] <= limit <= 3 * 104
public class _04_BoatsToSavePeople {

    public static void main(String[] args) {
       int[] people1 = {1,2};
       int limit1 = 3;
       int output1 = 1;
       //Explanation: 1 boat (1, 2)

       int[] people2 = {3,2,2,1};
       int limit2 = 3;
       int output2 = 3;
       //Explanation: 3 boats (1, 2), (2) and (3)

       int[] people3 = {3,5,3,4};
       int limit3 = 5;
       int output3 = 4;
//        Explanation: 4 boats (3), (3), (4), (5)

        int boat1 = numRescueBoats(people1, limit1);
        int boat2 = numRescueBoats(people2, limit2);
        int boat3 = numRescueBoats(people3, limit3);

        if(boat1 == output1 && boat2 == output2 && boat3 == output3)
            System.out.println("All tests are passed");
        else System.out.println("There are failure");

//        System.out.println(boat1);
//        System.out.println(boat2);
//        System.out.println(boat3);
    }

    public static int numRescueBoats(int[] people, int limit){
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int boat = 0;
        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
                right--;
            } else {
                right--;
            }
            boat++;
        }
        return boat;
    }

    public int numRescueBoats2(int[] people, int limit) {
        // Count the frequency of each weight using a hashmap
        Map<Integer, Integer> weightsCount = new HashMap<>();
        for (int weight : people) {
            weightsCount.put(weight, weightsCount.getOrDefault(weight, 0) + 1);
        }

        int boats = 0;

        // Iterate through the hashmap
        for (Map.Entry<Integer, Integer> entry : weightsCount.entrySet()) {
            int weight = entry.getKey();
            int count = entry.getValue();

            // Distribute people of the current weight into boats
            while (count > 0) {
                int remainingWeight = limit - weight;

                // If there's a person with remaining weight, remove one from the hashmap and distribute into a boat
                if (weightsCount.containsKey(remainingWeight) && weightsCount.get(remainingWeight) > 0) {
                    count--;
                    weightsCount.put(remainingWeight, weightsCount.get(remainingWeight) - 1);
                }

                // Remove one person of the current weight from the hashmap and distribute into a boat
                count--;
                boats++;
            }
        }

        return boats;
    }

    // below is not working for 3rd Test Case
    public static int numRescueBoats3(int[] people, int limit) {
        float boat = 0;
        int sum = 0;
        for(int i=0; i<people.length;i++){
            sum+=people[i];
        }
        boat = (float) sum /limit;
        int scale = BigDecimal.valueOf(boat).scale();
        System.out.println(scale);
        if(scale > 1){
            boat = boat+1;
        }
        return (int)boat;
    }

}
