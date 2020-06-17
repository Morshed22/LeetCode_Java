public class ManacherAlgLongestPalimdromeStr {
    // Transform s into t.
    // For example, if s = "abba", then t = "$#a#b#b#a#@"
    // the # are interleaved to avoid even/odd-length palindromes uniformly
    // $ and @ are prepended and appended to each end to avoid bounds checking
    private char[] preprocess(String s) {
        char[] t = new char[s.length() * 2 + 3];
        t[0] = '$';
        t[s.length() * 2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[2 * i + 1] = '#';
            t[2 * i + 2] = s.charAt(i);
        }
        t[s.length() * 2 + 1] = '#';
        return t;
    }

    public String longestPalindrome(String s) {
        char[] charArray = preprocess(s);
        int[] padindromeArray = new int[charArray.length];

        int center = 0, right = 0;
        for (int i = 1; i < charArray.length - 1; i++) {
            int mirror = 2 * center - i;

            if (right > i) {
                padindromeArray[i] = Math.min(right - i, padindromeArray[mirror]);
            }

            // attempt to expand palindrome centered at i
            while (charArray[i + (1 + padindromeArray[i])] == charArray[i - (1 + padindromeArray[i])]) {
                padindromeArray[i]++;
            }

            // if palindrome centered at i expands past right,
            // adjust center based on expanded palindrome.
            if (i + padindromeArray[i] > right) {
                center = i;
                right = i + padindromeArray[i];
            }
        }
        return longestPalindromicSubstring(padindromeArray, s);
    }

    public String longestPalindromicSubstring(int[] p, String s) {
        int length = 0; // length of longest palindromic substring
        int center = 0; // center of longest palindromic substring
        for (int i = 1; i < p.length - 1; i++) {
            if (p[i] > length) {
                length = p[i];
                center = i;
            }
        }
        return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
    }
}
