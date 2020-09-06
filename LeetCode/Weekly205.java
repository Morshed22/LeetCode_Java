import java.util.Arrays;

public class Weekly205 {
    public static void main(String[] args) {
       modifyString("?a?ub???w?b");
    }
    public static String modifyString(String s) {
        if (s.length() == 1 && s.charAt(0) == '?') return  "a";

        char[] strToArr = s.toCharArray();

        for(int i = 0;  i< s.length(); i++){
            if(s.charAt(i) == '?'){

                for(char alphabet = 'a'; alphabet <='z'; alphabet++ ){
                    if((i == 0 && strToArr[i+1] !=alphabet) || (i == s.length()-1  && strToArr[i-1] != alphabet )){
                        strToArr[i] = alphabet;
                        break;
                    }else if ( i > 0  && i < s.length()-1 && (strToArr[i-1] !=alphabet && strToArr[i+1] !=alphabet)){
                         strToArr[i] = alphabet;
                        break;
                    }
                }
            }
        }
       System.out.println(strToArr);
        return String.valueOf(strToArr);
    }

}
