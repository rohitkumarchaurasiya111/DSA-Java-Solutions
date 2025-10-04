package ObjectOrientedProgramming;

public class Hybrid_Inheritance {
    public static void main(String args[]){
        Shark s1 = new Shark();
        s1.eat();
    }
}

class Animal{
    void eat(){
        System.out.println("Eat");
    }
}

class Bird extends Animal{
    void fly(){
        System.out.println("FLy");
    }
}

class Fish extends Animal{
    void swim(){
        System.out.println("Swim");
    }
}

class Shark extends Fish{
    
}