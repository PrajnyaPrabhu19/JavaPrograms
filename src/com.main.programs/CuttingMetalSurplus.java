package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Mr. Octopus has recently shut down hisfactory and want to sell off his metal rods to a local businessman.
In order to maximize profit, he should sellthe metal of same size and shape. If he sells metal rods of length ,
he receives N x L xmetal_price. The remaining smallermetal rods will be thrown away. To cut the metal rods,
he needs to pay cost_per_cut for every cut. What is the maximum amount of money Mr.Octopus can make?
Sample Input:
cost_per_cut=1
metal_price=10
the number of rods, L=3
rods=[26, 103, 59]
Sample Output:
1770
 */

public class CuttingMetalSurplus{
    public static void main(String[] args) {
        int cutCost1 = 1, price1 = 10;
        int[] nums1 = {26, 59, 103};
        int cutCost2 = 100, price2 = 10;
        int[] nums2 = {26, 59, 103};
        int cutCost3 = 1, price3 = 10;
        int[] nums3 = {30, 59, 110};
        System.out.println(maxProfit(nums1, cutCost1, price1));
        System.out.println(maxProfit(nums2, cutCost2, price2));
        System.out.println(maxProfit(nums3, cutCost3, price3));
    }

    private static int maxProfit(int[] nums, int cutCost, int price) {
        int maxLength = 0;
        for(int n : nums)
            maxLength = Math.max(n, maxLength);
        return helper(nums, cutCost, price, 0, maxLength, new HashMap<>());
    }


    private static int helper(int[] nums, int cutCost, int price, int l, int r, Map<String, Integer> memo) {
        int res = 0;
        if(l >= r)
            return res;
        if(memo.containsKey(l + "_" + r))
            return memo.get(l + "_" + r);
        int rangeL = l, rangeR = r;
        while(l < r) {
            int m1 = l + (r - l)/2;
            int m2 = m1 + 1;
            if(getCost(nums, cutCost, price, m1) > getCost(nums, cutCost, price, m2))
                r = m1;
            else
                l = m2;
        }
        int resR = helper(nums, cutCost, price, l+1, rangeR, memo);
        int resL = helper(nums, cutCost, price, rangeL, l-1, memo);
        res = Math.max(getCost(nums, cutCost, price, l), Math.max(res, Math.max(resL, resR)));
        memo.put(rangeL+"_"+rangeR, res);
        return res;
    }

    public static int getCost(int[] nums, int cutCost, int price, int length) {
        int res = 0;
        int cost = 0;
        if(length == 0) {
            return Integer.MIN_VALUE;
        }
        for(int i=0;i<nums.length;i++) {
            int numOfCuts = nums[i]/length;
            res += numOfCuts*length*price;
            cost += (numOfCuts-1) * cutCost + (nums[i]%length != 0 ? 1 : 0) * cutCost;
        }
        res -= cost;
        return res;
    }
}
