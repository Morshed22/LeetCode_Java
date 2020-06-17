import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationPhnNumber {

    private static final String[] Letters = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

    public static List<String> letterCombinations(String digits) {

        if(digits == null || digits.isEmpty()){
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        backTrack(digits, 0, "", res);
        return res;
    }

    private static void backTrack(String digits,int start, String letters, List<String> res){
        if (letters.length() == digits.length()){
            res.add(letters);
            return;
        }
        String current = Letters[digits.charAt(start)-'0'];
        for(char c: current.toCharArray()){

            backTrack(digits, start+1,letters+c, res);
            System.out.println(letters);
        }
    }
}
