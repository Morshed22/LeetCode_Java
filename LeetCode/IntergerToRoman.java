import java.util.HashMap;
import java.util.Map;

public class IntergerToRoman {

    public static void main(String[] args) {
        System.out.println(romanToInt("IX"));
    }

    public static int romanToInt(String s) {
        int value = 0;
        HashMap<String, Integer> romanMap = new HashMap<String, Integer>();
        romanMap.put("IV", 4);
        romanMap.put("V", 5);
        romanMap.put("I", 1);
        romanMap.put("IX", 9);
        romanMap.put("X", 10);
        romanMap.put("XL", 40);
        romanMap.put("L", 50);
        romanMap.put("XC", 90);
        romanMap.put("C", 100);
        romanMap.put("CD", 400);
        romanMap.put("D", 500);
        romanMap.put("CM", 900);
        romanMap.put("M", 1000);
        int i = s.length() - 1;

        while (i > 0) {
            String last = String.valueOf(s.charAt(i));
            String first = String.valueOf(s.charAt(i - 1));

            if (romanMap.get(first + last) != null) {
                value += romanMap.get(first + last);
                i--;
            } else {
                value += romanMap.get(last);
            }
            i--;
        }
        if (i == 0) {
            value += romanMap.get(String.valueOf(s.charAt(i)));
        }
        return value;
    }
    // better approach for this problem
    public String intToRoman(int num) {
        String[][] table =
        {
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"}
        };
        String result = "";
        int count = 0;
        while(num > 0){
            int temp = num % 10;
            result = table[count][temp] + result;
            num /= 10;
            count++;
        }
        return result;
    }



}
