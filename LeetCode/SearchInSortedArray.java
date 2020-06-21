public class SearchInSortedArray {
    public static void main(String[] args) {
       SearchInSortedArray sortTedSearch = new SearchInSortedArray();
       System.out.println(sortTedSearch.search(new int[]{},4));
    }
    private int search(int[] nums, int target){
        if (nums.length == 0) return -1;
        int minIndex = findMinIndex(nums);
        if (target == nums[minIndex]){
            return minIndex;
        }
        int len = nums.length;
        int start = target <= nums[len-1] ? minIndex :0;
        int end = target <= nums[len -1] ? len - 1:minIndex-1;

        while (start <= end) {
            int mid = (start+end)/2;
            if (target == nums[mid]){
                return mid;
            }else if (target < nums[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
    public int findMinIndex(int[] nums){
        int start = 0;
        int end  = nums.length-1;
            while (start < end){
                int mid = (start+end)/2;
                 if (nums[mid] > nums[end]){
                    start = mid+1;
                }else{
                    end = mid;
                }
            }
        return start;
    }
}

