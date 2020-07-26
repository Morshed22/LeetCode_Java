public class MultiplyStrings {
    public static void main(String[] args) {
      Solution soln = new Solution();
       System.out.println(soln.multiply("123","456"));
    }
    static class Solution {
        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) return "0";
            int m = num1.length(); int n = num2.length();
            int product[] = new int [m+n];
            for(int i = m-1; i>= 0; --i){
                for (int j = n-1; j>= 0; --j){
                    int mul = (num1.charAt(i) -'0') * (num2.charAt(j)-'0');
                    int sum = product[i+j+1] + mul;
                    product[i+j] += sum/10;
                    product[i+j+1] = sum%10;
                }
            }
            StringBuilder str = new StringBuilder();
            for(int p :product){
                if (p != 0 || str.length() != 0){
                    str.append(p);
                }
            }
            return str.toString();
        }
    }
}
