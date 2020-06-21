import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FirstAndlastPositionOfSortedArray {
    public static void main(String[] args) {
        FirstAndlastPositionOfSortedArray sortArr = new FirstAndlastPositionOfSortedArray();
        System.out.println(sortArr.searchRange(new int[] {1}, 1));
//        sortArr.searchRange(new int[] {5,7,7,8,8,10}, 8);
    }

    public int[] searchRange(int[] nums, int target) {
        int [] range = new int[] {-1, -1};

        int leftIndex = extremeIndex(nums,target,true);
        if (leftIndex < 0 || (nums[leftIndex] != target)){
            System.out.println(Arrays.toString(range));
            return range;
        }
        range[0] = leftIndex;
        range[1] = extremeIndex(nums,target,false);
        System.out.println(Arrays.toString(range));
        return range;

    }

    public int extremeIndex (int[] nums, int target, boolean isLeft) {

        int low = 0;
        int high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target ) {
                high = mid-1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }else{
                index = mid;
                if (isLeft){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
        }
        return index;
    }

}
