import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        Solution s  = new Solution();
        System.out.println(Arrays.toString(s.twoSum(new int[] {2, 7, 11, 15},9)));
    }
   static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int [] arr = new int[2];
            HashMap<Integer, Integer> hash = new HashMap<>();
            for(int i = 0; i < nums.length; i++ ){
                int key = target - nums[i];
                if (hash.containsKey(key)) {
                    arr[0] = hash.get(key);
                    arr[1] = i;
                    return arr;
                }
                hash.put(nums[i],i);
            }
            return arr;
        }
    }
}
