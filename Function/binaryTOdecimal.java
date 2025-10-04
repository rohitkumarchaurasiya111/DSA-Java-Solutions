package Function;

public class binaryTOdecimal {
    public static void main(String args[]) {
        int bin = 1010;
        int dec = 0;
        int i = 0;
        while (bin > 0) {
            int temp = bin % 10;
            bin = bin / 10;
            dec += temp * Math.pow(2, i++);
        }
        System.out.println(dec);
    }
}
