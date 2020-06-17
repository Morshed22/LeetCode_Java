import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[] {-1,0,1,2,-1,-4},-1));
    }
//   [-1,0,1,2,-1,-4]
//           -1
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        if (nums.length < 4){
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i<nums.length-3; i++){
            if (nums[i] > (target/4.0) ){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int firstTarget = target-nums[i];
            for(int j = i+1; j < nums.length-2; j++){

                if (nums[j] > (firstTarget/3.0) ){
                    break;
                }
                if(j > i+1  && nums[j] == nums[j-1]){
                    continue;
                }
                int newTarget = firstTarget - nums[j];
                int low = j+1;
                int high = nums.length-1;
//                if ( nums[low] > (newTarget/2.0)){
//                    continue;
//                }
//                if(nums[high] > (newTarget/2.0)){
//                    continue;
//                }
                while (low<high){
                    if(low > j+1  && nums[low] == nums[low-1]){
                        low++;
                        continue;
                    }
                    if(high <nums.length-1   && nums[high] == nums[high+1]){
                        high--;
                        continue;
                    }
                   int sum = nums[low]+nums[high];
                   if(sum < newTarget){
                       low++;
                   }else if (sum > newTarget){
                       high--;
                    }else {
                       res.add(Arrays.asList(nums[i], nums[j],nums[low],nums[high]));
                       low++;
                       high--;
                   }
                }
            }
        }
        return res;
    }
}
