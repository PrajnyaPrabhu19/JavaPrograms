package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.
Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
 */

public class MaxGap{

    public static int maximumGap(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        Arrays.sort(nums);
        int max =0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]>max){
                max= nums[i+1]-nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 6, 9, 1};
        int[] arr2 = new int[]{1};
        System.out.println("The maximum gap in arr1 is: "+ maximumGap(arr));
        System.out.println("The maximum gap in arr2 is: "+ maximumGap(arr2));
    }
}