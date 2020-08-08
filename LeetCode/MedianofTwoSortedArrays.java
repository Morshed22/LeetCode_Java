public class MedianofTwoSortedArrays {

    public static void main(String[] args) {
       System.out.println(findMedianSortedArrays(new int[] {2},new int[] {}));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;

        while (low <= high){
            int partitionX = (low+high)/2;
            int partitionY = (x+y+1)/2 -partitionX;

            int leftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX-1];
            int rightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int leftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY-1];
            int rightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (leftX <= rightY && leftY <= rightX) {
                if ((x+y)%2  == 0){
                    return (Math.max(leftX,leftY) + Math.min(rightX, rightY) )/2.0;
                }else {
                    return Math.max(leftX,leftY);
                }
            }else if (leftX > rightY){
              high = partitionX-1;
            }else {
                low = partitionX+1;
            }

        }

        return 0.0;
    }

}
