import javax.swing.*;

public class CountAndSay {

    public static void main(String[] args) {
         Solution s = new Solution();
         System.out.println(s.countAndSay2(5));
    }

    static class  Solution {

//        public String countAndSay(int n) {
//            String finalSting = "1";
//            if (n == 1) return finalSting;
//            int charPointer = 0;
//            int countPointer = 0;
//            String strProgress = "";
//
//            //for (int i = 2; i < n; i++) {
//            while(n>1){
//                while (countPointer < finalSting.length()) {
//                    while (countPointer < finalSting.length() && finalSting.charAt(charPointer) == finalSting.charAt(countPointer)) {
//                         countPointer++;
//                    }
//                    strProgress += String.valueOf(countPointer - charPointer);
//                    strProgress += String.valueOf(finalSting.charAt(charPointer));
//                    charPointer = countPointer;
//                }
//                finalSting = strProgress;
//                strProgress = "";
//                charPointer = 0;
//                countPointer = 0;
//                n--;
//            }
//            return finalSting;
//        }



        //better approach
        public String countAndSay2(int n) {
            String s = "1";
            for(int i = 1; i < n; i++){
                s = countIdx(s);
            }
            return s;
        }

        public String countIdx(String s){
            StringBuilder sb = new StringBuilder();
            char c = s.charAt(0);
            int count = 1;
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) == c){
                    count++;
                }
                else
                {
                    sb.append(count);
                    sb.append(c);
                    c = s.charAt(i);
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(c);
            return sb.toString();
        }
    }

    }


