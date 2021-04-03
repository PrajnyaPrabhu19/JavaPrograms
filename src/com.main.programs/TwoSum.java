package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

public class TwoSum{

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for(int i=1;i<nums.length;i++){
            int comp = target - nums[i];
            if(map.containsKey(comp)){
                return (new int[]{map.get(comp),i});
            }
        }throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] res = twoSum(nums, 9);
        System.out.println("The two indices are: ["+res[0]+","+res[1]+"]");
        res = twoSum(nums, 6);
        System.out.println("The two indices are: ["+res[0]+","+res[1]+"]");
    }
}