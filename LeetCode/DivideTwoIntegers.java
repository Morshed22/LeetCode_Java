public class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(10,3));
    }
    static class Solution {
        public int divide(int dividend, int divisor) {
            if(divisor == 0) return Integer.MAX_VALUE;
            if(dividend == 0)  return 0;
            if(divisor == 1) return dividend;
            if(divisor == -1) return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
            final boolean isNegative = (dividend > 0 && divisor < 0) || (dividend <0 && divisor>0);
            long longDividend = Math.abs((long)dividend);
            final long longDivisor = Math.abs((long)divisor);
            int res = 0;
            for(int bit = Integer.SIZE-1; bit >=0 && longDividend >= longDivisor; bit--){
                if(longDividend >= (longDivisor << bit)){
                    System.out.println(res);
                    System.out.println(1<< bit);
                    res |= (1<< bit);
                    longDividend -= (longDivisor << bit);
                }
            }
            return isNegative ? -res :res;
        }
    }
}
