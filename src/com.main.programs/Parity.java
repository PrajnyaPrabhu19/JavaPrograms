package com.main.programs;

/*
The parity of binary word is 1 if the number of 1s in the word is odd, otherwise it is 0.
 */

import java.util.*;

public class Parity{

    //brute force O(n)
    public static short parity(long x){
        short result =0;
        while(x!=0){
            result ^= (x&1);
            x >>>=1;
        }
        return result;
    }

    //x&(x-1) =x; O(k) where k  = number of 1 bits in x
    public static short parity1(long x){
        short result =0;
        while(x!=0){
            result ^=1;
            x &= (x-1);
        }
        return result;
    }

    public static void main(String[] args) {
        Random ran = new Random();
        long n = ran.nextLong();
        System.out.println("Parity of "+n+" is "+parity(n));
        System.out.println("Parity of "+n+" is "+parity1(n));
    }
}