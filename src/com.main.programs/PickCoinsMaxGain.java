package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Even number of coins are placed in a line. Two players take turn to pick up coins.
The player with higher total value of picked up coins wins.
Compute the maximum total value for starting player.
Example: <10,25,5,1,10,5>
The optimum revenue for first player is 31.
By greedy method, the first player will make only 25.

Time complexity: O(n2)
 */

public class PickCoinsMaxGain{

    public static int maxGain(int[] coins, int a, int b, int[][] gainMemo){
        if(a>b){
            return 0;
        }
        if(gainMemo[a][b]==0){
            int maxRevA = coins[a]+ Math.min(maxGain(coins, a+2, b, gainMemo), maxGain(coins, a+1, b-1, gainMemo));
            int maxRevB = coins[b]+ Math.min(maxGain(coins, a, b-2, gainMemo), maxGain(coins, a+1, b-1, gainMemo));
            gainMemo[a][b] = Math.max(maxRevA, maxRevB);
        }
        return gainMemo[a][b];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{10,25,5,1,10,5};
        int res = maxGain(coins, 0, coins.length-1, new int[coins.length][coins.length]);
        System.out.println("The maximum gain that the first player can make is: "+ res);
    }
}