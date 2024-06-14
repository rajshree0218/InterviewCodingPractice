package org.example.interview.DewSolution.R1;

import java.util.Arrays;

public class DewSolutionL1 {
    public static void main(String[] args) {
        //Given an array containing only 0’s, 1’s, and 2’s, in-place sort it in linear time and using constant space.
        // Input : [0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0]
        // Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2]
        int[] arr = {0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0};
        int low = 0;
        int high = arr.length-1;
        int mid = 0;

        while(mid<=high){
            if(arr[mid]==0){
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;
            } else if(arr[mid] == 1){
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
        Arrays.stream(arr).forEach(e-> System.out.print(e+", "));
    }
}
