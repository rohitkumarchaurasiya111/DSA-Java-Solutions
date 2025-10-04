package Bit_Manipulation;

public class PowerOF2 {
    public static void main(String args[]) {
        int num = 128;
        int check = 1;
        // for (int i = 1; i <= Math.sqrt(num); i++) {
        //     int temp = 1 << i;
        //     if (temp == num) {
        //         check = 0;
        //         break;
        //     }
        // }

        check = (num & (num-1));
        if (check == 0) {
            System.out.println("Num is the Powerof 2 ");

        } else {
            System.out.println("No, Not the power");
        }

    }
}