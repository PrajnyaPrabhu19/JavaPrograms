package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.
Input: numerator = 1, denominator = 2
Output: "0.5"

Input: numerator = 2, denominator = 3
Output: "0.(6)"
 */

public class FractionToDecimal{

    public static String fractionToDecimal(int n, int d){
        if(n==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if(n*d < 0){
            sb.append("-");
        }
        long num = Math.abs((long) n);
        long den = Math.abs((long) d);
        sb.append(num/den);
        long rem = num % den;
        if(rem==0){
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(rem!=0){
            if(map.containsKey(rem)){
                sb.insert(map.get(rem), "(");
                sb.append(")");
                break;
            }
            map.put(rem, sb.length());
            rem =rem*10;
            sb.append(rem/den);
            rem =rem%den;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 2, denum = 3;
        System.out.println("The decimal of "+num+"/"+denum+" is: "+ fractionToDecimal(num, denum));
        num =1;
        denum =2;
        System.out.println("The decimal of "+num+"/"+denum+" is: "+ fractionToDecimal(num, denum));
    }
}