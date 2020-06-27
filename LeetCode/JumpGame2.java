import java.util.Arrays;

public class JumpGame2 {
    public static void main(String[] args) {
        JumpGame2 gm2 = new JumpGame2();
        System.out.println(gm2.jump(new int[]{2,3,1,1,2,4,2,0,1,1}));
    }
    public int jump(int[] nums) {
        if (nums.length < 0 || nums[0] == 0){
            return 0;
        }
        int jumps = 1;
        int maxInterVal = nums[0];
        int nextInterval = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(i+nums[i] > nextInterval){
                nextInterval = i+nums[i];
            }
            if(i == maxInterVal && i!=nums.length-1 ){
                maxInterVal = nextInterval;
                jumps++;
            }
            if(maxInterVal >= nums.length-1){
                break;
            }
        }
        return jumps;
    }

}
