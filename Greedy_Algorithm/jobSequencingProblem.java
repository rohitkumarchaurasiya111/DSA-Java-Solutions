package Greedy_Algorithm;
//Given an array of jobs where every job has a deadline and profit if the job is finished before the deadline. It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1. Maximize the total profit if only one job can be scheduled at a time.

// Job A = 4, 20
// Job B = 1, 10
// Job C = 1, 40
// ans = C, A
// Job D = 1, 30

import java.util.ArrayList;
import java.util.Collections;


public class jobSequencingProblem {
    static class job {
        int id;
        int deadline;
        int profit;

        public job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        ArrayList<job> Job_obj = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            Job_obj.add(new job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // Sort the objects in descending order
        Collections.sort(Job_obj, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int timeLine = 0; //Current timeline
        int max_profit = 0;

        for (int i = 0; i < Job_obj.size(); i++) {
            job curr = Job_obj.get(i);  //Current job
            if (timeLine < curr.deadline) {
                seq.add(curr.id);
                timeLine++;
                max_profit += curr.profit;
            }
        }

        System.out.println("Max Profit: " + max_profit);
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
            
        }
    }
}
