package ObjectOrientedProgramming;

public class Static_keyword {
    @SuppressWarnings("static-access") // Due to presence of this it will not show the error that Access in an statical way
    public static void main(String args[]) {
        Student s1 = new Student();
        s1.Name = "Rohit";
        s1.School = "Moonlight"; // can also be written as Student.School -- which is an statical way
        Student s2 = new Student();
        System.out.println(s2.Name);
        System.out.println(s2.School); // As School is static so s2. school also points to the same s1.school
        s2.School = "DAV"; // here once the value of s2.school is changed then the s1.school will also be
                           // changed due to static keyword
        System.out.println(s1.School);
    }
}

class Student {
    String Name;
    int Roll;
    static String School; // Static variable

    // Static function
    static int percentage(int phy, int math, int chem) {
        return (phy + math + chem) / 3;
    }
}