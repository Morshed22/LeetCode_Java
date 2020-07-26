import javax.swing.*;

public class CountAndSay {

    public static void main(String[] args) {
         Solution s = new Solution();
         System.out.println(s.countAndSay(3));
    }

    static class  Solution {

        public String countAndSay(int n) {
            String finalSting = "1";
            if (n == 1) return finalSting;
            int charPointer = 0;
            int countPointer = 0;
            String strProgress = "";

            //for (int i = 2; i < n; i++) {
            while(n>1){
                while (countPointer < finalSting.length()) {
                    while (countPointer < finalSting.length() && finalSting.charAt(charPointer) == finalSting.charAt(countPointer)) {
                         countPointer++;
                    }
                    strProgress += String.valueOf(countPointer - charPointer);
                    strProgress += String.valueOf(finalSting.charAt(charPointer));
                    charPointer = countPointer;
                }
                finalSting = strProgress;
                strProgress = "";
                charPointer = 0;
                countPointer = 0;
                n--;
            }
            return finalSting;
        }
    }
}

