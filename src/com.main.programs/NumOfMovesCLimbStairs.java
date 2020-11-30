package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
You are climbing stairs. You can advance 1 to k steps at a time. Your destination is n steps.
Write a program to compute the number of ways to climb your destination.
 */

public class NumOfMovesCLimbStairs{

    public static int numofWays(int n, int k, int[] ways){
        if(n<=1){
            return 1;
        }
        if(ways[n]==0){
            for(int i=1;i<=k && n-i>=0; i++){
                ways[n]+=numofWays(n-i, k, ways);
            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int k=2 ;
        System.out.println("Number of ways to climb 4 stairs with max of 2 steps at a time is: "+ numofWays(n,k,new int[n+1]));
        n=10; k=3;
        System.out.println("Number of ways to climb 4 stairs with max of 2 steps at a time is: "+ numofWays(n,k,new int[n+1]));
    }
}