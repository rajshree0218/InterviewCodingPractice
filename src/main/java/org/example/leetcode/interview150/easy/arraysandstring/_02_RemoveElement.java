package org.example.leetcode.interview150.easy.arraysandstring;

import java.util.Arrays;

//27. Remove Element
//Easy
//Topics
//Companies
//Hint
//Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
//
//Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
//
//Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
//Return k.
//Custom Judge:
//
//The judge will test your solution with the following code:
//
//int[] nums = [...]; // Input array
//int val = ...; // Value to remove
//int[] expectedNums = [...]; // The expected answer with correct length.
//                            // It is sorted with no values equaling val.
//
//int k = removeElement(nums, val); // Calls your implementation
//
//assert k == expectedNums.length;
//sort(nums, 0, k); // Sort the first k elements of nums
//for (int i = 0; i < actualLength; i++) {
//    assert nums[i] == expectedNums[i];
//}
//If all assertions pass, then your solution will be accepted.
//
//
//
//Example 1:
//
//Input: nums = [3,2,2,3], val = 3
//Output: 2, nums = [2,2,_,_]
//Explanation: Your function should return k = 2, with the first two elements of nums being 2.
//It does not matter what you leave beyond the returned k (hence they are underscores).
//Example 2:
//
//Input: nums = [0,1,2,2,3,0,4,2], val = 2
//Output: 5, nums = [0,1,4,0,3,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
//Note that the five elements can be returned in any order.
//It does not matter what you leave beyond the returned k (hence they are underscores).
//
//
//Constraints:
//
//0 <= nums.length <= 100
//0 <= nums[i] <= 50
//0 <= val <= 100
public class _02_RemoveElement {
    public static void main(String[] args) {

        int[] nums = {3,2,2,3};
        int val = 3;
        int output = 2;
        int[] expectedNums = {2,2,'_','_'};

        boolean flag = true;
        flag = flag && removeElement(nums, val) == output;

        System.out.println();
        if(flag)
            System.out.println("All test cases are passed");
        else    System.out.println("There are failures");

        // Test cases
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int[] expectedNums1 = {2, 2, '_', '_'};
        test(nums1, val1, expectedNums1);

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int[] expectedNums2 = {0, 1, 4, 0, 3, '_', '_', '_'};
        test(nums2, val2, expectedNums2);
    }

    // Helper method to test removeElement function
    private static void test(int[] nums, int val, int[] expectedNums) {
        int k = removeElement(nums, val);
        System.out.print("Output: " + k + ", nums = [");
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(nums[i]);
        }
        System.out.println("]");
        System.out.println("Expected: " + expectedNums.length + ", nums = " + Arrays.toString(expectedNums));
        System.out.println();
    }

    // time complexity : o(n), where n is the length of array
    /* space complexity : o(1), as program doesn't use any additional data structure or arrays that grow with the input size.
        It operates directly on the given nums array in-place.
        The program defines only a few integer variables (k, i) and uses a constant amount of space for them, regardless of the input size.
     */
    private static int removeElement(int[] nums, int val) {
        int index = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                nums[index++] =  nums[i];
                count++;
            }
        }
        while(index<nums.length){
            nums[index++] = '_';
        }
        return count;
    }

    private static int removeElementBruteForceAlgo(int[] nums, int val) {
        int[] expectedNums = new int[nums.length];
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                expectedNums[count++] =  nums[i];
            }
        }
        while(count<nums.length){
            expectedNums[count++] = '_';
        }

        for (int expectedNum : expectedNums) {
            System.out.print(expectedNum + " ");
        }

        return count;
    }
}
