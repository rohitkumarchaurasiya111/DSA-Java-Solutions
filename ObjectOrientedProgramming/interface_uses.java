package ObjectOrientedProgramming;


public class interface_uses {
    public static void main(String args[]){
        Beer b = new Beer();
        b.eat();
        b.walk();
    }
}

// This is the One use of Interface to achieve total Abstraction:
interface Animal{
    void walk();
    void eat();
}

class Beer implements Animal{
    public void walk(){
        System.out.println("Beer can walk");
    }
    public void eat(){
        System.out.println("Beer eats!");
    }
}
