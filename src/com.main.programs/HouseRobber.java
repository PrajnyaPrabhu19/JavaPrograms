package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is
that adjacent houses have security system connected and it will automatically contact the police if two adjacent
houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 */

public class HouseRobber{

    public static int rob(int[] nums) {
        if(nums==null || nums.length ==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        //immediate neighbour
        int prev1 = Math.max(nums[0], nums[1]);
        //robbed 2 houses before
        int prev2 = nums[0];
        for(int i=2;i<nums.length;i++){
            int curr = Math.max(prev1, prev2+nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println("The maximum robbed money:"+ rob(nums));
    }
}