package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Given an integer n, return the number of trailing zeroes in n!. write a solution that works in logarithmic time complexity.
Examples:
Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
 */

public class FactorialTrailingZeroes{

    public static int trailingZeroes(int n) {
        int numOfFives =0;
        while(n/5>0){
            numOfFives += n/5;
            n = n/5;
        }
        return numOfFives;
    }

    public static void main(String[] args) {
        System.out.println("The number of trailing zeroes in factorial of 5 is: "+ trailingZeroes(5));
        System.out.println("The number of trailing zeroes in factorial of 3 is: "+ trailingZeroes(3));
        System.out.println("The number of trailing zeroes in factorial of 30 is: "+ trailingZeroes(30));
    }
}