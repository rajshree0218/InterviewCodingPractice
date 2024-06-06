package org.example.leetcode.topinterviewquestions;

//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,1]
//Output: true
//Example 2:
//
//Input: nums = [1,2,3,4]
//Output: false
//Example 3:
//
//Input: nums = [1,1,1,3,3,4,3,2,4,2]
//Output: true
//
//
//Constraints:
//
//1 <= nums.length <= 105
//-109 <= nums[i] <= 109
public class _04_ContainsDuplicates {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        boolean output1 = true;

        int[] nums2 = {1,2,3,4};
        boolean output2 = false;

        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
        boolean output3 = true;

        boolean flag1 = containsDuplicate(nums1);
        boolean flag2 = containsDuplicate(nums2);
        boolean flag3 = containsDuplicate(nums3);

        if(flag1==output1 && flag2==output2 && flag3==output3 )
            System.out.println("All Test cases passed");
        else    System.out.println("There are test failure");

    }

    public static boolean containsDuplicate(int[] nums) {

//        Arrays.sort(nums);
        for(int i = 0; i<nums.length;i++){
            for(int j = 0; j< nums.length-1; j++ ){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1])
                return true;
        }
        return false;
    }
}
