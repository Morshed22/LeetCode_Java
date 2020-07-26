public class WildcardMatching {
    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.isMatch("albmnc","a?b*c"));
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
    }
}
