package ObjectOrientedProgramming;

public class Copy_Constructor {
    public static void main(String args[]) {
        Constructor Object1 = new Constructor();
        Object1.Name = "Rohit";
        Object1.age = 20;
        Object1.Marks[1] = 30;
        Object1.Marks[0] = 99;
        Object1.Marks[2] = 80;

        Constructor Object2 = new Constructor(Object1);
        Object1.Marks[0] = 0;

        // Printing the marks
        for (int i = 0; i < Object2.Marks.length; i++) {
            System.out.println(Object2.Marks[i] + " ");
        }
    }
}

class Constructor {
    String Name;
    int age;
    int Marks[];

    Constructor() {
        this.Marks = new int[3];
        System.out.println("It is a Default Constructor");
    }

    // Copy Constructor - Copies the value of Object 1 to a New Object

    // Shallow Copy Constructor i.e Changing the marks i.e array value of Object 1
    // will change the marks of Object 2 as well because the reference address of
    // Object 1 is passed to Object 2

    // Constructor(Constructor Object1) {
    // this.Name = Object1.Name;
    // this.age = Object1.age;
    // this.Marks = Object1.Marks;
    // }

    // Deep Copy Constructor - Here, The marks value doesnot changes
    Constructor(Constructor Object1) {
        this.Name = Object1.Name;
        this.age = Object1.age;
        this.Marks = new int[3];
        for (int i = 0; i < Object1.Marks.length; i++) {
            this.Marks[i] = Object1.Marks[i];
        }

    }

    Constructor(String Name) { // Parameterized Constructor
        this.Name = Name;
    }
}
