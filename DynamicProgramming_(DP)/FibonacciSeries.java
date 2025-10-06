public class FibonacciSeries{
    public static void main(String[] args) {
        System.out.println(fibonacciNumber(5));
    }

    public static int fibonacciNumber(int n){
        if(n==1) return 0;
        if(n==2) return 1;

        return fibonacciNumber(n-1) + fibonacciNumber(n-2);
    }
}