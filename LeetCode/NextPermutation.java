import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//https://leetcode.com/articles/next-permutation/

//https://stackoverflow.com/questions/11483060/stdnext-permutation-implementation-explanation

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation permutation = new NextPermutation();
        int [] arr = {1,1,2};
        //permutation.nextPermutation(arr);
        System.out.println(permutation.permute(arr));
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
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> list = new ArrayList<>();
       return permutationOfList(nums,list, 0, nums.length-1);

    }

    private List<List<Integer>> permutationOfList(int[] nums,List<List<Integer>> list, int l, int r){
        if (l == r){
            List<Integer> newList = new ArrayList<Integer>();
            for (int val:nums) newList.add(val);
            list.add(newList);
            return list;
        }
        for (int i = l; i< nums.length; i++){
            boolean skip = false;
            //for remove duplicates this code has used.
            for(int j = l; j<i; j++){

                if(nums[i] == nums[j]){
                    System.out.println(i);
                skip  = true;
                break;}
            }
            if (skip) continue;
            swap(nums, l,i);
            permutationOfList(nums,list,l+1, r);
            swap(nums, l,i);
        }
        return list;
    }
}
