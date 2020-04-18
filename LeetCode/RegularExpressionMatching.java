public class RegularExpressionMatching {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        System.out.println(isMatching("mississippi","mis*is*p*."));
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println(elapsedTime);
    }

    // recursion without 
    public static boolean isMatching(String s, String p){
        if (p.length() == 0) return  (s.length() == 0);
        boolean firstMatch = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*'){
            return  isMatching(s, p.substring(2))  || (firstMatch && isMatching(s.substring(1),p)) ;
        }else {
            return  firstMatch && isMatching(s.substring(1), p.substring(1));
        }
    }

}
