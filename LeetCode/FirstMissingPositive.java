import java.util.Arrays;

public class FirstMissingPositive {
    //For understanding pls go to this link

  //https://www.youtube.com/watch?v=9SnkdYXNIzM

    public static void main(String[] args) {
        FirstMissingPositive postive = new FirstMissingPositive();
        System.out.println(postive.firstMissingPositive(new int[] {7,8,9,11,12}));
    }
    public int firstMissingPositive(int[] nums) {

       if (nums.length == 0){
           return 1;
       }
       int n = nums.length;
       int contains = 0;
       for(int i = 0; i < n; i++){
           if(nums[i] == 1){
               contains = 1;
           }else if(nums[i] <= 0 || nums[i] > n){
               nums[i] = 1;
           }
       }
       if (contains == 0) return 1;

        for(int i = 0; i < n; i++){
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] = -1* nums[index];
        }
        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < n; i++){
            if (nums[i] > 0){
                return i+1;
            }
        }
        return n+1;
    }
}
