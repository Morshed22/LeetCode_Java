public class WildcardMatching {
    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.comparison("abcdec","ab*c"));
    }
    static class  Solution {
        public boolean isMatch(String s, String p) {
            if (s.length() == 0 || p.length() == 0) return false;
            int m = s.length();
            int n = p.length();
            boolean[][] match = new boolean[m+1][n+1];
            match[0][0] = true;
            for(int i =1; i<=n; i++){
                if(p.charAt(i-1) == '*'){
                    match[0][i] = true;
                }else {
                    break;
                }
            }

            for(int i = 1; i<= m ; i++){
                for(int j = 1; j<= n; j++){
                  if(p.charAt(j-1) != '*') {
                     match[i][j] = match[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') ;
                  }else {
                      match[i][j] = match[i][j-1] || match[i-1][j];
                  }
                }
            }

            return match[m][n];
        }





        //alternative method for this problem
        boolean comparison(String str, String pattern) {
            int s = 0, p = 0, match = 0, starIdx = -1;
            while (s < str.length()){
                // advancing both pointers
                if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                    s++;
                    p++;
                }
                // * found, only advancing pattern pointer
                else if (p < pattern.length() && pattern.charAt(p) == '*'){
                    starIdx = p;
                    match = s;
                    p++;
                }
                // last pattern pointer was *, advancing string pointer
                else if (starIdx != -1){
                    p = starIdx + 1;
                    match++;
                    s = match;
                }
                //current pattern pointer is not star, last patter pointer was not *
                //characters do not match
                else return false;
            }

            //check for remaining characters in pattern
            while (p < pattern.length() && pattern.charAt(p) == '*')
                p++;

            return p == pattern.length();
        }
    }

}
