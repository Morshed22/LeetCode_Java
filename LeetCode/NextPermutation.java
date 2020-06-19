import java.util.Arrays;
//https://leetcode.com/articles/next-permutation/

//https://stackoverflow.com/questions/11483060/stdnext-permutation-implementation-explanation

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation permutation = new NextPermutation();
        int [] arr = {1,1,5};
        permutation.nextPermutation(arr);
    }

    private void reverse (int nums [], int start){
        int i = start, j = nums.length-1;
        while (i<j){
            swap(nums, i,j);
            i++;
            j--;
        }
    }
    private void swap( int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while (i >= 0 && nums[i+1] <= nums[i]){
            i--;
        }
        System.out.println(i);
        if (i >= 0){
            int j = nums.length-1;
            while (j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i,j);
        }
        reverse(nums, i+1);
        //System.out.println(Arrays.toString(nums));
    }
}
