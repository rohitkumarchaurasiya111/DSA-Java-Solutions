package Heaps;

import java.util.PriorityQueue;

//Nearby Cars
// We are given N points in a 2D plane which are locations of N cars. If we are at the origin, print the nearest K cars.

public class Nearby_Cars {

    static class Car_details implements Comparable<Car_details> {
        int x;
        int y;
        int distSqr;
        int index;

        public Car_details(int x, int y, int distSqr, int index) {
            this.x = x;
            this.y = y;
            this.distSqr = distSqr;
            this.index = index;
        }

        public int compareTo(Car_details s2) {
            return this.distSqr - s2.distSqr;
        }
    }

    public static void main(String[] args) {
        int pts[][] = { { 3, 3 }, { -1, 5 }, { -2, -8 }, { 8, 9 }, { 0, 0 } };
        int k = 3;

        PriorityQueue<Car_details> pq = new PriorityQueue<>();
        
        for (int i = 0; i < pts.length; i++) {
            int distSqr = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Car_details(pts[i][0], pts[i][1], distSqr, i));
        }

        for (int i = 0; i <= k; i++) {
            Car_details c = pq.remove();
            //PQ always removes on the basis of lower number 
            //So, Lower Distances will be removed first...
            System.out.print("C" + c.index + " ");
        }
    }

}
