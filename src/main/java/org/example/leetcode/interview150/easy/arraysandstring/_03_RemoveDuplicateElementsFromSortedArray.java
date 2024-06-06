package org.example.leetcode.interview150.easy.arraysandstring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//26. Remove Duplicates from Sorted Array
//Easy
//Topics
//Companies
//Hint
//Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
//
//Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
//
//Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
//Return k.
//Custom Judge:
//
//The judge will test your solution with the following code:
//
//int[] nums = [...]; // Input array
//int[] expectedNums = [...]; // The expected answer with correct length
//
//int k = removeDuplicates(nums); // Calls your implementation
//
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//}
//If all assertions pass, then your solution will be accepted.
//
//
//
//Example 1:
//
//Input: nums = [1,1,2]
//Output: 2, nums = [1,2,_]
//Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).
//Example 2:
//
//Input: nums = [0,0,1,1,1,2,2,3,3,4]
//Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).
//
//
//Constraints:
//
//1 <= nums.length <= 3 * 104
//-100 <= nums[i] <= 100
//nums is sorted in non-decreasing order.
public class _03_RemoveDuplicateElementsFromSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int output1 =  2;
        int[] expectedNums1 = {1,2,'_'};
        int k1 = removeDuplicates(nums1);
        nums1 = new int[]{1, 1, 2};
        int [] actualArr1 = removeDuplicatesGetArray(nums1);

        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int output2 = 5;
        int[] expectedNums2 = {0,1,2,3,4,'_','_','_','_','_'};
        int k2 = removeDuplicates(nums2);
        nums2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int [] actualArr2 = removeDuplicatesGetArray(nums2);

        boolean flag = true;
        flag = flag && k1 == output1 && Arrays.equals(expectedNums1, actualArr1);
        flag = flag && k2 == output2 && Arrays.equals(expectedNums1, actualArr2);
        if(flag)
            System.out.println("All tests are passed");
        else System.out.println("There are test failures");

        System.out.println(Arrays.toString(actualArr1));
        System.out.println(Arrays.toString(actualArr2));
    }
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }
        }
        for(int i: set){
            nums[index++] = nums[i];
            count++;
        }
        while(index<nums.length){
            nums[index++] = '_';
        }
        return count;
    }

    public static int[] removeDuplicatesGetArray(int[] nums) {
        int index = 0;
        int count = 0;
        int l1= nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for(int i: set){
            nums[index++] = i;
            count++;
        }
        while(index<l1){
            nums[index++] = '_';
        }
        return nums;
    }
}
