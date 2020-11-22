package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
0-1 knapsack problem: we are given a list of weights and values of the items and a bag that can hold a certain maximum weight.
The output should be the total maximum value of items whose weights are less than or equal to weight of the bag.
 */

public class Knapsack{

    public static int knapsack(int[] v, int[] w, int n , int W, Map<String, Integer> lookup){
        // base cases:
        if(W<0){
            return Integer.MIN_VALUE;
        }
        if(n<0 || W==0){
            return 0;
        }
        String key = n + "|" + W;
        if(!lookup.containsKey(key)){
            int include =v[n]+ knapsack(v, w, n-1, W-w[n], lookup);
            int exclude = knapsack(v, w, n-1 , W, lookup);
            lookup.put(key, Integer.max(include, exclude));
        }
        return lookup.get(key);
    }

    public static void main(String[] args) {
        int[] v = { 20, 5, 10, 40, 15, 25 };
        int[] w = {  1, 2,  3,  8,  7, 4 };
        int W = 10;
        Map<String, Integer> lookup = new HashMap<>();
        System.out.println("Knapsack value is: " + knapsack(v,w,v.length-1, W, lookup));
    }
}