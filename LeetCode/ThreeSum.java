import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        System.out.println(threeSum2(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));

//-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6
    }
//leet code solution
    public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
       if (nums.length < 3){
           Collections.emptyList();
       }
        Arrays.sort(nums);
       List<List<Integer>> res = new ArrayList<>();
       for(Integer i = 0; i < nums.length-2; i++){
           // if number > 0  then sum == 0 not be happen
           if (nums[i] > 0){
               break;
           }
           //remove duplicated
           if (i > 0 && nums[i] == nums[i-1]){
               continue;
           }
           int j = i+1;
           int k = nums.length-1;
           while (j<k){
               // if number > 0  then sum == 0 not be happen
               if (nums[i]+nums[j] > 0){
                   break;
               }
               //remove duplicated
               if (j > i+1 && nums[j] == nums[j-1]){
                   j++;
                   continue;
               }
              if(nums[i]+nums[j]+nums[k] < 0){
                 j++ ;
              }else if (nums[i]+nums[j]+nums[k] > 0){
                  k--;
              }else {
                 res.add(Arrays.asList(nums[i], nums[j],nums[k]));
                 j++;
                 k--;
              }
           }
        }
       return res;
    }
}
