import java.lang.reflect.Array;
import java.util.Arrays;

public class ImplementStrStr {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(patternArray("abcdabca")));
       // System.out.println(strStr("mississippi","pi"));
        System.out.println(usingKMPAlgo("hello","ll"));

    }
    //navive implemetation
     public static  int strStr(String haystack, String needle) {
         if (needle.length() == 0) return 0;
         if (needle.length() > haystack.length()) return -1;
         int res = -1;
         int j = 0;
         for (int i = 0; i < haystack.length(); i++) {
             if (j < needle.length()) {
                 if (haystack.charAt(i) == needle.charAt(j)) {
                     res = i;
                     j++;
                 } else {
                     i = i-j;
                     res = -1;
                     j = 0;

                 }
             } else {
                 return res + 1 - j;
             }
         }
         return  (j == needle.length()) ?  res + 1 - j : -1;
         }


// Using kmp algorithm after watchich Tushar Roy video

   // https://www.youtube.com/watch?v=GTJr8OvyEVQ&t=138s

         public static int usingKMPAlgo(String haystack, String needle){
             if (needle.length() == 0) return 0;
             int m = haystack.length();
             int n = needle.length();
             if (m<n) return -1;
             int [] patternArr = patternArray(needle);
             int p = 0;
             for(int i = 0; i< m;){
                  if( haystack.charAt(i) == needle.charAt(p)){
                      i++;
                      p++;
                  }else {
                      if(p > 0){
                         p = patternArr[p-1];
                      }else {
                         i++;
                      }
                  }
                 if (p == n) return i - p;
             }
             return -1;
         }

         public static int [] patternArray(String pattern){
             int [] arr = new int[pattern.length()];
             int j = 1;
             int i = 0;
             arr[i] = 0;
            while (j < pattern.length()){
                 if(pattern.charAt(j) == pattern.charAt(i)){
                     arr[j] = i+1;
                     j++;
                     i++;
                 }else {
                     if (i > 0) {
                       i = arr[i-1];
                     }else{
                        arr[j] = 0;
                        j++;
                     }
                 }
             }
             return arr;
         }
     }



