import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
       Solution s = new Solution();
       System.out.println(s.longestValidParenthesesOnline("(()"));
    }
    private static class Solution {
        public int longestValidParentheses(String s) {
            if (s.length() == 0) return -1;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int max = 0;
            for(int i = 0; i < s.length(); i++){
                int top = stack.peek();
                if( top > -1 && s.charAt(top) == '(' && s.charAt(i) == ')'){
                    stack.pop();
                    top = stack.peek();
                    max = Math.max(i-top, max);
                }else {
                    stack.push(i);
                }
            }
            return max;
        }

        public int longestValidParenthesesOnline(String s) {
            if (s == null) return -1;
            if (s.length() == 0) return 0;
            char[] str = s.toCharArray();
            int sum = 0, res = 0, len = 0, n = s.length();
            // Scan the string from left side, plus 1 for '(' and minus 1 for ')'.
            for (int i = 0; i < n; i++) {
                if (str[i] == '(') sum++;
                else sum--;
                if (sum < 0) {
                    sum = 0;
                    len = 0;
                } else {
                    len++;
                    if (sum == 0) res = Math.max(res, len);
                }
            }
            // Scan again from right side, plus 1 for ')' and minus 1 for '('.
            sum = 0;
            len = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (str[i] == ')') sum++;
                else sum--;
                if (sum < 0) {
                    sum = 0;
                    len = 0;
                } else {
                    len++;
                    if (sum == 0) res = Math.max(res, len);
                }
            }
            return res;
        }
    }

}
