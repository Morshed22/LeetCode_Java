import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
      GenerateParentheses gen = new GenerateParentheses();
     // System.out.println(gen.generateParenthesis(3));
        //System.out.println(gen.strStr("mississippi", "issip"));
        System.out.println(gen.kmp("mississippi","ababd"));
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        return backTrack(res,n, "", 0,0);
    }

    public List<String> backTrack(List<String> res, int n, String str, int open, int close){
        if(str.length() == n*2){
            res.add(str);
            return res;
        }
        if(open < n ) backTrack(res, n, str + "(",open+1,close);
        if(close < open ) backTrack(res, n, str + ")",open,close+1);
        return res;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int m = haystack.length();
        int n = needle.length();
        if (m<n) return -1;
        for(int i = 0; i <= m-n; i++){
            int j;
            for( j = 0; j < n; j++){
                if (haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
            }
            if (j == n){
                return i;
            }
        }
        return -1;
    }


    public int kmp(String t, String p) {
        int n = t.length();
        int m = p.length();
        if (m == 0) return 0;

        int[] pi = new int[m];
        computePrefix(p, pi);

        int k = -1;
        for (int i = 0; i < n; i++) {
            while (k >= 0 && p.charAt(k + 1) != t.charAt(i)) {
                k = pi[k];
            }

            if (p.charAt(k + 1) == t.charAt(i)) {
                k++;
            }

            if (k == m - 1) {
                return i - m + 1;
            }
        }

        return -1;
    }

    private void computePrefix(String p, int[] pi) {
        pi[0] = -1;
        int k = -1;
        int m = p.length();
        for (int i = 1; i < m; i++) {
            while (k >= 0 && p.charAt(k + 1) != p.charAt(i)) {
                k = pi[k];
            }
            if (p.charAt(k + 1) == p.charAt(i)) {
                k++;
            }
            pi[i] = k;
        }
    }
}
