package Greedy_Algorithm;

import java.util.ArrayList;
//Activity Selection
import java.util.Arrays;
import java.util.Comparator;

// You are given n activities with their start and end times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time. Activities are sorted according to end time.
// start = [10, 12, 20]
// end = [20, 25, 30]

// ans = 2 (AO & A2)

public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 }; // Sorted

        // If unsorted then sort them
        int activites[][] = new int[start.length][3];

        for (int i = 0; i < activites.length; i++) {
            activites[i][0] = i;
            activites[i][1] = start[i];
            activites[i][2] = end[i];
        }
        // Sorting activites array based on end[];
        // Compartor.comparingDouble(o->o[2]) - It is a lamda function which gives
        // condition for sorting
        Arrays.sort(activites, Comparator.comparingDouble(o -> o[2]));

        int max_activity = 1; // Store max activities
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(activites[0][0]);
        int last_activity_end = activites[0][2];
        for (int i = 1; i < end.length; i++) {
            if (activites[i][1] >= last_activity_end) {
                max_activity++;
                ans.add(activites[i][0]);
                last_activity_end = activites[i][2];
            }
        }
        System.out.println("Max Acivity: " + max_activity);
        System.out.println("Activites: " );
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(" A" + ans.get(i));
        }
    }
}
