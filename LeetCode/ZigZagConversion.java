import java.util.Arrays;

public class ZigZagConversion {
    public static void main(String[] args) {
        String str = convert("PAYPALISHIRING", 3);
        System.out.println(str);
    }

    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        char[] charArray = s.toCharArray();
        String[] strArray = new String[numRows];
        Arrays.fill(strArray, "");
        boolean down = true;
        int row = 0;
        String newStr = "";

        for (int i = 0; i < charArray.length; i++) {
            strArray[row] += charArray[i];

            if (row == numRows - 1) {
                down = false;
            } else if (row == 0) {
                down = true;
            }

            if (down) {
                row++;
            } else {
                row--;
            }
        }
        for (int i = 0; i < strArray.length; i++) {
            newStr += strArray[i];
        }
        return newStr;
    }
}
