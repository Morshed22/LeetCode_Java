public class Pow {
    public static void main(String[] args) {
       Pow p = new Pow();
       System.out.println(p.myPow(2.00000,-2));
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

}
