import javax.swing.*;

public class Pow {
    public static void main(String[] args) {
       Pow p = new Pow();
       System.out.println(p.MyPow2(2.00000,7));
    }
    public double myPow(double x, int n) {

        if (n == 0) return 1.0;
        double val = myPow(x, n / 2);

        if (n % 2 == 0){
            return val * val;
        } else if  (n > 0){
            return x * (val * val);
        } else {
            return  (val * val)/x;
        }
    }

    public double MyPow2(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long)n);
        while(absN > 0) {
            System.out.println(absN%2);
            if(absN%2 == 1) ans *= x;
            absN /= 2;
            x *= x;
        }
        return n < 0 ?  1/ans : ans;
    }
}
