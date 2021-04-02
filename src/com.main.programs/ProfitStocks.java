package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
***** variation 1: You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future
to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

***** variation 2: You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one
share of the stock multiple times).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 */
public class ProfitStocks{

    //variation1
    public static int profit(int[] prices){
        int profit =0;
        int buy = Integer.MAX_VALUE;
        for(int i=0;i< prices.length;i++){
            if(prices[i]<buy){
                buy = prices[i];
            }
            else if(prices[i]-buy>profit){
                profit = prices[i]-buy;
            }
        }
        return profit;
    }
    //variation 2
    public static int maxProfit(int[] prices) {
        int maxProf =0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                maxProf+= prices[i]-prices[i-1];
            }
        }
        return maxProf;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("The profit is: "+profit(prices));
        System.out.println("The max profit is: "+maxProfit(prices));
    }
}