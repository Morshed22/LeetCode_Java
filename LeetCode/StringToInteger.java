import javax.swing.*;

public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(myAtoi("4332"
        ));

    }

    public static int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;
        String[] strs = str.split("\\s+");
        String valid = "[0123456789\\-\\+].*", s1 = strs[0];
        if (!s1.matches(valid)) {
            return 0;
        }
        int i = 0, maxlen = String.valueOf(Integer.MAX_VALUE).length();
        long res = 0L;
        boolean neg = false;
        if (!Character.isDigit(s1.charAt(0))) {
            if (s1.charAt(0) == '-') neg = true;
            else if (s1.charAt(0) == '+') {
            }//do nothing
            else return 0;
            i++;
        }
        for (; i < s1.length(); i++) {//skips first char if it is a sign
            char c = s1.charAt(i);
            int len = String.valueOf(res).length(), digit = c - '0';
            if (len > maxlen || !Character.isDigit(c)) break;//found non numeric char
            res *= 10;
            res += digit;
        }
        //do overflow checks
        if (neg) {
            res *= -1;
            res = res < Integer.MIN_VALUE ? Integer.MIN_VALUE : res;
        } else {
            res = res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res;
        }
        return (int) res;

    }
}
