import java.util.Arrays;

public class ZigZagConversion {
    public static void main(String[] args) {
        String str = zigZagConversation("PAYPALISHIRING", 3);
        System.out.println(str);
    }

    public static String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        String[] strArr = new String[numRows];
        Arrays.fill(strArr,"");
        String str = "";
        boolean down = true;
        int row = 0;
        for(int i = 0; i < s.length(); i++){
            strArr[row] += s.charAt(i);
            if (row == numRows-1){
                down = false;
            }else if(row == 0){
               down = true;
            }

          row += down ? 1 : -1;

        }

        for(int i = 0; i < strArr.length; i++){
           str+= strArr[i];
        }
        return str;
    }
    // better aproach for zigZag conversion
    static String zigZagConversation(String s, int numRows){
        if (numRows <= 1) return s;
        StringBuilder sb = new StringBuilder();
        int interval = 2*numRows - 2;
        for(int row = 0; row < numRows; row++){
            int col = row;
            while (col < s.length()){
                sb.append(s.charAt(col));
             if(row > 0 && row < numRows-1 && col+interval - 2*row < s.length()){
                sb.append(s.charAt(col+interval - 2*row));
            }
            col += interval;
            }
        }
        return sb.toString();
    }

}
