package Bit_Manipulation;

public class Count_Set_bits {
    public static void main(String args[]) {
        int num = 4;
        int count = 0;
        while (num > 0) {
            // if ((num & ((~0) << 1)) != num)
            if ((num & 1) != 0) {
                count++;
            }
            num = num >> 1;
        }
        System.out.println(count);
    }
}
