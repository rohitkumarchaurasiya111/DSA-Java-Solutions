package Heaps;

import java.util.PriorityQueue;

public class priorityQueue {
    static class Student implements Comparable<Student> {
        int roll;
        String Name;

        public Student(String Name, int roll) {
            this.Name = Name;
            this.roll = roll;
        }

        public int compareTo(Student s2) {
            return this.roll - s2.roll;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(7);
        pq.add(3);
        pq.add(5);
        pq.add(-9);
        pq.add(3);

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }

        // Priority Queue for Object
        System.out.println("For Students: ");
        PriorityQueue<Student> pq2 = new PriorityQueue<>();

        pq2.add(new Student("A", 7));
        pq2.add(new Student("B", 5));
        pq2.add(new Student("C", 1));
        pq2.add(new Student("D", 9));
        pq2.add(new Student("E", 4));

        while (!pq2.isEmpty()) {
            System.out.println(pq2.peek().roll + " -> "+ pq2.peek().Name);
            pq2.remove();
        }

    }
}
