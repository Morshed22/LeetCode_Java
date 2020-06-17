import javax.swing.*;

public class LongestCommonPrefix {

    public static void main(String[] args) {
//        String[] strArray = {"flower","flow","flight"};
        String[] strArray = {"leets", "leetcode", "leetc", "leeds"};
        longestCommonPrefix3(strArray);
    }

    public static String longestCommonPrefix(String[] strs) {
        String comStr = "";
        if (strs.length == 0) {
            return comStr;
        }
        if (strs.length < 2) {
            return strs[0];
        }

        Integer minIndex = 0;
        Integer minCount = Integer.MAX_VALUE;
        Boolean isMatch = true;

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minCount) {
                minCount = strs[i].length();
                minIndex = i;
            }
        }
        String minStr = strs[minIndex];
        for (int i = 0; i < minStr.length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (minStr.charAt(i) == strs[j].charAt(i)) {
                    isMatch = true;
                } else {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                comStr += minStr.charAt(i);
            } else {
                break;
            }
        }
        return comStr;

    }


    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    //{"leet", "leee", {le}, {lrt}}
    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }


    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        System.out.println(str1);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }
}
