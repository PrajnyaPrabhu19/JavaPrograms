package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is the start time of
meeting i and F[i] is finish time of meeting i. The task is to find the maximum number of meetings that can be
accommodated in the meeting room. Print all meeting numbers

Input : s[] = {1, 3, 0, 5, 8, 5}, f[] = {2, 4, 6, 7, 9, 9}
Output : 1 2 4 5
 */

public class MeetingRooms{

    public static class mycomparator implements Comparator<Meeting>
    {
        @Override
        public int compare(Meeting o1, Meeting o2)
        {
            if (o1.end < o2.end)
            {
                // Return -1 if second object is bigger than first
                return -1;
            }
            else if (o1.end > o2.end){
                // Return 1 if second object is smaller than first
                return 1;
            }
            return 0;
        }
    }

    public static class Meeting{
        int start;
        int end;
        int num;
        public Meeting(int start, int end, int num){
            this.start = start;
            this.end = end;
            this.num = num;
        }
    }

    public static ArrayList<Integer> maxMeetings(int[] s, int[] e){
        ArrayList<Meeting> meetingsList = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i =0;i<s.length;i++){
            meetingsList.add(new Meeting(s[i], e[i], i+1));
        }
        mycomparator mc = new mycomparator();
        Collections.sort(meetingsList, mc);
        result.add(meetingsList.get(0).num);
        int endtime = meetingsList.get(0).end;
        for(int i=1; i<s.length;i++){
            if(meetingsList.get(i).start>=endtime){
                result.add(meetingsList.get(i).num);
                endtime=meetingsList.get(i).end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] s = {1,3,0,5,8,5};
        int[] e = {2,4,6,7,9,9};
        ArrayList<Integer> res = maxMeetings(s,e);
        for(int i: res){
            System.out.print(i+", ");
        }
    }
}
