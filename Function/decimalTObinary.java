package Function;

public class decimalTObinary {
    public static void main(String args[]) {
        int deci = 11;
        int binary = 0;
        int i = 0;
        while (deci != 0) {
            int rem = deci % 2;
            deci = deci / 2;
            binary += rem * Math.pow(10, i++);
        }
        System.out.println(binary);
    }
}
