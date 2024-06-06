package org.example.leetcode.interview150.medium.slidingwindow;

//209. Minimum Size Subarray Sum
//Medium
//Topics
//Companies
//Given an array of positive integers nums and a positive integer target, return the minimal length of a
//subarray
// whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
//
//
//
//Example 1:
//
//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem constraint.
//Example 2:
//
//Input: target = 4, nums = [1,4,4]
//Output: 1
//Example 3:
//
//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0
//
//
//Constraints:
//
//1 <= target <= 109
//1 <= nums.length <= 105
//1 <= nums[i] <= 104
//
//
//Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
public class _01_MinSizeSubArray {
    public static void main(String[] args) {

        // Test cases
        int target1 = 7;
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int output = 2;
        System.out.println("Output for target1 and nums1: " + minSubArrayLen(target1, nums1));

        int target2 = 4;
        int[] nums2 = {1, 4, 4};
        int output2 = 1;
        System.out.println("Output for target2 and nums2: " + minSubArrayLen(target2, nums2));

        int target3 = 11;
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int output3 = 0;
        System.out.println("Output for target3 and nums3: " + minSubArrayLen(target3, nums3));

        int target4 = 11;
        int[] nums4 = {1,2,3,4,5};
        int expected4 = 3;
        System.out.println("Output for target3 and nums3: " + minSubArrayLen(target4, nums4));
    }

    //TC : O(n log n), And SC : O(1)
    public static int minSubArrayLen(int target, int[] nums){
        int n = nums.length;
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            // Shrink the window as much as possible
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    //below is not working for all test cases.
    // TC : O(n) and SC : O(1)
    public static int minSubArrayLen2(int target, int[] nums) {
        int minLength = 0;
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            if(nums[left] + nums[right] == target){
                minLength += 2;
                left++;
                right--;
            } else if(nums[left] == target){
                minLength+= 1;
                left++;
            } else if (nums[right] == target){
                minLength+= 1;
                right--;
            }
            left++;
            right--;
        }
        return minLength;
    }

}
