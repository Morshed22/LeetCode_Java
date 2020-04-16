public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
    public static int reverse(int x) {
        long reverse = 0;
        while (x != 0){
            int reminder = x%10;
            reverse =  reverse *10 + reminder;
            if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE){
                return  0;
            }
            x /= 10;
        }
        return (int) reverse;
    }

}
