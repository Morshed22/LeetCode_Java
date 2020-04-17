public class PalinDromeNumber {
    public static void main(String[] args) {
    System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        int input = x;
        int reverse = 0;
        while (input != 0){
           int  remainder = input%10;
             reverse = reverse *10 + remainder;
             input /= 10;
        }
//        System.out.println(reverse);
        return (x == reverse) ;
    }
}
