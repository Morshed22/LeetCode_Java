public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition pos = new SearchInsertPosition();
        System.out.println(pos.searchInsert(new int[] {1},4));
    }
    private int searchInsert(int[] nums, int target) {
           if (nums.length == 0) return -1;
            int low = 0;
            int high = nums.length-1;
            int mid = -1;
            while (low <= high){
                 mid = (low+high)/2;
                if (nums[mid] > target) {
                    high = mid-1;
                }else if (nums[mid] < target){
                    low = mid+1;
                }else{
                    return mid;
                }
            }
            return nums[mid] < target ? high+1 : low;
    }
}
