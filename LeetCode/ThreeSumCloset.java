import java.util.Arrays;

public class ThreeSumCloset {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0,2,1,-3}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closest = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && i < 3; i++) {
            closest += nums[i];
        }
        if (nums.length < 3) {
            return closest;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                    if (closest == target) return closest;
                }
                if (sum  > target) hi--;
                 else  lo++;
            }
        }
        return closest;
    }
}

