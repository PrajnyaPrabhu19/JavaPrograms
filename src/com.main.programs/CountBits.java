package com.main.programs;
/*
Program to count the number of 1 bits in the given integer
 */

import java.io.*;
import java.util.*;

public class CountBits{

    //O(n) complexity
    public static short countBits(int n){
        short numBits =0;
        while(n!=0){
            numBits += (n&1);
            n >>>= 1;
        }
        return numBits;
    }

    public static void main(String[] args) {
        Random ran = new Random();
        int n = ran.nextInt(100);
        System.out.println("Number of bits in "+n+" is "+countBits(n));
    }
}