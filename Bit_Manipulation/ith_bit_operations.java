package Bit_Manipulation;

public class ith_bit_operations {
    public static void main(String args[]) {
        int num = 10;

        // bit begins from 0
        clear_range_of_bits(num, 2, 4);
    }

    public static void clear_range_of_bits(int num, int i, int j) {
        int a = (~0) << j + 1;
        int b = (1 << i) - 1; // ~((~0) << i)
        int bitmask = a | b;
        System.out.println(bitmask);
        num = num & bitmask;
        System.out.println(num);
    }

    public static void clear_last_i_bits(int num, int Last_bits) {
        int bitmask = (-1) << Last_bits + 1; // (~0)<<Last_bits
        num = num & bitmask;
        System.out.println(num);
    }

    public static int update_ith_bit(int num, int position, int Choice) {
        // if (Choice == 1) {
        // set_ith_bit(num, position);
        // } else {
        // clear_ith_bit(num, position);
        // }

        num = clear_ith_bit(num, position);
        int bitMask = Choice << position;
        num = (num | bitMask);
        System.out.println(num);
        return num;

    }

    public static int clear_ith_bit(int num, int position) {
        int bitmask = 1 << position;
        num = num & (~bitmask);
        System.out.println(num);
        return num;
    }

    public static void set_ith_bit(int num, int position) {
        int bitmask = 1 << position;
        num = (num | bitmask);
        System.out.println(num);
    }

    public static void get_ith_bit(int num, int bit) {
        int bitmask = 1 << bit;
        if ((num & bitmask) > 0) {
            System.out.println("The bit at " + bit + " index is: 1");
        } else {
            System.out.println("The bit at " + bit + " index is: 0");
        }
    }
}
