public class MinimumFibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(findMinFibonacciNumbers(110));
    }

    public static int findMinFibonacciNumbers(int k) {
        if (k < 2) return k;
        int a = 1, b = 1;
        while (b <= k) {
            b += a;
            System.out.println(b);
            a = b - a;
            //System.out.println("a is " + a);
        }
        return 1 + findMinFibonacciNumbers(k - a);
    }
}
