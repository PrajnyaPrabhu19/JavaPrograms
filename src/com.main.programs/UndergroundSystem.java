package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Implement the UndergroundSystem class:

void checkIn(int id, string stationName, int t)
A customer with a card id equal to id, gets in the station stationName at time t.
A customer can only be checked into one place at a time.
void checkOut(int id, string stationName, int t)
A customer with a card id equal to id, gets out from the station stationName at time t.
double getAverageTime(string startStation, string endStation)
Returns the average time to travel between the startStation and the endStation.
The average time is computed from all the previous traveling from startStation to endStation that happened directly.
Call to getAverageTime is always valid.
You can assume all calls to checkIn and checkOut methods are consistent. If a customer gets in at time t1 at some station,
they get out at time t2 with t2 > t1. All events happen in chronological order.
Input
["UndergroundSystem","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime"]
[[],[10,"Leyton",3],[10,"Paradise",8],["Leyton","Paradise"],[5,"Leyton",10],[5,"Paradise",16],["Leyton","Paradise"],[2,"Leyton",21],[2,"Paradise",30],["Leyton","Paradise"]]

Output
[null,null,null,5.00000,null,null,5.50000,null,null,6.66667]

Explanation
UndergroundSystem undergroundSystem = new UndergroundSystem();
undergroundSystem.checkIn(10, "Leyton", 3);
undergroundSystem.checkOut(10, "Paradise", 8);
undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.00000
undergroundSystem.checkIn(5, "Leyton", 10);
undergroundSystem.checkOut(5, "Paradise", 16);
undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.50000
undergroundSystem.checkIn(2, "Leyton", 21);
undergroundSystem.checkOut(2, "Paradise", 30);
undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 6.66667
 */

public class UndergroundSystem {

    Map<Integer, String> ids;
    Map<String, List<Integer>> statn_time;

    public UndergroundSystem() {
        ids = new HashMap<>();
        statn_time = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        ids.put(id, stationName);
        List<Integer> list = new ArrayList<>();
        list.add(t);
        statn_time.put(stationName+id, list);
    }

    public void checkOut(int id, String stationName, int t) {
        String start = ids.get(id);
        int ts = statn_time.get(start+id).get(0);
        String final_statn = start+"-"+stationName;
        int total = t-ts;
        List<Integer> list = new ArrayList<>();
        if(statn_time.containsKey(final_statn)){
            list = statn_time.get(final_statn);
            list.add(total);
            statn_time.put(final_statn, list);
        }
        else{
            list.add(total);
            statn_time.put(final_statn, list);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String finalStation = startStation+"-"+endStation;
        List<Integer> list = statn_time.get(finalStation);
        int size = list.size();
        int total =0;
        for(int i: list){
            total+=i;
        }
        return ((double)total/size);
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(10, "Leyton", 3);
        undergroundSystem.checkOut(10, "Paradise", 8);
        System.out.println("Time to travel from Leyton to Paradise: "+undergroundSystem.getAverageTime("Leyton", "Paradise"));
        undergroundSystem.checkIn(5, "Leyton", 10);
        undergroundSystem.checkOut(5, "Paradise", 16);
        System.out.println("Time to travel from Leyton to Paradise: "+undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.50000
        undergroundSystem.checkIn(2, "Leyton", 21);
        undergroundSystem.checkOut(2, "Paradise", 30);
        System.out.println("Time to travel from Leyton to Paradise: "+undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 6.66667
    }
}