package ObjectOrientedProgramming;

public class Multiple_Inheritance {
    public static void main(String args[]) {
        Pigeon p = new Pigeon();
        p.can_fly();
        p.can_walk();
    }
}

interface fly {
    void can_fly();
}

interface walk {
    void can_walk();
}

class Pigeon implements fly, walk {
    public void can_fly() {
        System.out.println("Pigeon can Fly!");
    }

    public void can_walk() {
        System.out.println("Pigeon can walk!");
    }
}
