package org.example.leetcode.dailyChallenges.may;

import java.util.HashSet;
import java.util.Set;

public class _02_LargestPositiveIntegerThatExistsWithItsNegative {

    public static void main(String[] args) {
        int[] nums1 = {-1, 2, -3, 3};
        int output1 = 3;
        int[] nums2 = {-1, 10, 6, 7, -7, 1};
        int output2 = 7;
        int[] nums3 = {-10, 8, 6, 7, -2, -3};
        int output3 = -1;
        int[] nums4 = {-9,-43,24,-23,-16,-30,-38,-30};
        int output4 = -1;

        if(findMaxK(nums1)==output1 && findMaxK(nums2) == output2 && findMaxK(nums3) ==output3)
            System.out.println("All Test cases passed");
        else System.out.println("There are test failures");

//        System.out.println("Output for nums1: " + findMaxK(nums1));
//        System.out.println("Output for nums2: " + findMaxK(nums2));
//        System.out.println("Output for nums3: " + findMaxK(nums3));
    }

    // TC : O(n log n) , break down : arrays.sort : O(n log n), two pointer O(n)
    // SP : O(1),
    public static int findMaxK(int[] nums) {
        if(nums == null || nums.length ==0){
            return -1;
        }
        quickSort(nums);
        int start = 0;
        int end = nums.length-1;
        int maxK = -1;
        while(start<end){
            int sum = nums[start] + nums[end];
            if(sum==0){
                return nums[start] > -nums[start] ? nums[start] : -nums[start];
            } else if(sum<0){
                start++;
            } else {
                end--;
            }
        }
        return maxK;
    }

    private static void quickSort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int low, int high){
        if(low < high) {
            int pivotIndex = partition(arr, low, high);
            sort(arr, low, pivotIndex - 1);
            sort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i=low-1;
        for(int j=low; j<high; j++){
            if(arr[j]< pivot){
                i++;
                swap(arr, i,j);
            }
        }
        swap(arr, i+1,high);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // another way : not efficient
    public static int findMaxK2(int[] nums) {
        HashSet<Integer> positives = new HashSet<>();
        HashSet<Integer> negatives = new HashSet<>();
        int max = -1;

        for (int num : nums) {
            if (num > 0) {
                positives.add(num);
            } else if (num < 0) {
                negatives.add(-num);
            }
        }

        for (int num : positives) {
            if (negatives.contains(num)) {
                max = Math.max(max, num);
            }
        }

        return max;
        // HashSet<Integer> set = new HashSet<>();
        // int max = -1;

        // for (int num : nums) {
        //     if (num > 0) {
        //         set.add(num);
        //         if (set.contains(-num) || set.contains(Math.abs(num))) {
        //             max = Math.max(max, num);
        //         }
        //     }
        // }

        // return max;
    }

    // TC : O(n) :
    // SC : O(m) : as set is being used to store unique -ve integers.
    private int findMaxK3(int [] nums){

        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0)
                set.add(nums[i]);
        }

        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0 && set.contains(-nums[i])){
                max=Math.max(max,nums[i]);
            }
        }

        if(max==Integer.MIN_VALUE)
            return -1;

        return max;
    }

    public static int findMaxK5(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        HashSet<Integer> negatives = new HashSet<>();
        int maxK = -1;

        for (int num : nums) {
            if (num > 0) {
                if (negatives.contains(num)) {
                    maxK = Math.max(maxK, num);
                }
            } else if (num < 0) {
                negatives.add(-num);
            }
        }

        return maxK;
    }

    public static int findMaxK4(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = -1;

        for (int num : nums) {
            if (num != 0) {
                if (set.contains(-num)) {
                    max = Math.max(max, Math.abs(num));
                } else {
                    set.add(num);
                }
            }
        }

        return max != -1 ? max : -1;
    }

    public static int findMaxK6(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = -1;

        for (int num : nums) {
            if (num != 0) {
//                int absNum = Math.abs(num);
                int absNum = (num>=0) ? num: -num;
                if (set.contains(absNum)) {
                    max = (max>absNum) ? max : absNum;
                } else {
                    set.add(absNum);
                }
            }
        }

        return max != -1 ? max : -1;
    }

    public static int findMaxK7(int[] nums){
        if (nums == null || nums.length == 0) {
            return -1;
        }

        boolean[] negatives = new boolean[1001]; // Assuming range of nums[i] is from -1000 to 1000
        int maxK = -1;

        for (int num : nums) {
            if (num > 0 && negatives[num]) {
                maxK = Math.max(maxK, num);
            } else if (num < 0) {
                negatives[-num] = true;
            }
        }

        return maxK;
    }
}
