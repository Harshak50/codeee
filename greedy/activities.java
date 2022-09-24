package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class activities {
    // tags : disjoint
    // n activities given with start and end times
    // max no of activities can be done by single person assuming a person can do
    // single work at a time

    // condition: Activities are sorted acc to end time

    // [A0,A1,A2]
    // start = [10,12,20]
    // end = [20,25,30]
    // ans = 2(A0&A2) activities which are disjoint

    /*1. sort based on end time
    2. select 1st activity
    3. the next selected activity start time should be >= end time of previous activity (Non Overlapping)
          start time >= endtime(lst chosen activity)*/


          public static void main(String[] args) {
            int start[] = {1,3,0,5,8,5};
            int end[] = {2,4,6,7,9,9};
            //end time basis sorted activities

            //if not sorted
            int activities[][] = new int[start.length][3];
            for (int i = 0; i < start.length; i++) {
                activities[i][0] = i;
                activities[i][1]=start[i];
                activities[i][2]=end[i];
            }

        /*   col no 0 = index
             col no 1 = start[i]
             col no 2 = end[i]  */
            // lamdba function -> shortform
            Arrays.sort(activities, Comparator.comparingDouble(o->o[2]));



            int maxAct = 0;
            ArrayList<Integer> ans = new ArrayList<>();
            maxAct=1;
            ans.add(activities[0][0]);
            int lastEnd = activities[0][2];
            for (int i = 1; i < end.length; i++) {
                // if start tme > end 
                if(activities[i][1] > lastEnd){
                    maxAct++;
                    ans.add(activities[i][0]);
                    lastEnd = activities[i][2];
                }
            }

            System.out.println("maximum activities = "+maxAct);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(" A"+ans.get(i));
            }
          }

}
