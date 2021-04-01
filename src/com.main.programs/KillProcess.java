package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Given n processes, each process has a unique PID (process id) and its PPID (parent process id).
Each process only has one parent process, but may have one or more children processes. This is just like a tree structure.
Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct
positive integers.
We use two list of integers to represent a list of processes, where the first list contains PID for each process and
the second list contains the corresponding PPID.

Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that
will be killed in the end. You should assume that when a process is killed, all its children processes will be killed.
No order is required for the final answer.
 */
public class KillProcess{

    public static List<Integer> killProcess(int[] pid, int[] ppid, int kill){

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> set = new ArrayList<>();
        for(int i=0;i< ppid.length;i++){
            List<Integer> list = map.getOrDefault(ppid[i], new ArrayList<>());
            list.add(pid[i]);
            map.put(ppid[i], list);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(kill);
        while(q.size() != 0){
            int node = q.poll();
            //res[p++] = node;
            set.add(node);
            if(map.containsKey(node)){
                for(int child: map.get(node)){
                    q.add(child);
                }
            }
        }

        return set;
    }

    public static void main(String[] args) {
        int[] pid = {1, 3, 10, 5};
        int[] ppid = {3, 0, 5, 3};
        List<Integer> list = killProcess(pid, ppid, 5);
        System.out.println("Process to be killed:");
        for(int i=0;i< list.size();i++){
            System.out.print(list.get(i)+",");
        }
    }
}