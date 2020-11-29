package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Make the change and return the minimum number of coins.
Ex: cents = 70, output = 3 {change = 50, 10, 10}
 */

public class MakingChange{

    public static int makeChange(int cents){
        int numOfCoins = 0;
        final int[] coins = {100, 50, 25, 10, 5, 1};
        for(int i=0;i<coins.length && cents>=1;i++){
            numOfCoins+=cents/coins[i];
            cents= cents % coins[i];
        }
        return numOfCoins;
    }

    public static void main(String[] args) {
        System.out.println("The min number of coins for 70 cents change is: "+ makeChange(70));
        System.out.println("The min number of coins for 123 cents change is: "+ makeChange(123));
        System.out.println("The min number of coins for 3 cents change is: "+ makeChange(3));
    }
}