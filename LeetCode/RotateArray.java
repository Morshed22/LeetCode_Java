public class RotateArray {

    public static void main(String[] args) {
        rotate(new int [] {1,2,3,4,5,6,7,8,9} ,3 );
    }

    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }

    public static void rotate(int[] nums, int k) {
        int j = -1;
        int d,temp;
        for (int i = 0; i < gcd(nums.length, k); i++){
            temp = nums[i];
            j = i;
            while(true){
                d = (j+k)%nums.length;
                if (i == d ){
                    break;
                }
                nums[i] = nums[d];
                j = d;
            }
            nums[j] = temp;
        }
        System.out.println(nums);
    }
}
