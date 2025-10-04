package ObjectOrientedProgramming;

public class methodOverwriting {
    public static void main(String args[]) {
        methodOverwriting object = new methodOverwriting();
        System.out.println(object.sum(2, 3));

        abc obj = new abc();
        System.out.println(obj.sum(9, 10));

    }

    int sum(int a, int b) {
        return a + b;
    }
}

class abc extends methodOverwriting {
    int sum(int a, int b) {
        return 0;
    }
}