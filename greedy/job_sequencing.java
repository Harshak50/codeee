package greedy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class job_sequencing {
    /*
     * Given an array of jobs where every job has a deadline and profile if the job
     * is finished before deadline. It is also Given
     * every job takes single unit of time, so minimum possible deadline for each
     * job is 1.
     * Maximize total profit if one job can be done at a time
     * 
     * Job A = 4,20
     * Job B = 1,10
     * Job C = 1,40
     * Job D = 1,30
     * ans = C A
     * 
     * sort jobs based on max profile
     * track time , array list to add jobs
     * if(job deadline < time) {
     * add(job in sequence)
     * time++;
     * }
     * 
     */
    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int id, int d, int p) {
            this.id = id;
            deadline = d;
            profit = p;

        }
    }

    public static void main(String[] args) {
        int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit); // descending order of profit

        ArrayList<Integer> seq = new ArrayList<>();

        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
          Job curr = jobs.get(i);  
          if(curr.deadline > time){
            seq.add(curr.id);
            time++;
          }
        }

        System.out.println("Max jobs = "+seq.size());

        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i)+" ");
        }
        System.out.println();

    }

}
