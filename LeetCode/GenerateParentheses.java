import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
      GenerateParentheses gen = new GenerateParentheses();
      System.out.println(gen.generateParenthesis(3));
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
}
