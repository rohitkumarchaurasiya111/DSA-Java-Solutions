package ObjectOrientedProgramming;

public class Super_keyword {
    public static void main(String args[]) {
        Bird b = new Bird();
        System.out.println(b.colour);
    }
}

class Animals {
    String colour;

    Animals() {
        System.out.println("Animal constructor is called");
    }
}

class Bird extends Animals {
    Bird() {
        super(); // IN java even if we don't write this but still it is called automatically
        System.out.println("Bird Constructor is called");
        super.colour = "Brown";

    }

}
