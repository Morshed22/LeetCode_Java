import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {
        int arr[] = new int[] {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arr,2));
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
    public static int removeDuplicates2(int[] nums) {
       int i = 2;
        for (int j = 2; j < nums.length; j++) {
            if (nums[i-2] != nums[j]){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != val){
               nums[i] = nums[j];
               i++;
            }
        }
        return i;
    }

}
