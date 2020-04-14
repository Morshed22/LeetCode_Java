public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(longestPalindrome(""));
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println(elapsedTime);
    }

    public static  String longestPalindrome(String s) {
        int size = s.length();
        if (size == 0 ){
            return "";
        }
        boolean table[][] = new boolean[size][size];

        int maxLength = 1;
        for (int i = 0; i < size; ++i)
            table[i][i] = true;

        int start = 0;
        for (int i = 0; i < size - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }


        for (int range = 3; range <= size; ++range) {

            for (int i = 0; i < size - range + 1; ++i)
            {

                int j = i + range - 1;

                if (table[i + 1][j - 1] && s.charAt(i) ==
                        s.charAt(j)) {
                    table[i][j] = true;

                    if (range > maxLength) {
                        start = i;
                        maxLength = range;
                    }
                }
            }
        }
        return s.substring(start,start+maxLength);
    }
}

