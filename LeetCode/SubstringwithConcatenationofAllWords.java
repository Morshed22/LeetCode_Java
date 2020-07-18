import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.findSubstring("barfoothefoobarman",new String[]{"foo","bar"}));
    }
   private static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> ans = new ArrayList<Integer>();
            if( s.length()==0 || words.length==0 ) return ans;
            Map<String, Integer> wordMap = new HashMap<String, Integer>();
            for(String w: words) wordMap.put(w, wordMap.getOrDefault(w, 0)+1 );
            int wLen = words[0].length();
            int wSize = words.length;

            for(int i=0; i<wLen; i++){
                int j = i;
                while( j<=s.length()-wLen*wSize ){
                    Map<String, Integer> countMap = new HashMap<String, Integer>();
                    int wCount = wSize;
                    while( wCount>0 ){
                        String tmpS = s.substring( j+(wCount-1)*wLen,  j+wCount*wLen );
                        System.out.println(tmpS);
                        countMap.put(tmpS, countMap.getOrDefault(tmpS, 0)+1 );
                        if( !wordMap.containsKey(tmpS) || countMap.get(tmpS)>wordMap.get(tmpS) ) break; //fail
                        wCount--;
                    }
                    if( wCount==0 ) ans.add(j);
                    //if wCount==0, advance "wLen" unit; otherwise advanve "wCount*wLen" unit
                    System.out.println(j);
                    j += Math.max(wCount,1)*wLen;
                    //System.out.println(j);
                }
            }
            return ans;
        }
    }
}
