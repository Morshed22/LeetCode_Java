import java.lang.reflect.Array;
import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
          if (strs.length == 0)  return new ArrayList<>();
            Map<String, List> ans = new HashMap<String, List>();
            int[] count = new int[26];

            for(String str :strs) {
                Arrays.fill(count, 0);
                for (Character c : str.toCharArray()) {
                    count[c - 'a']++;
                }
                StringBuilder sb = new StringBuilder("");
                for (int i = 0; i < 26; i++) {
                    sb.append("#");
                    sb.append(count[i]);
                }
                String key = sb.toString();
                if (!ans.containsKey(key)) ans.put(key, new ArrayList());
                ans.get(key).add(str);
            }
            return  new ArrayList(ans.values());
        }


        public List<List<String>> groupAnagrams2(String[] strs) {
            if (strs == null || strs.length == 0) return new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                char[] ca = new char[26];
                for (char c : s.toCharArray()) ca[c - 'a']++;
                //System.out.println(Arrays.toString(ca));
                String keyStr = String.valueOf(ca);
                //System.out.println(keyStr);
                if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
                map.get(keyStr).add(s);
            }
            return new ArrayList<>(map.values());
        }
    }
}
