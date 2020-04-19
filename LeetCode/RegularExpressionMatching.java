public class RegularExpressionMatching {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        //System.out.println(isMatching("","@*b*"));
        System.out.println(isMatch("aab","c*a*b"));
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
    //using Dynamic programing to solve this problem

    public static boolean isMatch(String s, String p) {
        char [] strArray = s.toCharArray();
        char [] patternArray = p.toCharArray();
        boolean [][] table = new boolean[strArray.length+1][patternArray.length+1];
        table[0][0] = true;

        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i=1; i<table[0].length; i ++){
            if (patternArray[i-1] == '*'){
                table[0][i] = table[0][i-2];
            }
        }
        for (int i = 1; i < table.length; i++){
            for (int j = 1; j<table[0].length; j++){
                if (patternArray[j-1] == '.' || patternArray[j-1] == strArray[i-1]){
                    table[i][j] = table[i-1][j-1];
                }else if (patternArray[j-1] == '*'){
                    table[i][j] = table[i][j-2];
                    if (patternArray[j-2] == strArray[i-1] || patternArray[j-2] == '.'){
                        table[i][j] = table[i][j] | table[i-1][j];
                    }
                }else {
                    table[i][j] = false;
                }
            }
        }
        return table[strArray.length][patternArray.length];
    }
}
